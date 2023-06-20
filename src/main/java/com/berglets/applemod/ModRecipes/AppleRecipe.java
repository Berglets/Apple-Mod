package com.berglets.applemod.ModRecipes;

import com.berglets.applemod.AppleMod;
import com.berglets.applemod.items.ItemGeneration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class AppleRecipe extends CustomRecipe {
	public AppleRecipe(ResourceLocation p_43833_) {
		super(p_43833_);
	}

	@Override
	public boolean matches(CraftingContainer container, Level level) {
		ItemStack surrounding = null; //surrounding item

		if(container.getWidth() == 3 && container.getHeight() == 3) {
			for(int i = 0; i < container.getWidth(); ++i) {
				for(int j = 0; j < container.getHeight(); ++j) {
					ItemStack itemstack = container.getItem(i + j * container.getWidth());

					if(itemstack.isEmpty()) {
						return false;
					}

					if(surrounding == null) {
						surrounding = itemstack;
					}

					if(i == 1 && j == 1) {
						if(!itemstack.is(Items.APPLE)) {
							return false;
						}
					} else if (!itemstack.is(surrounding.getItem())) {
						return false;
					}
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public ItemStack assemble(CraftingContainer container) {
		Item surrounding = container.getItem(1).getItem();
		Item result = ItemGeneration.APPLES.inverse().get(surrounding).get();
		return new ItemStack(result, 1);
	}

	@Override
	public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
		return  true;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return AppleMod.APPLE_RECIPE.get();
	}
}
