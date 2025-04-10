package net.frosted.testmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.frosted.testmod.datagen.*;
import net.frosted.testmod.enchantment.ModEnchantments;
import net.frosted.testmod.trim.ModTrimMaterials;
import net.frosted.testmod.trim.ModTrimPatterns;
import net.frosted.testmod.world.ModConfiguredFeatures;
import net.frosted.testmod.world.ModPlacedFeatures;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class TestModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		 FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		 pack.addProvider(ModBlockTagProvider::new);
		 pack.addProvider(ModItemTagProvider::new);
		 pack.addProvider(ModLootTableTagProvider::new);
		 pack.addProvider(ModModelProvider::new);
		 pack.addProvider(ModRecipeProvider::new);
		 pack.addProvider(ModRegistryDataGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.TRIM_MATERIAL, ModTrimMaterials::boostrap);
		registryBuilder.addRegistry(RegistryKeys.TRIM_PATTERN, ModTrimPatterns::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, ModEnchantments::bootstrap);

		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
