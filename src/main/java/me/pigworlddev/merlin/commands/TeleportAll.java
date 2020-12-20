package me.pigworlddev.merlin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TeleportAll implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("merlin.tpall")) {
                if (Bukkit.getServer().getOnlinePlayers().size() == 1) {
                    player.sendMessage(ChatColor.GREEN + "No other players are on right now.");
                } else if (Bukkit.getServer().getOnlinePlayers().size() > 1) {
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.teleport(player.getLocation());
                    }
                }
            }
        }

        return true;
    }
}
