package me.snicser.partytool.command;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by: Snicser
 * Project: PartyTool
 * Date: 23-10-2018
 */
public final class CommandManager {

    private CommandManager() {}

    public static void registerAll(JavaPlugin plugin) {
        plugin.getCommand("partytool").setExecutor(new PartyToolCommand());
    }
}
