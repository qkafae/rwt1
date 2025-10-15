package me.kafae.rwt1.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.exists

class DataStoreHandler<T>(
    val dir: Path,
    val template: T,
    val logger: Logger
) {

    private val gson: Gson = GsonBuilder().setPrettyPrinting().create()

    val stores: MutableMap<String, T> = mutableMapOf()

    private fun newTemplate(): T {
        val json = gson.toJson(template)
        val instance = gson.fromJson(json, template!!::class.java) as T
        return instance
    }

    /**
     * Loads a saved data object into memory (or creates a new one if it does not already exist)
     * @param id Identifier for the data
     * @return Returns the data object
     */
    fun load(id: String): T {
        var data: T

        try {
            val f: Path = dir.resolve("$id.json")
            if (!f.exists()) {
                logger.warn("Could not find data with id $id, creating new data instead.")
                data = newTemplate()
            } else {
                val jstring = Files.readString(f)
                val type = template?.let { it::class.java }
                data = gson.fromJson(jstring, type) as T
                logger.info("Found and loaded data with id $id.")
            }
        } catch (e: Exception) {
            logger.warn("Error occurred when loading data with id $id, creating new data instead.")
            data = newTemplate()
        }

        set(id, data)
        return data
    }

    /**
     * Saves a preloaded data object into a json file (or saves a fresh data object if the requested data object is not found)
     * @param id Identifier for the data
     */
    fun save(id: String) {
        save(id, false)
    }

    /**
     * Saves a preloaded data object into a json file (or saves a fresh data object if the requested data object is not found)
     * @param id Identifier for the data
     * @param incremental Whether it is an incremental save or not (will be kept in memory or not)
     */
    fun save(id: String, incremental: Boolean) {
        var data: T

        if (!stores.contains(id)) {
            logger.error("Could not find preloaded data with id $id, saving new data instead.")
            data = newTemplate()
        } else {
            data = get(id)
        }

        val f = dir.resolve("${id}.json").toFile()
        f.writeText(gson.toJson(data))
        if (!incremental) {
            stores.remove(id)
            return
        }
        return
    }

    /**
     * Get data with specific identifier
     * @param id Identifier for the data
     */
    fun get(id: String): T {
        var data: T

        if (!stores.contains(id)) {
            logger.error("Could not find preloaded data with id $id, using new data instead.")
            data = newTemplate()
        } else {
            data = stores[id] as T
        }

        return data
    }

    /**
     * Set data with specific identifier
     * @param id Identifier for the data
     */
    fun set(id: String, data: T) {
        stores[id] = data
    }

}