package net.frosted.testmod.enchantment;

import com.mojang.serialization.MapCodec;
import net.frosted.testmod.TestMod;
import net.frosted.testmod.enchantment.custom.LightingStrikerEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_STRIKER =
            registerEntityEffect("lighting_striker", LightingStrikerEnchantmentEffect.CODEC);


    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec){
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(TestMod.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        TestMod.LOGGER.info("Registering Mod Enchantment Effects for " + TestMod.MOD_ID);
    }
}
