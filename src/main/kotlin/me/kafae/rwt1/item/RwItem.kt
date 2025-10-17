package me.kafae.rwt1.item

import me.kafae.rwt1.Rwt1
import me.kafae.rwt1.item.materials.RoseGoldArmorMaterial
import me.kafae.rwt1.utils.Logger
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.equipment.EquipmentType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import java.util.function.Function


object RwItem {

    // items
    val ROSE_GOLD_ALLOY: Item = register(
        "rose_gold_alloy",
        ::Item,
        Item.Settings()
    )

    // armor
    val ROSE_GOLD_HELMET: Item = register(
        "rose_gold_helmet",
        ::Item,
        Item.Settings()
            .armor(RoseGoldArmorMaterial.INSTANCE, EquipmentType.HELMET)
            .maxDamage(EquipmentType.HELMET.getMaxDamage(RoseGoldArmorMaterial.BASE_DURABILITY))
    )
    val ROSE_GOLD_CHESTPLATE: Item = register(
        "rose_gold_chestplate",
        ::Item,
        Item.Settings()
            .armor(RoseGoldArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE)
            .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(RoseGoldArmorMaterial.BASE_DURABILITY))
    )
    val ROSE_GOLD_LEGGINGS: Item = register(
        "rose_gold_leggings",
        ::Item,
        Item.Settings()
            .armor(RoseGoldArmorMaterial.INSTANCE, EquipmentType.LEGGINGS)
            .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(RoseGoldArmorMaterial.BASE_DURABILITY))
    )
    val ROSE_GOLD_BOOTS: Item = register(
        "rose_gold_boots",
        ::Item,
        Item.Settings()
            .armor(RoseGoldArmorMaterial.INSTANCE, EquipmentType.BOOTS)
            .maxDamage(EquipmentType.BOOTS.getMaxDamage(RoseGoldArmorMaterial.BASE_DURABILITY))
    )

    private val logger = Logger("rwt1:RwItem")

    private fun register(name: String, itemFactory: Function<Item.Settings, Item>, settings: Item.Settings): Item {
        val itemKey = RegistryKey.of<Item?>(RegistryKeys.ITEM, Identifier.of(Rwt1.ID, name))
        val item = itemFactory.apply(settings.registryKey(itemKey))
        Registry.register(Registries.ITEM, itemKey, item)

        return item
    }

    fun init() {
        logger.info("Registering items.")

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register { entries ->
            entries.add(ROSE_GOLD_ALLOY)
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register { entries ->
            entries.add(ROSE_GOLD_HELMET)
            entries.add(ROSE_GOLD_CHESTPLATE)
            entries.add(ROSE_GOLD_LEGGINGS)
            entries.add(ROSE_GOLD_BOOTS)
        }

        logger.info("Successfully registered ${Registries.ITEM.stream().count()} items.")
    }

}