package me.pigworlddev.merlin.commands;

import me.pigworlddev.merlin.Merlin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class God implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            Plugin plugin = Merlin.getPlugin(Merlin.class);

            String missingPermission = plugin.getConfig().getString("missingPermission");
            String noLongerInvulnerable = plugin.getConfig().getString("noLongerInvulnerable");
            String nowInvulnerable = plugin.getConfig().getString("nowInvulnerable");
            String gotInvulnerable = plugin.getConfig().getString("gotInvulnerable");
            String gotUnInvulnerable = plugin.getConfig().getString("gotUnInvulnerable");
            String missingArgs = plugin.getConfig().getString("missingArgs");

            if (args.length == 0) {
                if (player.hasPermission("merlin.god")) {
                    if (player.isInvulnerable()) {
                        player.setInvulnerable(false);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', noLongerInvulnerable));
                    } else {
                        player.setInvulnerable(true);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', nowInvulnerable));
                    }
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingPermission));
                }
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (player.hasPermission("merlin.god.others")) {
                    if (target instanceof Player) {
                        if (target.isInvulnerable()) {
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&', gotUnInvulnerable));
                            target.setInvulnerable(true);
                        } else {
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&', gotInvulnerable));
                            target.setInvulnerable(true);
                        }

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
