package nl.snicser.partytool.listeners;

import nl.snicser.partytool.util.C;
import nl.snicser.partytool.util.Constants;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by: Snicser
 * Project: PartyTool
 * Date: 21-9-2018
 */
public class ProjectileListener implements Listener {

    private Map<UUID, Long> cooldown = new HashMap<>();

    @Deprecated
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getItem() == null) return;
        if (!(event.getAction() == Action.RIGHT_CLICK_AIR)) return;
        if (!(event.getItem().getType().equals(Material.FIREWORK_CHARGE))) return;
        if (!(player.getItemInHand().getItemMeta().getDisplayName().equals(Constants.TOOL_NAME))) return;

        if (cooldown.containsKey(player.getUniqueId())) {
            long secondsOver = ((cooldown.get(player.getUniqueId()) / 1000) + 5) - (System.currentTimeMillis() / 1000);
            if (secondsOver > 0) {
                player.sendMessage(Constants.PREFIX + C.TAC("&fJe kan de partytool over &c" + secondsOver + " &fweer gebruiken."));
                return;
            }
        }

        Snowball snowball = player.launchProjectile(Snowball.class);
        snowball.setVelocity(player.getLocation().getDirection().multiply(0.8));
        cooldown.put(player.getUniqueId(), System.currentTimeMillis());
    }

    @Deprecated
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Snowball && event.getEntity().getShooter() instanceof Player) {
            Player shooter = (Player) event.getEntity().getShooter();

            if (event.getHitEntity() instanceof Player) {
                shooter.playSound(shooter.getLocation(), Sound.BLOCK_NOTE_PLING, 2, 1);
                Player hittedPlayer = (Player) event.getHitEntity();
                hittedPlayer.playSound(hittedPlayer.getLocation(), Sound.BLOCK_ANVIL_HIT, 2F, 1F);
                hittedPlayer.playEffect(hittedPlayer.getLocation(), Effect.SMOKE, 1000);
                hittedPlayer.setVelocity(event.getHitEntity().getLocation().getDirection().setY(0.5).multiply(0.7));
            }
        }
    }
}
