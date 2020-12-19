package me.pigworlddev.merlin.events.joinleave;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    void PlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String displayName = player.getDisplayName();

        e.setJoinMessage(ChatColor.AQUA + "Welcome to the server,  " + ChatColor.GREEN + displayName);

    }

}
