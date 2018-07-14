package me.NinetyNine.ignore.utils;

import org.bukkit.ChatColor;

public class IgnoreUtils {

	public static String format(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}