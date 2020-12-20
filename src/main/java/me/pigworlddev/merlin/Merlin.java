package me.pigworlddev.merlin;

import me.pigworlddev.merlin.commands.*;
import me.pigworlddev.merlin.events.PlayerEnterBed;
import me.pigworlddev.merlin.events.PlayerJoin;
import me.pigworlddev.merlin.events.PlayerLeave;
import me.pigworlddev.merlin.events.PlayerLeaveBed;
import me.pigworlddev.merlin.listeners.BlockBreakListener;
import me.pigworlddev.merlin.listeners.MerlinListeners;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Merlin extends JavaPlugin {

    public ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public void onEnable() {
        getLogger().info("[Merlin] Merlin Started");


        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {

            // Config
            getConfig().options().copyDefaults();
            saveDefaultConfig();


            // Events
            getServer().getPluginManager().registerEvents(new PlayerLeaveBed(), this);
            getServer().getPluginManager().registerEvents(new PlayerEnterBed(), this);
            getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
            getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
            getServer().getPluginManager().registerEvents(new BlockBreakListener(this), this);
            getServer().getPluginManager().registerEvents(new MerlinListeners(), this);

            // Commands
            getCommand("god").setExecutor(new God());
            getCommand("feed").setExecutor(new Feed());
            getCommand("kill").setExecutor(new Kill());
            getCommand("vault").setExecutor(new Vault());
            getCommand("rtp").setExecutor(new RandomTP());
            getCommand("vanish").setExecutor(new Vanish());
            getCommand("tp").setExecutor(new Teleport(this));
            getCommand("tpall").setExecutor(new TeleportAll());

            TeleportUtils tpUtils = new TeleportUtils(this);
        } else {
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }

    }

    @Override
    public void onDisable() {
        getLogger().info("[Merlin] Merlin Stopped");
    }
}
