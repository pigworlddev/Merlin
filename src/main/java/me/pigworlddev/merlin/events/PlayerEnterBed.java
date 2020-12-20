package me.pigworlddev.merlin.events;

import me.pigworlddev.merlin.Merlin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.Plugin;

public class PlayerEnterBed implements Listener {

    Plugin plugin = Merlin.getPlugin(Merlin.class);

    @EventHandler
    public void onEnterBed(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        String displayName = player.getDisplayName();

        String enterMessage = plugin.getConfig().getString("playerEnterBedMessage");

        player.sendMessage(ChatColor.translateAlternateColorCodes('&', enterMessage));


    }

}
