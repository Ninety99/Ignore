package me.NinetyNine.ignore.utils;

import java.util.List;

import org.bukkit.entity.Player;

public interface IgnoreDatabase {
	public List<String> getIgnoredPlayers(Player player);

	public void addIgnorePlayer(Player player, String targetName);

	public void unIgnorePlayer(Player player, String targetName);
}
