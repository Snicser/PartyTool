package io.github.partytool.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by: Snicser
 * Project: PartyTool
 * Date: 21-9-2018
 */
public class QuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().contains(Material.FIREWORK_CHARGE)) {
            player.getInventory().remove(Material.FIREWORK_CHARGE);
        }
    }
}
