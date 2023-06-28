package com.berglets.applemod.items;

import com.berglets.applemod.AppleMod;
import com.berglets.applemod.util.AppleUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

/**
 * Determines the actual custom apple recipe in code rather than through JSON files. Still needs a RecipeSerializer.
 * Done this way to allow for a dynamic recipe.
 *
 * @author Kevin Cuellar
 * @version June 26, 2023
 */
public class AppleRecipe extends CustomRecipe {

	/**
	 * Internally registers this Recipe
	 * @param p_43833_ item registry location
	 */
	public AppleRecipe(ResourceLocation p_43833_) {
		super(p_43833_);
	}

	/**
	 * Returns true if this recipe configuration should create an AppleItem for this RecipeSerializer.
	 * Specifically, an apple must be surrounded by 8 of the same item for it to return true.
	 *
	 * @param container the container used to craft this recipe
	 * @param level the in-game level
	 * @return true if an apple is surrounded by 8 of the same item
	 */
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

	/**
	 * Creates the apple ItemStack to be returned from the crafting recipe. Gives the item NBT data
	 * to change display name and food properties.
	 *
	 * @param container the container used to craft this recipe
	 * @return the apple to return from this recipe
	 */
	@Override
	public ItemStack assemble(CraftingContainer container) {
		Item surrounding = container.getItem(1).getItem();
		if(surrounding == Items.GOLD_BLOCK)
			return new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 1);

		//insert correct image/item
		Item appleItem = AppleUtil.getAppleImage(surrounding);
		//correct NBT tag with name and food properties
		CompoundTag tag = new CompoundTag();
		tag.putString("applemod.food", AppleUtil.getFoodBuilder(surrounding)); //insert food properties as NBT data
		tag.putString("applemod.name", surrounding.getDescription().getString() + " Apple"); //insert correct apple name
		tag.putBoolean("applemod.foil", surrounding == Items.DIAMOND_BLOCK || surrounding == Items.NETHERITE_BLOCK ? true : false);
		//create apple item
		ItemStack stack = new ItemStack(appleItem == null ? Apples.DEFAULT_APPLE : appleItem, 1);
		stack.setTag(tag);

		return stack;
	}

	/**
	 * Allows the apple RecipeSerializer to be read in any dimension
	 */
	@Override
	public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
		return true;
	}

	/**
	 * Returns the custom apple serializer
	 * @return the custom apple serializer
	 */
	@Override
	public RecipeSerializer<?> getSerializer() {
		return AppleMod.APPLE_RECIPE.get();
	}
}
