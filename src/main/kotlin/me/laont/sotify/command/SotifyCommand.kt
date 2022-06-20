package me.laont.sotify.command

import me.laont.sotify.Sotify
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class SotifyCommand(private val sotify: Sotify) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val message = sotify.mm.deserialize(
            listOf(
                "<dark_aqua>",
                "[Sotify] ${sotify.description.description!!}",
                "<newline>",
                "[Sotify] Version ${sotify.description.version}",
                "<newline>",
                "[Sotify] Author ${sotify.description.authors.joinToString()}",
                "<newline>",
                if (sender.hasPermission("sotify")) {
                    "[Sotify] Configuration reloaded"
                } else {
                    "[Sotify] You do not have permission to reload configuration"
                },
                "</dark_aqua>",
            ).joinToString("")
        )

        if (sender.hasPermission("sotify")) {
            sotify.reloadConfig()
        }

        sender.sendMessage(message)

        return true
    }
}