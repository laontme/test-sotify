package me.laont.sotify.util

import me.laont.sotify.Sotify
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerBedEnterEvent
import org.bukkit.event.player.PlayerBedLeaveEvent
import org.bukkit.event.player.PlayerEvent

class Message(private val event: PlayerEvent, private val sotify: Sotify) {
    private val message: Component

    init {
        val component = when (event) {
            is PlayerBedEnterEvent -> sotify.config.getString("messages.player-enter-bed")
            is PlayerBedLeaveEvent -> sotify.config.getString("messages.player-leave-bed")
            else -> "CHE ZA HUYNYA BLYAT"
        }!!

        val placeholders = arrayOf(
            Placeholder.unparsed("player", event.player.name),
            Placeholder.unparsed("sleeping", "x"),
            Placeholder.unparsed("needed", "y"),
            Placeholder.unparsed("more", "z"),
        )

        message = sotify.mm.deserialize(component, *placeholders);
    }

    fun broadcast() {
        sotify.server.broadcast(message)
    }
}