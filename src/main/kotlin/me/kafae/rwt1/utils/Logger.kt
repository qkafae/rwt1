package me.kafae.rwt1.utils

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class Logger(val id: String) {

    private val logger: Logger = LogManager.getLogger(id)

    fun info(msg: String) = logger.info("[$id] $msg")
    fun warn(msg: String) = logger.warn("[$id] $msg")
    fun error(msg: String) = logger.error("[$id] $msg")
    fun debug(msg: String) = logger.debug("[DEBUG][$id] $msg")

}