package com.berglets.applemod;

import com.berglets.applemod.items.AppleRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Main mod class that registers to the Forge event bus.
 *
 * @author Kevin Cuellar
 * @version June 26, 2023
 */
@Mod(AppleMod.MOD_ID)
public class AppleMod
{
    public static final String MOD_ID = "applemod";

    public static final DeferredRegister<RecipeSerializer<?>> APPLE_RECIPE_REGISTER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AppleMod.MOD_ID);

    public static final RegistryObject<SimpleRecipeSerializer<AppleRecipe>> APPLE_RECIPE =
            APPLE_RECIPE_REGISTER.register("crafting_apples", () -> new SimpleRecipeSerializer<>(AppleRecipe::new));

    public AppleMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);

        APPLE_RECIPE_REGISTER.register(eventBus);
    }
}
