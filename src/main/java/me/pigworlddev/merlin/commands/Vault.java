package me.pigworlddev.merlin.commands;

import me.pigworlddev.merlin.Merlin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Vault implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Plugin plugin = Merlin.getPlugin(Merlin.class);

        String missingPermission = plugin.getConfig().getString("missingPermission");

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("merlin.vault")) {

                Inventory vault = Bukkit.createInventory(player, 36, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("vaultName")));


                player.openInventory(vault);
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingPermission));
            }


        } else {
            System.err.println("You need to be a player to execute this command");
        }

        return true;
    }
}
