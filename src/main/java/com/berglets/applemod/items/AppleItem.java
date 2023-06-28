package com.berglets.applemod.items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

/**
 * Determines the properties for any custom AppleItem in the game.
 *
 * @author Kevin Cuellar
 * @version June 26, 2023
 */
public class AppleItem extends Item {

	/**
	 * Internally registers this Item
	 * @param p_41383_ item registry location
	 */
	public AppleItem(Properties p_41383_) {
		super(p_41383_);
	}

	/**
	 * Creates the item display name based on NBT data in the ItemStack
	 * @param stack the in game item stack
	 * @return text component representing this Item's display name
	 */
	@Override
	public Component getName(ItemStack stack) {
		CompoundTag tag = stack.getTag();
		if(!stack.hasTag() || !tag.contains("applemod.name"))
			return new TranslatableComponent(stack.getDescriptionId());
		return new TranslatableComponent(tag.getString("applemod.name"));
	}

	/**
	 * Overridden to allow apples to be edible
	 * @return true
	 */
	@Override
	public boolean isEdible() {
		return true;
	}

	/**
	 * Used for special apples only, determined by NBT data of the ItemStack.
	 *
	 * @param stack the in game item stack
	 * @return true if the item should have the foil glow
	 */
	@Override
	public boolean isFoil(ItemStack stack) {
		CompoundTag tag = stack.getTag();
		if(stack.hasTag() && tag.contains("applemod.foil")) {
			return tag.getBoolean("applemod.foil");
		}
		return super.isFoil(stack);
	}

	/**
	 * Determines this item's FoodProperties based on its NBT data.
	 *
	 * @param stack The ItemStack the entity wants to eat.
	 * @param entity The entity which wants to eat the food.
	 * @return
	 */
	@Override
	public FoodProperties getFoodProperties(ItemStack stack, @Nullable LivingEntity entity) {
		FoodProperties.Builder builder = FoodBuilders.DEFAULT;

		CompoundTag tag = stack.getTag();
		if(stack.hasTag() && tag.contains("applemod.food")) {
			builder = getBaseBuilder(tag.getString("applemod.food"));
		}

		return builder.build();
	}

	/**
	 * Retrieves the correct base FoodProperties.Builder from the NBT data given by the server.
	 *
	 * @param tag the tag value from the TagKey "applemod.food"
	 * @return the base FoodProperties.Builder for this apple
	 */
	private static FoodProperties.Builder getBaseBuilder(String tag) {
		switch(tag) {
			case "copper_apple" : return FoodBuilders.COPPER;
			case "diamond_apple" : return FoodBuilders.DIAMOND;
			case "dirt_apple" : return FoodBuilders.DIRT;
			case "emerald_apple" : return FoodBuilders.EMERALD;
			case "food_apple" : return FoodBuilders.FOOD;
			case "glass_apple" : return FoodBuilders.GLASS;
			case "iron_apple" : return FoodBuilders.IRON;
			case "netherite_apple" : return FoodBuilders.NETHERITE;
			case "plant_apple" : return FoodBuilders.PLANT;
			case "rainbow_apple" : return FoodBuilders.RAINBOW;
			case "redstone_apple" : return FoodBuilders.REDSTONE;
			case "stone_apple" : return FoodBuilders.STONE;
			case "water_apple" : return FoodBuilders.WATER;
			case "wood_apple" : return FoodBuilders.WOODEN;
			case "netherite_block" : return FoodBuilders.ENCHANTED_NETHERITE;
			case "diamond_block": return FoodBuilders.ENCHANTED_DIAMOND;
			default: return FoodBuilders.DEFAULT;
		}
	}

}
