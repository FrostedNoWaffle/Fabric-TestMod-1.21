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
    public static final ItemGroup TESTMOD_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "testmod_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RED_KYBER_CRYSTAL))
                    .displayName(Text.translatable("itemgroup.testmod.testmod_items")).entries((displayContext, entries) -> {
                        entries.add(ModItems.RED_KYBER_CRYSTAL);
                        entries.add(ModItems.BLUE_KYBER_CRYSTAL);
                        entries.add(ModItems.GREEN_KYBER_CRYSTAL);
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.CHISEL);

                        entries.add(ModItems.RUBY_SWORD);
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.RUBY_AXE);
                        entries.add(ModItems.RUBY_SHOVEL);
                        entries.add(ModItems.RUBY_HOE);
                        entries.add(ModItems.PINK_GARNET_HAMMER);

                        entries.add(ModItems.PINK_GARNET_HELMET);
                        entries.add(ModItems.PINK_GARNET_CHESTPLATE);
                        entries.add(ModItems.PINK_GARNET_LEGGINGS);
                        entries.add(ModItems.PINK_GARNET_BOOTS);

                        entries.add(ModItems.PINK_GARNET_HORSE_ARMOR);

                        entries.add(ModItems.KAUPEN_BOW);

                        entries.add(ModItems.BAR_BRAWL_MUSIC_DISC);

                        entries.add(ModItems.CAULIFLOWER_SEEDS);

                        entries.add(ModItems.HONEY_BERRIES);

                        

                    }).build());

    public static final ItemGroup TESTMOD_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "testmod_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.RED_KYBER_ORE))
                    .displayName(Text.translatable("itemgroup.testmod.testmod_blocks")).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RED_KYBER_ORE);
                        entries.add(ModBlocks.BLUE_KYBER_ORE);
                        entries.add(ModBlocks.GREEN_KYBER_ORE);

                        entries.add(ModBlocks.DEEPSLATE_RED_KYBER_ORE);
                        entries.add(ModBlocks.DEEPSLATE_BLUE_KYBER_ORE);
                        entries.add(ModBlocks.DEEPSLATE_GREEN_KYBER_ORE);

                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);

                        entries.add(ModBlocks.MAGIC_BLOCK);
                        entries.add(ModBlocks.RUBY_BLOCK);

                        entries.add(ModBlocks.RUBY_STAIRS);
                        entries.add(ModBlocks.RUBY_SLAB);

                        entries.add(ModBlocks.RUBY_BUTTON);
                        entries.add(ModBlocks.RUBY_PRESSURE_PLATE);

                        entries.add(ModBlocks.RUBY_FENCE);
                        entries.add(ModBlocks.RUBY_FENCE_GATE);
                        entries.add(ModBlocks.RUBY_WALL);

                        entries.add(ModBlocks.RUBY_DOOR);
                        entries.add(ModBlocks.RUBY_TRAPDOOR);

                        entries.add(ModBlocks.PINK_GARNET_LAMP);






                    }).build());

    public static void  registerItemGroups(){
        TestMod.LOGGER.info("Registering Item Groups for " + TestMod.MOD_ID);
    }
}
