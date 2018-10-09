package me.snicser.partytool.util;

import org.bukkit.ChatColor;

/**
 * Created by: Snicser
 * Project: PartyTool
 * Date: 20-9-2018
 */
public final class C {

    private C() {}

    public static String TAC(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}
