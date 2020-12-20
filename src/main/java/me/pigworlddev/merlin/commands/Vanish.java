package me.pigworlddev.merlin.commands;

import me.pigworlddev.merlin.Merlin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Vanish implements CommandExecutor {

    Merlin plugin;

    public Vanish(Merlin plugin) {
        this.plugin = plugin;
    }

    public Vanish() {
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {


        String noLongerVanish = plugin.getConfig().getString("noLongerVanish");
        String nowVanish = plugin.getConfig().getString("nowVanish");
        String missingPermission = plugin.getConfig().getString("missingPermission");

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("merlin.vanish")) {
                if (plugin.invisible_list.contains(player)) {
                    plugin.invisible_list.remove(player);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', noLongerVanish));
                } else if (!plugin.invisible_list.contains(player)) {
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        people.hidePlayer(plugin, player);
                    }
                    plugin.invisible_list.add(player);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', nowVanish));
                }
            } else {
                // Missing permissions
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingPermission));
            }
        } else {
            // Console typed the command
            System.err.println("[Merlin] Console can't run that command.");
        }

        return true;
    }
}
