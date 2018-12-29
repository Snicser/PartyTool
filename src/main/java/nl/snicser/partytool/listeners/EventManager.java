package io.github.partytool.listeners;

import io.github.partytool.Partytool;

/**
 * Created by: Snicser
 * Project: PartyTool
 * Date: 23-10-2018
 */
public class EventManager {

    private final Partytool plugin;

    public EventManager(Partytool plugin) {
        this.plugin = plugin;
    }

    public void registerAll() {
        plugin.getServer().getPluginManager().registerEvents(new QuitListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ProjectileListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new DamageListener(), plugin);
    }
}
