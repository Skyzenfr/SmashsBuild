package com.skyzen.smashsgames.commands;

import com.skyzen.smashsgames.Main;
import com.skyzen.smashsgames.event.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

public class SbReload implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {

        PluginManager pluginManager = Bukkit.getServer().getPluginManager();

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.isOp()) {
                Bukkit.broadcastMessage("debut");
                pluginManager.disablePlugin(Main.instance);
                pluginManager.enablePlugin(Main.instance);
                PlayerListener.scoreboards.init();
                Bukkit.broadcastMessage("fin");

            } else {
                player.sendMessage(ChatColor.RED + "Il faut être builder");
            }

        } else {
            Bukkit.broadcastMessage("debut");
            pluginManager.disablePlugin(Main.instance);
            pluginManager.enablePlugin(Main.instance);
            PlayerListener.scoreboards.init();
            Bukkit.broadcastMessage("fin");
        }

        return false;
    }

}
