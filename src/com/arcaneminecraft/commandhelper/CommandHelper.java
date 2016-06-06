package com.arcaneminecraft.commandhelper;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by barestides on 5/31/16.
 */
public class CommandHelper extends JavaPlugin{

    @Override
    public void onEnable() {
        /*File commandsYMLFile = new File(this.getDataFolder()+"/commands.yml");
        FileConfiguration customConfig = YamlConfiguration.loadConfiguration(commandsYMLFile);*/
    }

    @Override
    public void onDisable(){

    }

   /* public void saveCustomYML(FileConfiguration ymlConfig, File ymlFile){
        try {
            ymlConfig.save(ymlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    private void createMessageCommand(String command, String message ){

       try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

            commandMap.register(command, new MessageCommand(command, message));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}


