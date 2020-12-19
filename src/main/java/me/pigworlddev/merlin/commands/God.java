package me.pigworlddev.merlin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class God implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("merlin.god")) {
                if (player.isInvulnerable()) {
                    player.setInvulnerable(false);
                    player.sendMessage(ChatColor.RED + "You are no longer invulnerable");
                } else {
                    player.setInvulnerable(true);
                    player.sendMessage(ChatColor.GREEN + "You are now invulnerable");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You are missing the merlin.god permission, ask a server owner if you belive this is an error.");
            }


        }

        return false;
    }

}
