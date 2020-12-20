package me.pigworlddev.merlin.events;

import me.pigworlddev.merlin.Merlin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    Merlin plugin;

    public PlayerJoin(Merlin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        for (int i = 0; i < plugin.invisible_list.size(); i++) {
            player.hidePlayer(plugin, plugin.invisible_list.get(i));
        }

        String joinMessage = plugin.getConfig().getString("joinMessage");

        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', joinMessage));
    }

}
