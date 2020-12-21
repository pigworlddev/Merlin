package me.pigworlddev.merlin.commands.vault;

import me.pigworlddev.merlin.Merlin;
import me.pigworlddev.merlin.utils.VaultUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class OpenCommand implements CommandExecutor {

    Merlin plugin;

    public OpenCommand(Merlin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            String vaultName = plugin.getConfig().getString("vaultName");
            String missingPerms = plugin.getConfig().getString("missingPermissions");

            if (p.hasPermission("merlin.vault")) {
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("open")) {
                        ArrayList<ItemStack> vaultItems = VaultUtils.getItems(p);

                        Inventory vault = Bukkit.createInventory(p, 54, ChatColor.translateAlternateColorCodes('&', vaultName));

                        vaultItems.stream()
                                .forEach(itemStack -> vault.addItem(itemStack));

                        p.openInventory(vault);
                    }
                }
            } else {
                // Missing permissions
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', missingPerms));
            }

        } else {
            // Console.
        }

        return true;
    }
}
