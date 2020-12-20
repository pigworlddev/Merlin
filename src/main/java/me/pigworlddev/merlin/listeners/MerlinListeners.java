package me.pigworlddev.merlin.listeners;

import me.pigworlddev.merlin.events.SpawnerBreakEvent;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class MerlinListeners implements Listener {

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
}
