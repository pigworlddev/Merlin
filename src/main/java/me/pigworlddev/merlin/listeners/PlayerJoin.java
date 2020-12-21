package me.pigworlddev.merlin.listeners;

import me.pigworlddev.merlin.Merlin;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;


public class PlayerJoin implements Listener {

    Merlin plugin;

    public PlayerJoin(Merlin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        PersistentDataContainer data = p.getPersistentDataContainer();

        if (!data.has(new NamespacedKey(Merlin.getPlugin(), "vault"), PersistentDataType.STRING)) {
            data.set(new NamespacedKey(Merlin.getPlugin(), "vault"), PersistentDataType.STRING, "");
        }

        for (int i = 0; i < plugin.invisible_list.size(); i++) {
            p.hidePlayer(plugin, plugin.invisible_list.get(i));
        }

        String joinMessage = plugin.getConfig().getString("joinMessage");

        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', joinMessage));

        if (plugin.getConfig().getBoolean("motd")) {
            for (int i = 0; i < plugin.getConfig().getList("motd-message").size(); i++) {

                String motdMessage = plugin.getConfig().getList("motd-message").get(i).toString();
                p.sendMessage(motdMessage);
            }
        }
    }

}
