package me.Fabricio20.BungeeCord.Listeners;

import me.Fabricio20.BungeeCord.API.FriendsAPI;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class FriendsPostLoginListener implements Listener {
	
	@EventHandler
	public void onPostFriends(PostLoginEvent e) {
		ProxiedPlayer player = e.getPlayer();
		
		FriendsAPI.getFriends(player.getName());
		FriendsAPI.getRequests(player.getName());
	}
	
}
