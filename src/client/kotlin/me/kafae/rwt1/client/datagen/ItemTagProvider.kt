package me.kafae.rwt1.client.datagen

import me.kafae.rwt1.item.RwItem
import me.kafae.rwt1.item.materials.armor.RoseGoldArmorMaterial
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.ItemTags
import java.util.concurrent.CompletableFuture

class ItemTagProvider(
    output: FabricDataOutput,
    completableFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricTagProvider.ItemTagProvider(output, completableFuture) {

    override fun configure(wrapperLookup: RegistryWrapper.WrapperLookup?) {
        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
            .add(RwItem.ROSE_GOLD_HELMET)
            .add(RwItem.ROSE_GOLD_CHESTPLATE)
            .add(RwItem.ROSE_GOLD_LEGGINGS)
            .add(RwItem.ROSE_GOLD_BOOTS)

        valueLookupBuilder(ItemTags.HEAD_ARMOR)
            .add(RwItem.ROSE_GOLD_HELMET)

        valueLookupBuilder(ItemTags.CHEST_ARMOR)
            .add(RwItem.ROSE_GOLD_CHESTPLATE)

        valueLookupBuilder(ItemTags.LEG_ARMOR)
            .add(RwItem.ROSE_GOLD_LEGGINGS)

        valueLookupBuilder(ItemTags.FOOT_ARMOR)
            .add(RwItem.ROSE_GOLD_BOOTS)

        valueLookupBuilder(RoseGoldArmorMaterial.REPAIRS_ROSE_GOLD_ARMOR)
            .add(RwItem.ROSE_GOLD_ALLOY)
    }
}