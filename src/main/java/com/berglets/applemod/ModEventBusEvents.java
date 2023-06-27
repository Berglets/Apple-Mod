package com.berglets.applemod;

import com.berglets.applemod.items.Apples;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

/**
 * Class used to catch certain forge events.
 *
 * @author Kevin Cuellar
 * @version June 26, 2023
 */
@Mod.EventBusSubscriber(modid = AppleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

	/**
	 * This event is fired when Forge is ready to register items.
	 */
	@SubscribeEvent
	public static void registerItemsEvent(@Nonnull final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(Apples.DEFAULT_APPLE, Apples.COPPER_APPLE, Apples.DIAMOND_APPLE, Apples.DIRT_APPLE,
				Apples.EMERALD_APPLE, Apples.FOOD_APPLE, Apples.GLASS_APPLE, Apples.IRON_APPLE, Apples.NETHERITE_APPLE,
				Apples.PLANT_APPLE, Apples.RAINBOW_APPLE, Apples.REDSTONE_APPLE, Apples.STONE_APPLE, Apples.WATER_APPLE,
				Apples.WOOD_APPLE);
	}
}
