package me.snicser.partytool.listeners;

import me.snicser.partytool.util.C;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by: Snicser
 * Project: PartyTool
 * Date: 21-9-2018
 */
public class ProjectileListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (!(event.getAction() == Action.RIGHT_CLICK_AIR)) return;
        if (!(event.getItem().getType() == Material.FIREWORK_CHARGE)) return;
        if (!(player.getItemInHand().getItemMeta().hasLore())) return;
        if (!(player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(C.TAC("&c&lPartyTool")))) return;

        Snowball snowball = player.launchProjectile(Snowball.class);
        snowball.setVelocity(player.getLocation().getDirection().multiply(0.8));

    }

    @EventHandler
    public void onEntityDamage(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Snowball && event.getEntity().getShooter() instanceof Player) {
            Player shooter = (Player) event.getEntity().getShooter();
            shooter.playSound(shooter.getLocation(), Sound.BLOCK_NOTE_PLING, 2, 1);

            if (event.getHitEntity() instanceof Player) {
                Player hittedPlayer = (Player) event.getHitEntity();
                hittedPlayer.playSound(hittedPlayer.getLocation(), Sound.ENTITY_BAT_AMBIENT, 2, 1);
                hittedPlayer.spigot().playEffect(hittedPlayer.getLocation().add(0, 2, 0), Effect.FLAME, 0, 0, 0, 0, 0, 0, 5, 5);
                hittedPlayer.setVelocity(event.getHitEntity().getLocation().getDirection().multiply(0.4).setY(0.7).setX(0.7));

            }
        }
    }
}
