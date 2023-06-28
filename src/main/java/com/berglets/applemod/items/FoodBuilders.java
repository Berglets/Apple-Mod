package com.berglets.applemod.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

/**
 * Holds the base FoodProperties.Builder instances for items to modify
 *
 * @author Kevin Cuellar
 * @version June 26, 2023
 */
public final class FoodBuilders {
	public static final FoodProperties.Builder DEFAULT = new FoodProperties.Builder().saturationMod(0.4f).nutrition(6).alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 3), 0.5F)
			.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200, 1), 0.5F);

	public static final FoodProperties.Builder COPPER = new FoodProperties.Builder().saturationMod(1.2f).nutrition(4).alwaysEat()
			.effect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.JUMP, 400, 4), 1.0F)
			.effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 0), 1.0F)
			.effect(new MobEffectInstance(MobEffects.ABSORPTION, 400, 2), 1.0F);

	public static final FoodProperties.Builder DIAMOND = new FoodProperties.Builder().saturationMod(1.2f).nutrition(4).alwaysEat()
			.effect(new MobEffectInstance(MobEffects.REGENERATION, 700, 2), 1.0F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 12000, 2), 1.0F)
			.effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 12000, 2), 1.0F)
			.effect(new MobEffectInstance(MobEffects.ABSORPTION, 4400, 4), 1.0F);

	public static final FoodProperties.Builder ENCHANTED_DIAMOND = new FoodProperties.Builder().saturationMod(1.2f).nutrition(4).alwaysEat()
			.effect(new MobEffectInstance(MobEffects.REGENERATION, 1000, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 12000, 2), 1.0F)
			.effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 12000, 2), 1.0F)
			.effect(new MobEffectInstance(MobEffects.ABSORPTION, 4400, 4), 1.0F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000, 1), 1.0F);

	public static final FoodProperties.Builder NETHERITE = new FoodProperties.Builder().saturationMod(1.2f).nutrition(4).alwaysEat()
			.effect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 12000, 2), 1.0F)
			.effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 12000, 2), 1.0F)
			.effect(new MobEffectInstance(MobEffects.ABSORPTION, 4400, 4), 1.0F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000, 1), 1.0F);

	public static final FoodProperties.Builder ENCHANTED_NETHERITE = new FoodProperties.Builder().saturationMod(1.2f).nutrition(4).alwaysEat()
			.effect(new MobEffectInstance(MobEffects.REGENERATION, 1200, 2), 1.0F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 12000, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 12000, 2), 1.0F)
			.effect(new MobEffectInstance(MobEffects.ABSORPTION, 5000, 3), 1.0F)
			.effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 2), 1.0F)
			.effect(new MobEffectInstance(MobEffects.DIG_SPEED, 12000, 2), 1.0F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.JUMP, 6000, 1), 1.0F);

	public static final FoodProperties.Builder DIRT = new FoodProperties.Builder().saturationMod(0f).nutrition(1)
			.effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 2), 0.75F)
			.effect(new MobEffectInstance(MobEffects.POISON, 200, 0), 0.25F);

	public static final FoodProperties.Builder STONE = new FoodProperties.Builder().saturationMod(0f).nutrition(1)
			.effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 2), 1.0F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 1), 1.0F);

	public static final FoodProperties.Builder PLANT = new FoodProperties.Builder().saturationMod(0.4f).nutrition(5)
			.effect(new MobEffectInstance(MobEffects.LUCK, 600, 0), 1.0F)
			.effect(new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.25F);

	public static final FoodProperties.Builder WOODEN = new FoodProperties.Builder().saturationMod(0.2f).nutrition(2)
			.effect(new MobEffectInstance(MobEffects.ABSORPTION, 300, 0), 1.0F)
			.effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.25F);

	public static final FoodProperties.Builder EMERALD = new FoodProperties.Builder().saturationMod(1.2f).nutrition(4).alwaysEat()
			.effect(new MobEffectInstance(MobEffects.REGENERATION, 80, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 1), 1.0F);

	public static final FoodProperties.Builder FOOD = new FoodProperties.Builder().saturationMod(1.2f).nutrition(10)
			.effect(new MobEffectInstance(MobEffects.SATURATION, 1600, 2), 1.0F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 1), 1.0F);

	public static final FoodProperties.Builder GLASS = new FoodProperties.Builder().saturationMod(0f).nutrition(1)
			.effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 2), 1.0F)
			.effect(new MobEffectInstance(MobEffects.POISON, 200, 0), 1.0F)
			.effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 800, 4), 1.0F)
			.effect(new MobEffectInstance(MobEffects.DIG_SPEED, 800, 2), 1.0F);

	public static final FoodProperties.Builder IRON = new FoodProperties.Builder().saturationMod(1.2f).nutrition(4).alwaysEat()
			.effect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.JUMP, 400, 4), 1.0F)
			.effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 0), 1.0F)
			.effect(new MobEffectInstance(MobEffects.ABSORPTION, 400, 2), 1.0F);

	public static final FoodProperties.Builder RAINBOW = new FoodProperties.Builder().saturationMod(1.2f).nutrition(4).alwaysEat()
			.effect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 0.1F)
			.effect(new MobEffectInstance(MobEffects.JUMP, 400, 1), 0.1F)
			.effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1), 0.1F)
			.effect(new MobEffectInstance(MobEffects.ABSORPTION, 400, 1), 0.1F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 1), 0.1F)
			.effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 1), 0.1F)
			.effect(new MobEffectInstance(MobEffects.SATURATION, 400, 1), 0.1F)
			.effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 400, 1), 0.1F);

	public static final FoodProperties.Builder REDSTONE = new FoodProperties.Builder().saturationMod(1.2f).nutrition(4).alwaysEat()
			.effect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.JUMP, 400, 4), 1.0F)
			.effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 0), 1.0F)
			.effect(new MobEffectInstance(MobEffects.ABSORPTION, 400, 2), 1.0F);

	public static final FoodProperties.Builder WATER = new FoodProperties.Builder().saturationMod(1.2f).nutrition(4).alwaysEat()
			.effect(new MobEffectInstance(MobEffects.REGENERATION, 80, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 1000, 1), 1.0F);
}
