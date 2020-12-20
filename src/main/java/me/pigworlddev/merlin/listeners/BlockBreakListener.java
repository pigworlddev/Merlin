package me.pigworlddev.merlin.listeners;

import me.pigworlddev.merlin.Merlin;
import me.pigworlddev.merlin.events.SpawnerBreakEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    Merlin plugin;

    public BlockBreakListener(Merlin plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {

        String missingPerms = plugin.getConfig().getString("missingPermissions");

        Block blockBroken = e.getBlock();

        Player player = e.getPlayer();

        if (blockBroken.getType().equals(Material.SPAWNER) && player.getInventory()
                .getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) &&
                player.hasPermission("merlin.silkspawners")) {
            Bukkit.getServer()
                    .getPluginManager()
                    .callEvent(new SpawnerBreakEvent(player, blockBroken));
        } else if (blockBroken.getType().equals(Material.SPAWNER) && player.getInventory()
                .getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) &&
                !player.hasPermission("merlin.silkspawners")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', missingPerms));
        }
    }
}
