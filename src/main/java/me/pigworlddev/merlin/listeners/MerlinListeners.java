package me.pigworlddev.merlin.listeners;

import me.pigworlddev.merlin.Merlin;
import me.pigworlddev.merlin.events.SpawnerBreakEvent;
import me.pigworlddev.merlin.utils.VaultUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class MerlinListeners implements Listener {

    Merlin plugin;

    public MerlinListeners(Merlin plugin) {
        this.plugin = plugin;
    }

    String vaultName = plugin.getConfig().getString("vaultName");

    @EventHandler
    public void onSpawnerBreak(SpawnerBreakEvent e) {

        CreatureSpawner cs = (CreatureSpawner) e.getSpawner().getState();
        ItemStack spawner_to_give = new ItemStack(Material.SPAWNER);

        BlockStateMeta meta = (BlockStateMeta) spawner_to_give.getItemMeta();
        CreatureSpawner cs2 = (CreatureSpawner) meta.getBlockState();

        cs2.setSpawnedType(cs.getSpawnedType());
        meta.setBlockState(cs2);
        spawner_to_give.setItemMeta(meta);
        e.getBreaker().getInventory().addItem(spawner_to_give);

    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', vaultName))) {

            ArrayList<ItemStack> prunedItems = new ArrayList<>();

            Arrays.stream(e.getInventory().getContents())
                    .filter(itemStack -> {
                        if (itemStack == null) {
                            return false;
                        }
                        return true;
                    })
                    .forEach(itemStack -> prunedItems.add(itemStack));
            VaultUtils.storeItems(prunedItems, p);
        } else {
            // If that isn't the vault
        }
    }


}
