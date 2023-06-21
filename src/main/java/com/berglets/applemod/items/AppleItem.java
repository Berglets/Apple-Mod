package com.berglets.applemod.items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.*;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class AppleItem extends Item {

	public AppleItem(Properties p_41383_) {
		super(p_41383_);
	}

	@Override
	public Component getName(ItemStack stack) {
		CompoundTag tag = stack.getTag();
		if(!stack.hasTag() || !tag.contains("applemod.name"))
			return new TranslatableComponent("Default Apple");
		return new TranslatableComponent(tag.getString("applemod.name"));
	}

	@Override
	public boolean isEdible() {
		return true;
	}

	//foodproperties change based on itemstack properties
	@Override
	public FoodProperties getFoodProperties(ItemStack stack, @Nullable LivingEntity entity) {
		if(stack.hasTag() && stack.getTag().contains("thing")) {
			return new FoodProperties.Builder().saturationMod(0.1F).nutrition(5).build();
		}
		return new FoodProperties.Builder().saturationMod(0.1F).nutrition(1).build();
	}

}
