package me.pigworlddev.merlin.commands;

import me.pigworlddev.merlin.Merlin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Feed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin plugin = Merlin.getPlugin(Merlin.class);

        if (sender instanceof Player) {
            Player player = (Player) sender;

            String fedYourself = plugin.getConfig().getString("fedYourself");
            String missingPermission = plugin.getConfig().getString("missingPermission");
            String missingArgs = plugin.getConfig().getString("missingArgs");
            String gettingFed = plugin.getConfig().getString("gettingKilledMSG");
            String fedPlayer = plugin.getConfig().getString("fedPlayer");

            if (args.length == 0) {

                if (player.hasPermission("merlin.feed")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', fedYourself));
                    player.setFoodLevel(20);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingPermission));
                }

            } else {

                if (player.hasPermission("merlin.feed.others")) {
                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target instanceof Player) {

                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', gettingFed));
                        target.setFoodLevel(20);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', fedPlayer));

                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingArgs));
                    }
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingPermission));
                }

            }
        }

        return true;
    }
}
