package me.pigworlddev.merlin.events;

import me.pigworlddev.merlin.Merlin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class PlayerLeave implements Listener {

    Plugin plugin = Merlin.getPlugin(Merlin.class);

    @EventHandler
    void PlayerJoin(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        String displayName = player.getDisplayName();

        String quitMessage = plugin.getConfig().getString("quitMessage");

        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', quitMessage));

    }

}
