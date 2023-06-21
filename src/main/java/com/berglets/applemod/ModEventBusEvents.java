package com.berglets.applemod;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AppleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
	@SubscribeEvent
	public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
		//Try the regular ass registry the way its done is registry serializer, also look into anvil for.
	}

	@SubscribeEvent
	public static void onModelBakeEvent(ModelBakeEvent event)
	{
	}
}
