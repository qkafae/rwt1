package me.kafae.rwt1.client.datagen

import me.kafae.rwt1.Rwt1
import me.kafae.rwt1.item.RwItem
import me.kafae.rwt1.item.materials.RoseGoldArmorMaterial
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.client.data.BlockStateModelGenerator
import net.minecraft.client.data.ItemModelGenerator
import net.minecraft.client.data.Models
import net.minecraft.util.Identifier

class ModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {

    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        itemModelGenerator.register(RwItem.ROSE_GOLD_ALLOY, Models.GENERATED)
        itemModelGenerator.register(RwItem.ROSE_GOLD_HELMET, Models.GENERATED)
        itemModelGenerator.register(RwItem.ROSE_GOLD_CHESTPLATE, Models.GENERATED)
        itemModelGenerator.register(RwItem.ROSE_GOLD_LEGGINGS, Models.GENERATED)
        itemModelGenerator.register(RwItem.ROSE_GOLD_BOOTS, Models.GENERATED)
    }

}