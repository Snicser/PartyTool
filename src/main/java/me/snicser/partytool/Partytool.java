package me.snicser.partytool;

import me.snicser.partytool.command.CommandManager;
import me.snicser.partytool.listeners.EventManager;
import me.snicser.partytool.util.Constants;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Partytool extends JavaPlugin {

    @Override
    public void onEnable() {
        CommandManager.registerAll(this);
        EventManager.registerAll(this);

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
}
