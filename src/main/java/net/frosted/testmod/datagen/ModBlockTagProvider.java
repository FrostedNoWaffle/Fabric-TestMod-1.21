package net.frosted.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.frosted.testmod.block.ModBlocks;
import net.frosted.testmod.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RED_KYBER_ORE)
                .add(ModBlocks.BLUE_KYBER_ORE)
                .add(ModBlocks.GREEN_KYBER_ORE)
                .add(ModBlocks.DEEPSLATE_RED_KYBER_ORE)
                .add(ModBlocks.DEEPSLATE_BLUE_KYBER_ORE)
                .add(ModBlocks.DEEPSLATE_GREEN_KYBER_ORE)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.RUBY_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RED_KYBER_ORE)
                .add(ModBlocks.BLUE_KYBER_ORE)
                .add(ModBlocks.GREEN_KYBER_ORE)
                .add(ModBlocks.DEEPSLATE_RED_KYBER_ORE)
                .add(ModBlocks.DEEPSLATE_BLUE_KYBER_ORE)
                .add(ModBlocks.DEEPSLATE_GREEN_KYBER_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.RUBY_BLOCK);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.RUBY_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.RUBY_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.RUBY_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
    }
}
