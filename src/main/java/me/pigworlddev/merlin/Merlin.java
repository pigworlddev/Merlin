package me.pigworlddev.merlin;

import me.pigworlddev.merlin.commands.Feed;
import me.pigworlddev.merlin.commands.God;
import me.pigworlddev.merlin.events.PlayerJoin;
import me.pigworlddev.merlin.events.PlayerJoinBed;
import me.pigworlddev.merlin.events.PlayerLeave;
import me.pigworlddev.merlin.events.PlayerLeaveBed;
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
        getCommand("god").setExecutor(new God());
        getCommand("feed").setExecutor(new Feed());

    }

    @Override
    public void onDisable() {
        getLogger().info("[Merlin] Merlin Stopped");
    }
}
