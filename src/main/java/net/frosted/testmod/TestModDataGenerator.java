package net.frosted.testmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.frosted.testmod.datagen.*;

public class TestModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		 FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		 pack.addProvider(ModBlockTagProvider::new);
		 pack.addProvider(ModItemTagProvider::new);
		 pack.addProvider(ModLootTableTagProvider::new);
		 pack.addProvider(ModModelProvider::new);
		 pack.addProvider(ModRecipeProvider::new);
	}
}
