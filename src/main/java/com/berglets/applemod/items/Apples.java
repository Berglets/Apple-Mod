package com.berglets.applemod.items;

import com.berglets.applemod.AppleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/**
 * Holds every AppleItem instance and the unique CreativeModeTab instance
 *
 * @author Kevin Cuellar
 * @version June 26, 2023
 */
public final class Apples {

	public static final CreativeModeTab APPLE_TAB = new CreativeModeTab("appletab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.ENCHANTED_GOLDEN_APPLE);
		}
	};

	public static final Item DEFAULT_APPLE = new AppleItem(prop()).setRegistryName(name("default_apple"));
	public static final Item COPPER_APPLE = new AppleItem(prop()).setRegistryName(name("copper_apple"));
	public static final Item DIAMOND_APPLE = new AppleItem(prop()).setRegistryName(name("diamond_apple"));
	public static final Item DIRT_APPLE = new AppleItem(prop()).setRegistryName(name("dirt_apple"));
	public static final Item EMERALD_APPLE = new AppleItem(prop()).setRegistryName(name("emerald_apple"));
	public static final Item FOOD_APPLE = new AppleItem(prop()).setRegistryName(name("food_apple"));
	public static final Item GLASS_APPLE = new AppleItem(prop()).setRegistryName(name("glass_apple"));
	public static final Item IRON_APPLE = new AppleItem(prop()).setRegistryName(name("iron_apple"));
	public static final Item NETHERITE_APPLE = new AppleItem(prop()).setRegistryName(name("netherite_apple"));
	public static final Item PLANT_APPLE = new AppleItem(prop()).setRegistryName(name("plant_apple"));
	public static final Item RAINBOW_APPLE = new AppleItem(prop()).setRegistryName(name("rainbow_apple"));
	public static final Item REDSTONE_APPLE = new AppleItem(prop()).setRegistryName(name("redstone_apple"));
	public static final Item STONE_APPLE = new AppleItem(prop()).setRegistryName(name("stone_apple"));
	public static final Item WATER_APPLE = new AppleItem(prop()).setRegistryName(name("water_apple"));
	public static final Item WOOD_APPLE = new AppleItem(prop()).setRegistryName(name("wood_apple"));

	private static Item.Properties prop() {
		return new Item.Properties().tab(APPLE_TAB);
	}

	private static ResourceLocation name(String loc) {
		return new ResourceLocation(AppleMod.MOD_ID, loc);
	}

}
