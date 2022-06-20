package me.laont.sotify

import me.laont.sotify.command.SotifyCommand
import me.laont.sotify.listener.BedListener
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bstats.bukkit.Metrics
import org.bukkit.plugin.java.JavaPlugin

class Sotify : JavaPlugin() {
    lateinit var mm: MiniMessage

    override fun onEnable() {
        Metrics(this, 15521)
        saveDefaultConfig()

        this.mm = MiniMessage.miniMessage()

        server.pluginManager.registerEvents(BedListener(this), this)

        getCommand("sotify")?.setExecutor(SotifyCommand(this))
    }
}
