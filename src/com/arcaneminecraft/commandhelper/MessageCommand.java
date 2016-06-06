package com.arcaneminecraft.commandhelper;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import java.util.ArrayList;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

/**
 * Created by barestides on 6/6/16.
 */
public class MessageCommand extends BukkitCommand{

    String message;

    public MessageCommand(String name, String message){
       super(name);
        this.description = "Sends player this message:" + message;
        this.usageMessage = "/" + name;
        this.message = message;
        this.setAliases(new ArrayList<String>());
    }

    @Override
    public boolean execute(CommandSender commandSender, String alias, String[] args) {
        if (args.length != 0){
            return true;
        }

        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            player.sendMessage(this.message);
        }
        return false;
    }
}
