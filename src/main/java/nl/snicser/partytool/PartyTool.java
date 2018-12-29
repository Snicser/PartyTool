package nl.snicser.partytool;

import nl.snicser.partytool.command.CommandManager;
import nl.snicser.partytool.listeners.EventManager;
import nl.snicser.partytool.util.Constants;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class PartyTool extends JavaPlugin {

    private CommandManager commandManager;
    private EventManager eventManager;

    @Override
    public void onEnable() {
        init();

        commandManager.registerAll();
        eventManager.registerAll();

        getServer().getConsoleSender().sendMessage(Constants.PREFIX + ChatColor.GREEN + "PartyTool enabled!");
        getServer().getConsoleSender().sendMessage(Constants.PREFIX + ChatColor.GREEN + "Versie: " + getDescription().getVersion());

    }

    @Override
    public void onDisable() {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.getInventory().clear();
        }

        getServer().getConsoleSender().sendMessage(Constants.PREFIX + ChatColor.RED + "PartyTool disabled!");
        getServer().getConsoleSender().sendMessage(Constants.PREFIX + ChatColor.RED + "Versie: " + getDescription().getVersion());
    }

    private void init() {
        commandManager = new CommandManager(this);
        eventManager = new EventManager(this);
    }
}
