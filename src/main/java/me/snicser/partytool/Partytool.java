package me.snicser.partytool;

import me.snicser.partytool.command.PartyToolCommand;
import me.snicser.partytool.listeners.DamageListener;
import me.snicser.partytool.listeners.ProjectileListener;
import me.snicser.partytool.listeners.QuitListener;
import me.snicser.partytool.util.Constants;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Partytool extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommand();
        registerListeners();

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

    private void registerCommand() {
        getCommand("partytool").setExecutor(new PartyToolCommand());
    }

    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new ProjectileListener(), this);
        pm.registerEvents(new DamageListener(), this);
    }
}
