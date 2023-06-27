package com.berglets.applemod.util;

import com.berglets.applemod.items.Apples;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;
import java.util.function.Function;

/**
 * Server-side utility class to quickly get the apple information for any registered item.
 * Uses caching and static initializers to create caches.
 *
 * @author Kevin Cuellar
 * @version June 26, 2023
 */
public final class AppleUtil {

	private static final Map<Item, Item> CACHE_IMAGE = new HashMap<>(); //maps any in game item to an apple item
	private static final Map<Item, String> CACHE_FOOD_PROPERTIES = new HashMap<>();

	private static final List<Function<Item, Item>> ITEM_FUNCTIONS = new ArrayList<>();

	/**
	 * Returns the correct registered apple item for image purposes
	 *
	 * @param surrounding the item surrounding the apple
	 * @return The apple version of the given item
	 */
	public static Item getAppleImage(Item surrounding) {
		return CACHE_IMAGE.getOrDefault(surrounding, Apples.DEFAULT_APPLE);
	}

	/**
	 * Returns the NBT data for the correct FoodProperties.Builder so that the server can pass it onto the client
	 * to generate the FoodProperties.
	 *
	 * @param surrounding the item surrounding the apple
	 * @return the NBT data for the correct FoodProperties.Builder
	 */
	public static String getFoodBuilder(Item surrounding) {
		return CACHE_FOOD_PROPERTIES.getOrDefault(surrounding, CACHE_FOOD_PROPERTIES.getOrDefault(getAppleImage(surrounding), "default_apple"));
	}

	private static boolean areEqual(Item item1, Item item2) {
		return item1.getDescriptionId().equals(item2.getDescriptionId());
	}

	private static boolean containsText(Item item, String text) {
		return item.getDescriptionId().contains(text) || item.getDescription().getString().contains(text);
	}

	private static boolean hasTag(Item item, TagKey<Item> tag) {
		ItemStack stack = new ItemStack(item, 1);
		return stack.is(tag);
	}

	private static void determineAppleImages(Collection<Item> items) {
		for(Item item : items) {
			Item appleItem = null;
			for(Function<Item, Item> func : ITEM_FUNCTIONS) {
				appleItem = func.apply(item);
				if(appleItem != null)
					break;
			}
			CACHE_IMAGE.put(item, appleItem);
		}
	}

	//These determine which apple image an item gets classified into
	static {
		ITEM_FUNCTIONS.add((i) -> containsText(i, "diamond") ? Apples.DIAMOND_APPLE : null);
		ITEM_FUNCTIONS.add((i) -> containsText(i, "copper") || areEqual(i, Items.LIGHTNING_ROD) ? Apples.COPPER_APPLE : null);
		ITEM_FUNCTIONS.add((i) -> containsText(i, "dirt") || containsText(i, "sand") || containsText(i, "mud") || areEqual(i, Items.PODZOL) ? Apples.DIRT_APPLE : null);
		ITEM_FUNCTIONS.add((i) -> i.getFoodProperties() != null ? Apples.FOOD_APPLE : null);
		ITEM_FUNCTIONS.add((i) -> containsText(i, "emerald") ? Apples.EMERALD_APPLE : null);
		ITEM_FUNCTIONS.add((i) -> containsText(i, "glass") ? Apples.GLASS_APPLE : null);
		ITEM_FUNCTIONS.add((i) -> containsText(i, "iron") ? Apples.IRON_APPLE : null);
		ITEM_FUNCTIONS.add((i) -> containsText(i, "netherite") || areEqual(i, Items.ANCIENT_DEBRIS) ? Apples.NETHERITE_APPLE : null);
		ITEM_FUNCTIONS.add((i) -> hasTag(i, Tags.Items.SEEDS) || containsText(i, "grass") || containsText(i, "leaves") ||
				containsText(i, "sapling")? Apples.PLANT_APPLE : null);
		ITEM_FUNCTIONS.add((i) -> hasTag(i, Tags.Items.DYES) || containsText(i, "wool") || containsText(i, "carpet") ||
				containsText(i, "bed") || containsText(i, "banner") || containsText(i, "candle") ? Apples.RAINBOW_APPLE : null);
		ITEM_FUNCTIONS.add((i) -> containsText(i, "redstone") ? Apples.REDSTONE_APPLE : null);
		ITEM_FUNCTIONS.add((i) -> hasTag(i, Tags.Items.STONE) || containsText(i, "stone") && !containsText(i, "red") ? Apples.STONE_APPLE : null);
		ITEM_FUNCTIONS.add((i) -> containsText(i, "prismarine") || containsText(i, "lapis") || areEqual(i, Items.WATER_BUCKET) ? Apples.WATER_APPLE : null);
		ITEM_FUNCTIONS.add((i) ->
				hasTag(i, Tags.Items.RODS_WOODEN) || hasTag(i, Tags.Items.FENCES_WOODEN)  ||
						hasTag(i, Tags.Items.FENCE_GATES_WOODEN) || hasTag(i, Tags.Items.CHESTS_WOODEN) ||
						hasTag(i, Tags.Items.BARRELS_WOODEN) || containsText(i, "planks") ||
						containsText(i, "log") || containsText(i, "wood") || areEqual(i, Items.CRAFTING_TABLE) ||
						containsText(i, "boat") || containsText(i, "sign") ? Apples.WOOD_APPLE : null
		);
		determineAppleImages(ForgeRegistries.ITEMS.getValues());
	}

	// This determines the FoodProperties NBT data for each apple
	// Allows for special items to create apples with different FoodProperties
	static {
		//defaults
		CACHE_FOOD_PROPERTIES.put(Apples.COPPER_APPLE, "copper_apple");
		CACHE_FOOD_PROPERTIES.put(Apples.DIAMOND_APPLE, "diamond_apple");
		CACHE_FOOD_PROPERTIES.put(Apples.DIRT_APPLE, "dirt_apple");
		CACHE_FOOD_PROPERTIES.put(Apples.EMERALD_APPLE, "emerald_apple");
		CACHE_FOOD_PROPERTIES.put(Apples.FOOD_APPLE, "food_apple");
		CACHE_FOOD_PROPERTIES.put(Apples.GLASS_APPLE, "glass_apple");
		CACHE_FOOD_PROPERTIES.put(Apples.IRON_APPLE, "iron_apple");
		CACHE_FOOD_PROPERTIES.put(Apples.NETHERITE_APPLE, "netherite_apple");
		CACHE_FOOD_PROPERTIES.put(Apples.PLANT_APPLE, "plant_apple");
		CACHE_FOOD_PROPERTIES.put(Apples.RAINBOW_APPLE, "rainbow_apple");
		CACHE_FOOD_PROPERTIES.put(Apples.REDSTONE_APPLE, "redstone_apple");
		CACHE_FOOD_PROPERTIES.put(Apples.STONE_APPLE, "stone_apple");
		CACHE_FOOD_PROPERTIES.put(Apples.WATER_APPLE, "water_apple");
		CACHE_FOOD_PROPERTIES.put(Apples.WOOD_APPLE, "wood_apple");
		//specials
		CACHE_FOOD_PROPERTIES.put(Items.DIAMOND_BLOCK, "diamond_block");
		CACHE_FOOD_PROPERTIES.put(Items.NETHERITE_BLOCK, "netherite_block");
	}
}
