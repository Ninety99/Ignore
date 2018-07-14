package me.NinetyNine.ignore.command;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.NinetyNine.ignore.listeners.IgnoreManager;
import me.NinetyNine.ignore.utils.IgnoreUtils;

public class IgnoreCommands implements Listener, CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		IgnoreManager im = new IgnoreManager();

		if (!(sender instanceof Player)) {
			if (cmd.getName().equalsIgnoreCase("ignore")) {
				if (args.length == 0) {
					sender.sendMessage(IgnoreUtils.format("&cYou need to be a player to execute this command!"));
					return true;
				}

				if (args[0].equalsIgnoreCase("get")) {
					if (args.length == 1) {
						sender.sendMessage(IgnoreUtils.format("&cUsage: /ignore get <player>"));
						return true;
					}

					if (args.length <= 1) {
						Player player = Bukkit.getPlayer(args[1]);
						List<String> names = im.getIgnoredPlayers(player);
						for (String name : names)
							sender.sendMessage(IgnoreUtils.format("&aIgnored player(s) of " + player.getName()
									+ " are/is:\n" + name.replace("[", "").replace("]", "")));
						return true;
					}

					if (args.length > 1) {
						sender.sendMessage(IgnoreUtils.format("&cInvalid command."));
						return true;
					}
				}
			}
		} else {
			Player player = (Player) sender;

			if (cmd.getName().equalsIgnoreCase("ignore")) {
				if (args.length == 0) {
					player.sendMessage(IgnoreUtils.format("&cUsage: /ignore <player> | /ignore get <player>"));
					return true;
				}

				if (args.length <= 1) {
					Player target = Bukkit.getPlayer(args[0]);
					im.addIgnorePlayer(player, target.getName());
					player.sendMessage(IgnoreUtils.format("&aSuccessfully added " + target.getName() + " as ignored!"));
					return true;
				}

				if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("get")) {
						Player tar = Bukkit.getPlayer(args[1]);
						List<String> names = im.getIgnoredPlayers(tar);
						for (String name : names)
							player.sendMessage(
									IgnoreUtils.format("&aIgnored player(s) of " + tar.getName() + " are/is:\n" + name)
											.replace("[", "").replace("]", ""));
						return true;
					}
				}

				if (args.length > 1) {
					player.sendMessage(IgnoreUtils.format("&cInvalid command."));
					return true;
				}
			}

			if (cmd.getName().equalsIgnoreCase("msgignore")) {
				if (args.length == 0) {
					// TODO: Add stuff here
				}
			}
		}
		return false;
	}
}