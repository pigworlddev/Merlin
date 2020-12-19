package me.pigworlddev.merlin;

import me.pigworlddev.merlin.events.bed.PlayerJoinBed;
import me.pigworlddev.merlin.events.bed.PlayerLeaveBed;
import me.pigworlddev.merlin.events.joinleave.PlayerJoin;
import me.pigworlddev.merlin.events.joinleave.PlayerLeave;
import org.bukkit.plugin.java.JavaPlugin;

public final class Merlin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[Merlin] Merlin Started");
        // Events
        getServer().getPluginManager().registerEvents(new PlayerLeaveBed(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinBed(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);

        // Commands

    }

    @Override
    public void onDisable() {
        getLogger().info("[Merlin] Merlin Stopped");
    }
}
