package com.berglets.applemod.items;

import net.minecraft.network.chat.*;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class AppleItem extends Item {

	private Item orig;
	private Component name;

	public AppleItem(Properties p_41383_, Item orig) {
		super(p_41383_);
		String origName = new ItemStack(orig, 1).getDisplayName().getString();
		origName = origName.substring(1, origName.length()-1);
		name = new TranslatableComponent(origName + " Apple");
		this.orig = orig;
	}

	@Override
	public Component getName(ItemStack stack) {
		return name;
	}

}
