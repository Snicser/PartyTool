package io.github.partytool.command;

import io.github.partytool.Partytool;

/**
 * Created by: Snicser
 * Project: PartyTool
 * Date: 23-10-2018
 */
public class CommandManager {

    private final Partytool plugin;

    public CommandManager(Partytool plugin) {
        this.plugin = plugin;
    }

    public void registerAll() {
        plugin.getCommand("partytool").setExecutor(new PartyToolCommand());
    }
}
