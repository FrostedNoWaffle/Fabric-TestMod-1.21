package net.frosted.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.frosted.testmod.block.ModBlocks;
import net.frosted.testmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableTagProvider extends FabricBlockLootTableProvider {
    public ModLootTableTagProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RED_KYBER_ORE, oreDrops(ModBlocks.RED_KYBER_ORE, ModItems.RED_KYBER_CRYSTAL));
        addDrop(ModBlocks.BLUE_KYBER_ORE, oreDrops(ModBlocks.BLUE_KYBER_ORE, ModItems.BLUE_KYBER_CRYSTAL));
        addDrop(ModBlocks.GREEN_KYBER_ORE, oreDrops(ModBlocks.GREEN_KYBER_ORE, ModItems.GREEN_KYBER_CRYSTAL));
        addDrop(ModBlocks.DEEPSLATE_RED_KYBER_ORE, oreDrops(ModBlocks.DEEPSLATE_RED_KYBER_ORE, ModItems.RED_KYBER_CRYSTAL));
        addDrop(ModBlocks.DEEPSLATE_BLUE_KYBER_ORE, oreDrops(ModBlocks.DEEPSLATE_BLUE_KYBER_ORE, ModItems.BLUE_KYBER_CRYSTAL));
        addDrop(ModBlocks.DEEPSLATE_GREEN_KYBER_ORE, oreDrops(ModBlocks.DEEPSLATE_GREEN_KYBER_ORE, ModItems.GREEN_KYBER_CRYSTAL));
        addDrop(ModBlocks.FISH_PLUSHIE);
        addDrop(ModBlocks.RUBY_BLOCK);

        addDrop(ModBlocks.RUBY_ORE, multipleOreDrops(ModBlocks.RUBY_ORE, ModItems.RUBY, 1, 1));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RUBY, 1, 1));

        addDrop(ModBlocks.RUBY_STAIRS);
        addDrop(ModBlocks.RUBY_SLAB, slabDrops(ModBlocks.RUBY_SLAB));

        addDrop(ModBlocks.RUBY_BUTTON);
        addDrop(ModBlocks.RUBY_PRESSURE_PLATE);

        addDrop(ModBlocks.RUBY_DOOR, doorDrops(ModBlocks.RUBY_DOOR));
        addDrop(ModBlocks.RUBY_TRAPDOOR);

        addDrop(ModBlocks.RUBY_WALL);
        addDrop(ModBlocks.RUBY_FENCE);
        addDrop(ModBlocks.RUBY_FENCE_GATE);

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));

    }
}
