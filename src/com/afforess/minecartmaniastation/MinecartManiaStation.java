package com.afforess.minecartmaniastation;

import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.afforess.minecartmaniacore.MinecartManiaCore;
import com.afforess.minecartmaniacore.config.MinecartManiaConfigurationParser;
import com.afforess.minecartmaniacore.debug.MinecartManiaLogger;


public class MinecartManiaStation extends JavaPlugin{
	public static MinecartManiaLogger log = MinecartManiaLogger.getInstance();
	public static Server server;
	public static PluginDescriptionFile description;
	public static MinecartActionListener listener = new MinecartActionListener();

	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	public void onEnable() {
		server = this.getServer();
		description = this.getDescription();
		MinecartManiaConfigurationParser.read(description.getName() + "Configuration.xml", MinecartManiaCore.dataDirectory, new StationSettingParser());
		getServer().getPluginManager().registerEvent(Event.Type.CUSTOM_EVENT, listener, Priority.Normal, this);
		log.info( description.getName() + " version " + description.getVersion() + " is enabled!" );
	}
}
