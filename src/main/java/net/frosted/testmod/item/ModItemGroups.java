package net.frosted.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.frosted.testmod.TestMod;
import net.frosted.testmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup KYBER_CRYSTAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "kyber_crystals"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RED_KYBER_CRYSTAL))
                    .displayName(Text.translatable("itemgroup.testmod.kyber_crystals")).entries((displayContext, entries) -> {
                        entries.add(ModItems.RED_KYBER_CRYSTAL);
                        entries.add(ModItems.BLUE_KYBER_CRYSTAL);
                        entries.add(ModItems.GREEN_KYBER_CRYSTAL);

                    }).build());

    public static final ItemGroup KYBER_ORE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "kyber_ores"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.RED_KYBER_ORE))
                    .displayName(Text.translatable("itemgroup.testmod.kyber_ores")).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RED_KYBER_ORE);
                        entries.add(ModBlocks.BLUE_KYBER_ORE);
                        entries.add(ModBlocks.GREEN_KYBER_ORE);
                        entries.add(ModBlocks.MAGIC_BLOCK);

                    }).build());

    public static final ItemGroup LIGHTSABERS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "lightsabers"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RED_LIGHTSABER))
                    .displayName(Text.translatable("itemgroup.testmod.lightsabers")).entries((displayContext, entries) -> {
                        entries.add(ModItems.RED_LIGHTSABER);
                        entries.add(ModItems.CHISEL);


                    }).build());

    public static void  registerItemGroups(){
        TestMod.LOGGER.info("Registering Item Groups for " + TestMod.MOD_ID);
    }
}
