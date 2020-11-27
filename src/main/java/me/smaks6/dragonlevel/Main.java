package me.smaks6.dragonlevel;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        DragonSpawnEvent dragonSpawnEvent = new DragonSpawnEvent();
        getServer().getPluginManager().registerEvents(dragonSpawnEvent, this);
        DragonDeath dragonDeath = new DragonDeath();
        getServer().getPluginManager().registerEvents(dragonDeath, this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Enabling the DragonLevel plugin");

        getConfig().addDefault("DragonLevel", 0);
        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
    }

    public static Main getInstance() {
        return instance;
    }
}
