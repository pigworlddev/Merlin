package me.pigworlddev.merlin.commands;

import me.pigworlddev.merlin.Merlin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Kill implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Plugin plugin = Merlin.getPlugin(Merlin.class);

        if (sender instanceof Player) {
            Player player = (Player) sender;

            String killedYourself = plugin.getConfig().getString("killedYourself");
            String missingPermission = plugin.getConfig().getString("missingPermission");
            String missingArgs = plugin.getConfig().getString("missingArgs");
            String gettingKilledMSG = plugin.getConfig().getString("gettingKilledMSG");
            String killedPlayer = plugin.getConfig().getString("killedPlayer");

            if (args.length == 0) {

                if (player.hasPermission("merlin.kill")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', killedYourself));
                    player.setHealth(0);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingPermission));
                }

            } else {

                if (player.hasPermission("merlin.kill.others")) {
                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target instanceof Player) {

                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', gettingKilledMSG));
                        target.setHealth(0);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', killedPlayer));

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
