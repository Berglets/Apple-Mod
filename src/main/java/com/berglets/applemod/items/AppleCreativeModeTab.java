package com.berglets.applemod.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class AppleCreativeModeTab {
	public static final CreativeModeTab APPLE_TAB = new CreativeModeTab("appletab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.ENCHANTED_GOLDEN_APPLE);
		}
	};
}
