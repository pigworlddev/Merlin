package me.pigworlddev.merlin.commands;

import me.pigworlddev.merlin.Merlin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Teleport implements CommandExecutor {

    Merlin plugin;

    public Teleport(Merlin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        String missingArgs = plugin.getConfig().getString("missingArgs");
        String missingPerms = plugin.getConfig().getString("missingPermissions");

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("merlin.tp")) {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingArgs));
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);

                    try {
                        player.teleport(target.getLocation());
                        // TODO: Set a message
                    } catch (NullPointerException e) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingArgs));
                    }


                } else if (args.length == 2) {

                    if (player.hasPermission("merlin.tp.others")) {
                        Player playerToSend = Bukkit.getPlayer(args[0]);
                        Player target = Bukkit.getPlayer(args[1]);

                        try {
                            playerToSend.teleport(target.getLocation());
                            // TODO: Set a message
                        } catch (NullPointerException e) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingArgs));
                        }


                    } else {
                        // Missing permissions
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingPerms));

                    }

                }
            } else {
                // Missing permissions
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingPerms));
            }

        } else {
            // Console executing
        }

        return true;
    }
}
