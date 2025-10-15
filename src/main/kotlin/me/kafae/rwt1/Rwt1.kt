package me.kafae.rwt1

import me.kafae.rwt1.utils.DataStoreHandler
import me.kafae.rwt1.utils.Logger
import net.fabricmc.api.ModInitializer
import java.nio.file.Path

class Rwt1 : ModInitializer {

    companion object {
        const val ID: String = "rwt1"
    }

    data class PlayerData(
        val teammate: String = ""
    )

    private val logger = Logger(ID)
    private val dataStoreHandler = DataStoreHandler<PlayerData>(
        Path.of("$ID/playerdata"),
        PlayerData(),
        logger
    )

    override fun onInitialize() {
        logger.info("Initialized $ID")
    }

}
