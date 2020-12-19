package me.pigworlddev.merlin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("merlin.feed")) {
                player.setFoodLevel(20);
            } else {
                player.sendMessage(ChatColor.RED + "You are missing the merlin.feed permission, ask a server owner if you belive this is an error.");
            }


        } else {
            System.err.println("You need to be a player to execute this command.");
        }

        return false;
    }
}
