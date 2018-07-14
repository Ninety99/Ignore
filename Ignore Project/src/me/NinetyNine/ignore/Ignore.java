package me.NinetyNine.ignore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import me.NinetyNine.ignore.command.IgnoreCommands;
import me.NinetyNine.ignore.listeners.IgnoreManager;

public class Ignore extends JavaPlugin {

	@Getter
	private static Ignore instance;

	@Override
	public void onEnable() {
		instance = this;

		registerListeners();
		registerCommands();
	}

	@Override
	public void onDisable() {

	}
	
	private void registerListeners() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new IgnoreCommands(), this);
		pm.registerEvents(new IgnoreManager(), this);
	}
	
	private void registerCommands() {
		getCommand("ignore").setExecutor(new IgnoreCommands());
		getCommand("msgignore").setExecutor(new IgnoreCommands());
	}
}