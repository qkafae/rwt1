package me.kafae.rwt1.item.materials.armor

import me.kafae.rwt1.Rwt1
import net.minecraft.item.Item
import net.minecraft.item.equipment.ArmorMaterial
import net.minecraft.item.equipment.EquipmentAsset
import net.minecraft.item.equipment.EquipmentAssetKeys
import net.minecraft.item.equipment.EquipmentType
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.tag.TagKey
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Identifier
import java.util.Map

object RoseGoldArmorMaterial {

    const val BASE_DURABILITY: Int = 24
    val ROSE_GOLD_ARMOR_MATERIAL_KEY: RegistryKey<EquipmentAsset> = RegistryKey.of(
        EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(
            Rwt1.Companion.ID, "rose_gold"));
    val REPAIRS_ROSE_GOLD_ARMOR: TagKey<Item> = TagKey.of(Registries.ITEM.getKey(), Identifier.of(Rwt1.Companion.ID, "repairs_rose_gold_armor"));

    val INSTANCE: ArmorMaterial = ArmorMaterial(
        BASE_DURABILITY,
        Map.of<EquipmentType, Int>(
            EquipmentType.HELMET, 3,
            EquipmentType.CHESTPLATE, 4,
            EquipmentType.LEGGINGS, 4,
            EquipmentType.BOOTS, 3
        ),
        15,
        SoundEvents.ITEM_ARMOR_EQUIP_COPPER,
        0.0f,
        0.0f,
        REPAIRS_ROSE_GOLD_ARMOR,
        ROSE_GOLD_ARMOR_MATERIAL_KEY
    )
}