package com.berglets.applemod.items;

import com.berglets.applemod.AppleMod;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemGeneration {
	public static final BiMap<RegistryObject<Item>, Item> APPLES = HashBiMap.create(); //apple item to original
	//here is where you change their food properties by tag/ however you choose to do that.
	//data gen for the json files (recipes/models, maybe just copy paste for lang,
	public static void generateApples() {
		for(Item item : ForgeRegistries.ITEMS.getValues()) {
			if(isInvalidItem(item))
				continue;

			APPLES.put(AppleMod.ITEMS_REGISTER.register(item.getDescriptionId() + "_apple",
					() -> new AppleItem(new Item.Properties().tab(AppleCreativeModeTab.APPLE_TAB), item)), item);
		}
	}

	public static boolean isInvalidItem(Item item) {
		if(item.equals(Items.ENCHANTED_GOLDEN_APPLE) || item.equals(Items.GOLDEN_APPLE) ||
			item.equals(Items.GOLD_INGOT) || item.equals(Items.APPLE) || item.equals(Items.AIR)) {
			return true;
		}
		return false;
	}

}
