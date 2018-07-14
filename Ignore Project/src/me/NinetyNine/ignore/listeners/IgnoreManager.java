package me.NinetyNine.ignore.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import lombok.Getter;
import me.NinetyNine.ignore.utils.IgnoreDatabase;

public class IgnoreManager implements IgnoreDatabase, Listener {
	@Getter
	private static List<String> ignored = new ArrayList<String>();

	@Getter
	private static HashMap<Player, String> ignore = new HashMap<Player, String>();

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();

		if (getIgnoredPlayers(player).isEmpty())
			return;
		else
			getIgnore().put(player, getIgnore().get(player));
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player player = e.getPlayer();

		if (getIgnoredPlayers(player).isEmpty())
			return;
		else
			getIgnore().put(player, getIgnore().get(player));
	}

	@Override
	public List<String> getIgnoredPlayers(Player player) {
		return getIgnored();
	}

	@Override
	public void addIgnorePlayer(Player player, String targetName) {
		if (getIgnored().contains(targetName))
			getIgnored().add(targetName);
		else
			return;

		if (!getIgnore().containsKey(player))
			getIgnore().put(player, targetName);
		else
			return;
	}

	@Override
	public void unIgnorePlayer(Player player, String targetName) {
		if (getIgnore().containsKey(player))
			getIgnore().remove(player);
		else
			return;

		if (getIgnored().contains(targetName))
			getIgnored().remove(targetName);
		else
			return;
	}
}
