package me.laont.sotify.listener

import me.laont.sotify.Sotify
import me.laont.sotify.util.Message
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent
import org.bukkit.event.player.PlayerBedLeaveEvent

class BedListener(private val sotify: Sotify): Listener {
    @EventHandler
    fun onBedEnter(event: PlayerBedEnterEvent) {
        if (event.bedEnterResult == PlayerBedEnterEvent.BedEnterResult.OK) {
            Message(event, sotify).broadcast()
        }
    }

    @EventHandler
    fun onBedLeave(event: PlayerBedLeaveEvent) {
        Message(event, sotify).broadcast()
    }
}