package me.kafae.rwt1.client.datagen

import me.kafae.rwt1.Rwt1
import me.kafae.rwt1.item.RwItem
import me.kafae.rwt1.item.materials.armor.RoseGoldArmorMaterial
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
        // items
        itemModelGenerator.register(RwItem.ROSE_GOLD_ALLOY, Models.GENERATED)

        // armor
        itemModelGenerator.registerArmor(RwItem.ROSE_GOLD_HELMET,
            RoseGoldArmorMaterial.ROSE_GOLD_ARMOR_MATERIAL_KEY,
            Identifier.of("minecraft", "trims/items/helmet_trim"),
            false
        )
        itemModelGenerator.registerArmor(
            RwItem.ROSE_GOLD_CHESTPLATE,
            RoseGoldArmorMaterial.ROSE_GOLD_ARMOR_MATERIAL_KEY,
            Identifier.of("minecraft", "trims/items/chestplate_trim"),
            false
        )
        itemModelGenerator.registerArmor(
            RwItem.ROSE_GOLD_LEGGINGS,
            RoseGoldArmorMaterial.ROSE_GOLD_ARMOR_MATERIAL_KEY,
            Identifier.of("minecraft", "trims/items/leggings_trim"),
            false
        )
        itemModelGenerator.registerArmor(
            RwItem.ROSE_GOLD_BOOTS,
            RoseGoldArmorMaterial.ROSE_GOLD_ARMOR_MATERIAL_KEY,
            Identifier.of("minecraft", "trims/items/boots_trim"),
            false
        )
    }

}