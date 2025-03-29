package net.frosted.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.frosted.testmod.block.ModBlocks;
import net.frosted.testmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> RED_KYBER_CRYSTAL = List.of(ModBlocks.RED_KYBER_ORE, ModBlocks.DEEPSLATE_RED_KYBER_ORE);
        List<ItemConvertible> BLUE_KYBER_CRYSTAL = List.of(ModBlocks.BLUE_KYBER_ORE, ModBlocks.DEEPSLATE_BLUE_KYBER_ORE);
        List<ItemConvertible> GREEN_KYBER_CRYSTAL = List.of(ModBlocks.GREEN_KYBER_ORE, ModBlocks.DEEPSLATE_GREEN_KYBER_ORE);
        List<ItemConvertible> RUBY = List.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);

        offerBlasting(recipeExporter, RED_KYBER_CRYSTAL, RecipeCategory.MISC, ModItems.RED_KYBER_CRYSTAL, 0.25f, 200, "red_kyber_crystal");
        offerSmelting(recipeExporter, RED_KYBER_CRYSTAL, RecipeCategory.MISC, ModItems.RED_KYBER_CRYSTAL, 0.25f, 400, "red_kyber_crystal");

        offerBlasting(recipeExporter, BLUE_KYBER_CRYSTAL, RecipeCategory.MISC, ModItems.BLUE_KYBER_CRYSTAL, 0.25f, 200, "blue_kyber_crystal");
        offerSmelting(recipeExporter, BLUE_KYBER_CRYSTAL, RecipeCategory.MISC, ModItems.BLUE_KYBER_CRYSTAL, 0.25f, 400, "blue_kyber_crystal");

        offerBlasting(recipeExporter, GREEN_KYBER_CRYSTAL, RecipeCategory.MISC, ModItems.GREEN_KYBER_CRYSTAL, 0.25f, 200, "blue_kyber_crystal");
        offerSmelting(recipeExporter, GREEN_KYBER_CRYSTAL, RecipeCategory.MISC, ModItems.GREEN_KYBER_CRYSTAL, 0.25f, 400, "blue_kyber_crystal");

        offerBlasting(recipeExporter, RUBY, RecipeCategory.MISC, ModItems.RUBY, 0.25f, 100, "ruby");
        offerSmelting(recipeExporter, RUBY, RecipeCategory.MISC, ModItems.RUBY, 0.25f, 200, "ruby");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FISH_PLUSHIE, 1 )
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .input('@', Items.COD)
                .input('#', Items.WHITE_WOOL)
                .criterion(hasItem(Items.COD), conditionsFromItem(Items.COD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(recipeExporter);

    }
}
