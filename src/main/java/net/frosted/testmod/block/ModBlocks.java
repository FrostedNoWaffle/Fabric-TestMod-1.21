package net.frosted.testmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.frosted.testmod.TestMod;
import net.frosted.testmod.block.custom.MagicBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block RED_KYBER_ORE = registerBlock("red_kyber_ore",
        new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                AbstractBlock.Settings.create()
                .strength(4f)
                .requiresTool()
                .sounds(BlockSoundGroup.STONE)));

    public static final Block BLUE_KYBER_ORE = registerBlock("blue_kyber_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block GREEN_KYBER_ORE = registerBlock("green_kyber_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.STONE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.WART_BLOCK)));

    public static final Block FISH_PLUSHIE = registerBlock("fish_plushie",
            new Block(AbstractBlock.Settings.create()
                    .strength(0.1f)
                    .sounds(BlockSoundGroup.WOOL)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TestMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        TestMod.LOGGER.info("Registering Mod Blocks for" + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.RED_KYBER_ORE);
            fabricItemGroupEntries.add(ModBlocks.BLUE_KYBER_ORE);
            fabricItemGroupEntries.add(ModBlocks.GREEN_KYBER_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.FISH_PLUSHIE);
        });
    }
}
