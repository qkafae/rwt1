package me.kafae.rwt1.client.datagen

import me.kafae.rwt1.item.RwItem
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.recipe.RecipeExporter
import net.minecraft.data.recipe.RecipeGenerator
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.Items
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture


class RecipeProvider(
    output: FabricDataOutput,
    completableFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricRecipeProvider(output, completableFuture) {

    override fun getRecipeGenerator(wrapperLookup: RegistryWrapper.WrapperLookup, recipeExporter: RecipeExporter): RecipeGenerator {
        return object : RecipeGenerator(wrapperLookup, recipeExporter) {
            override fun generate() {
                val registryLookup = wrapperLookup.getOrThrow(net.minecraft.registry.RegistryKeys.ITEM)

                // rose gold alloy
                ShapedRecipeJsonBuilder.create(
                    registryLookup,
                    RecipeCategory.MISC,
                    RwItem.ROSE_GOLD_ALLOY
                )
                    .pattern("ggg")
                    .pattern("gac")
                    .pattern("ccc")
                    .input('g', Items.GOLD_INGOT)
                    .input('a', Items.AMETHYST_SHARD)
                    .input('c', Items.COPPER_INGOT)
                    .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                    .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                    .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                    .offerTo(recipeExporter)

                // rose gold helmet
                ShapedRecipeJsonBuilder.create(
                    registryLookup,
                    RecipeCategory.COMBAT,
                    RwItem.ROSE_GOLD_HELMET
                )
                    .pattern("rrr")
                    .pattern("rir")
                    .pattern("rrr")
                    .input('r', RwItem.ROSE_GOLD_ALLOY)
                    .input('i', Items.IRON_HELMET)
                    .criterion(hasItem(RwItem.ROSE_GOLD_ALLOY), conditionsFromItem(RwItem.ROSE_GOLD_ALLOY))
                    .criterion(hasItem(Items.IRON_HELMET), conditionsFromItem(Items.IRON_HELMET))
                    .offerTo(recipeExporter)

                // rose gold chestplate
                ShapedRecipeJsonBuilder.create(
                    registryLookup,
                    RecipeCategory.COMBAT,
                    RwItem.ROSE_GOLD_CHESTPLATE
                )
                    .pattern("rrr")
                    .pattern("rir")
                    .pattern("rrr")
                    .input('r', RwItem.ROSE_GOLD_ALLOY)
                    .input('i', Items.IRON_CHESTPLATE)
                    .criterion(hasItem(RwItem.ROSE_GOLD_ALLOY), conditionsFromItem(RwItem.ROSE_GOLD_ALLOY))
                    .criterion(hasItem(Items.IRON_CHESTPLATE), conditionsFromItem(Items.IRON_CHESTPLATE))
                    .offerTo(recipeExporter)

                // rose gold leggings
                ShapedRecipeJsonBuilder.create(
                    registryLookup,
                    RecipeCategory.COMBAT,
                    RwItem.ROSE_GOLD_LEGGINGS
                )
                    .pattern("rrr")
                    .pattern("rir")
                    .pattern("rrr")
                    .input('r', RwItem.ROSE_GOLD_ALLOY)
                    .input('i', Items.IRON_LEGGINGS)
                    .criterion(hasItem(RwItem.ROSE_GOLD_ALLOY), conditionsFromItem(RwItem.ROSE_GOLD_ALLOY))
                    .criterion(hasItem(Items.IRON_LEGGINGS), conditionsFromItem(Items.IRON_LEGGINGS))
                    .offerTo(recipeExporter)

                // rose gold boots
                ShapedRecipeJsonBuilder.create(
                    registryLookup,
                    RecipeCategory.COMBAT,
                    RwItem.ROSE_GOLD_BOOTS
                )
                    .pattern("rrr")
                    .pattern("rir")
                    .pattern("rrr")
                    .input('r', RwItem.ROSE_GOLD_ALLOY)
                    .input('i', Items.IRON_BOOTS)
                    .criterion(hasItem(RwItem.ROSE_GOLD_ALLOY), conditionsFromItem(RwItem.ROSE_GOLD_ALLOY))
                    .criterion(hasItem(Items.IRON_BOOTS), conditionsFromItem(Items.IRON_BOOTS))
                    .offerTo(recipeExporter)
            }
        }
    }

    override fun getName(): String {
        return ""
    }

}