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

import java.util.ArrayList;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Plugin plugin = Merlin.getPlugin(Merlin.class);

        ArrayList<Player> list_of_flying_players = new ArrayList<>();
        String missingPermission = plugin.getConfig().getString("missingPermissions");
        String nowFlyingMSG = plugin.getConfig().getString("nowFlyingMSG");
        String nowNotFlyingMSG = plugin.getConfig().getString("nowNotFlyingMSG");

        Player player = (Player) sender;

        if (sender instanceof Player) {
            if (args.length == 0) {
                if (player.hasPermission("merlin.fly")) {


                    if (list_of_flying_players.contains(player)) {
                        player.setAllowFlight(false);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', nowNotFlyingMSG));
                        list_of_flying_players.remove(player);

                    } else if (!list_of_flying_players.contains(player)) {
                        player.setAllowFlight(true);
                        list_of_flying_players.add(player);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', nowFlyingMSG));
                    }

                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingPermission));
                }
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);

                if (player.hasPermission("merlin.fly.others")) {
                    if (sender instanceof Player) {
                        if (list_of_flying_players.contains(target)) {
                            target.setAllowFlight(false);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&', nowNotFlyingMSG));
                            list_of_flying_players.remove(target);
                        } else if (!list_of_flying_players.contains(target)) {
                            target.setAllowFlight(true);
                            list_of_flying_players.add(target);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&', nowFlyingMSG));
                        }
                    }
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingPermission));
                }
            }
        }


        return true;
    }
}
