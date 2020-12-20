package me.pigworlddev.merlin.events;

import me.pigworlddev.merlin.Merlin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.plugin.Plugin;

public class PlayerLeaveBed implements Listener {


    Plugin plugin = Merlin.getPlugin(Merlin.class);

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        String displayName = player.getDisplayName();

        String exitMessage = plugin.getConfig().getString("playerQuitBedMessage");

        player.sendMessage(ChatColor.translateAlternateColorCodes('&', exitMessage));


    }

}
