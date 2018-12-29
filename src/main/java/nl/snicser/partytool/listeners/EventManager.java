package nl.snicser.partytool.listeners;

import nl.snicser.partytool.PartyTool;

/**
 * Created by: Snicser
 * Project: PartyTool
 * Date: 23-10-2018
 */
public class EventManager {

    private final PartyTool plugin;

    public EventManager(PartyTool plugin) {
        this.plugin = plugin;
    }

    public void registerAll() {
        plugin.getServer().getPluginManager().registerEvents(new QuitListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ProjectileListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new DamageListener(), plugin);
    }
}
