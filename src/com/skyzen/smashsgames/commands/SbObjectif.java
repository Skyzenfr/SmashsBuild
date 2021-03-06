package com.skyzen.smashsgames.commands;

import com.skyzen.smashsgames.Main;
import com.skyzen.smashsgames.object.Scoreboards;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SbObjectif implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.isOp()) {
                if (args.length >= 1) {
                    Scoreboards.updateObjectif(Main.instance.getConfig().getString("objectif"), args[0]);
                    Main.instance.getConfig().set("objectif", args[0]);
                    Main.instance.saveConfig();
                } else {
                    player.sendMessage(Main.SERVER_PREFIX + ChatColor.RED + "Vous devez specifier un nouvel objectif !");
                }

            } else {
                player.sendMessage(Main.SERVER_PREFIX + ChatColor.RED + "Il faut être builder");
            }

        } else {
            if (args.length >= 1) {
                Scoreboards.updateObjectif(Main.instance.getConfig().getString("objectif"), args[0]);
                Main.instance.getConfig().set("objectif", args[0]);
                Main.instance.saveConfig();
            } else {
                sender.sendMessage(Main.SERVER_PREFIX + ChatColor.RED + "Vous devez specifier un nouvel objectif !");
            }
        }

        return false;
    }

}
