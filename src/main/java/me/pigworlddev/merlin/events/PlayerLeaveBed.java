package me.pigworlddev.merlin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class PlayerLeaveBed implements Listener {

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        String displayName = player.getDisplayName();

        player.sendMessage(ChatColor.AQUA + "Good Morning, " + displayName + " hope you slept well.");


    }

}
