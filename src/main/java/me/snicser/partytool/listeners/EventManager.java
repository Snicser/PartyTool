package me.snicser.partytool.listeners;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by: Snicser
 * Project: PartyTool
 * Date: 23-10-2018
 */
public final class EventManager {

    private EventManager() {}

    public static void registerAll(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new QuitListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ProjectileListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new DamageListener(), plugin);
    }
}
