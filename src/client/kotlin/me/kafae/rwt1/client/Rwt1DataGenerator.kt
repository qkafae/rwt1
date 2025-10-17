package me.kafae.rwt1.client

import me.kafae.rwt1.client.datagen.*
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

class Rwt1DataGenerator : DataGeneratorEntrypoint {

    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val pack = fabricDataGenerator.createPack()

        pack.addProvider(::ModelProvider)
        pack.addProvider(::ItemTagProvider)
        pack.addProvider(::RecipeProvider)
    }
}
