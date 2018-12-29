package nl.snicser.partytool.command;

import nl.snicser.partytool.PartyTool;

/**
 * Created by: Snicser
 * Project: PartyTool
 * Date: 23-10-2018
 */
public class CommandManager {

    private final PartyTool plugin;

    public CommandManager(PartyTool plugin) {
        this.plugin = plugin;
    }

    public void registerAll() {
        plugin.getCommand("partytool").setExecutor(new PartyToolCommand());
    }
}
