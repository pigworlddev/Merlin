package me.pigworlddev.merlin.commands;

import com.destroystokyo.paper.Title;
import me.pigworlddev.merlin.TeleportUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class RandomTP implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                if (player.hasPermission("merlin.rtp")) {
                    player.teleport(TeleportUtils.generateLocation(player));
                    Title.builder().build();
                }
            } else if (args.length == 1) {
                if (player.hasPermission("merlin.tp.others")) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    target.teleport(TeleportUtils.generateLocation(player));
                }
            }

        }
        return true;
    }
}
