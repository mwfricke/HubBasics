package me.Fabricio20.listeners.V1_7;

import me.Fabricio20.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TitleJoin implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if(Main.theClass.config.getBoolean("TitleSystem.Enabled") == true) {
			String title = " ";
			String subtitle = " ";
			if(Main.theClass.config.getString("TitleSystem.Title") != "") {
				title = Main.theClass.config.getString("TitleSystem.Title").replace("&", "�").replace("%p", e.getPlayer().getName());
			}
			subtitle = Main.theClass.config.getString("TitleSystem.Subtitle").replace("&", "�").replace("%p", e.getPlayer().getName());
			me.Fabricio20.API.V1_7.ActionAPI.sendTitle(e.getPlayer(), title);
			me.Fabricio20.API.V1_7.ActionAPI.sendSubtitle(e.getPlayer(), subtitle);
		}
	}
	
}
