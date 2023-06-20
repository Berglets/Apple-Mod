package com.berglets.applemod.items;

import com.berglets.applemod.AppleMod;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class ItemGeneration {
	public static final List<RegistryObject<Item>> APPLES = new ArrayList<>();

	//here is where you change their food properties by tag/ however you choose to do that.
	//data gen for the json files (recipes/models, maybe just copy paste for lang,
	public static void generateApples() {
		for(Item item : ForgeRegistries.ITEMS.getValues()) {
			APPLES.add(AppleMod.ITEMS_REGISTER.register(item.getDescriptionId() + "_apple",
					() -> new Item(new Item.Properties().tab(AppleCreativeModeTab.APPLE_TAB))));
		}
	}
}
