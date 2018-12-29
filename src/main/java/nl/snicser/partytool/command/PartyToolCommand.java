package nl.snicser.partytool.command;

import nl.snicser.partytool.util.C;
import nl.snicser.partytool.util.Constants;
import nl.snicser.partytool.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by: Snicser
 * Project: PartyTool
 * Date: 20-9-2018
 */
public class PartyToolCommand implements CommandExecutor {

    private boolean isOn = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Constants.PREFIX + ChatColor.RED + "Alleen spelers kunnen de partytool gebruiken!");
            return true;
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("partytool")) {
            if (player.hasPermission("partytool.use")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("aan")) {
                        handleOn(player);
                        return true;
                    } else if (args[0].equalsIgnoreCase("uit")) {
                        handleOff(player);
                        return true;
                    }
                } else {
                    player.sendMessage(Constants.PREFIX + C.TAC("&fGebruik: &c/partytool <aan:uit>"));
                    return true;
                }
            } else {
                player.sendMessage(Constants.PREFIX + ChatColor.RED + "Je hebt geen toestemming om dit commando uit te voeren.");
                return true;
            }
        }
        return false;
    }

    private void handleOn(Player player) {
        if (isOn) {
            player.sendMessage(Constants.PREFIX + ChatColor.RED + "De partytool is al aan.");
        } else {
            isOn = true;

            ItemStack fireCharge = new ItemBuilder(Material.FIREWORK_CHARGE, 1).name(Constants.TOOL_NAME).addLore(ChatColor.WHITE + "Rechtermuis knop voor gebruik.").build();

            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                onlinePlayers.sendMessage(Constants.PREFIX + ChatColor.GREEN + "De partytool is aan gezet door: " + ChatColor.RED + player.getName());
                onlinePlayers.getInventory().setItem(0, fireCharge);
            }
        }
    }

    private void handleOff(Player player) {
        if (!isOn) {
            player.sendMessage(Constants.PREFIX + ChatColor.RED + "De partytool is al uit.");
        } else {
            isOn = false;

            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                onlinePlayers.sendMessage(Constants.PREFIX + ChatColor.GREEN + "De partytool is uit gezet door: " + ChatColor.RED + player.getName());
                if (onlinePlayers.getInventory().contains(Material.FIREWORK_CHARGE)) {
                    onlinePlayers.getInventory().remove(Material.FIREWORK_CHARGE);
                }
            }
        }
    }
}
