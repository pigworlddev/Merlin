package me.pigworlddev.merlin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

    @EventHandler
    void PlayerJoin(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        String displayName = player.getDisplayName();

        e.setQuitMessage(ChatColor.AQUA + "Hope you come back soon,  " + ChatColor.GREEN + displayName);

    }

}
