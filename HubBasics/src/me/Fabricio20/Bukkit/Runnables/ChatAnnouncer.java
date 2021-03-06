package me.Fabricio20.Bukkit.Runnables;

import java.util.ArrayList;
import java.util.List;

import me.Fabricio20.Bukkit.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ChatAnnouncer extends BukkitRunnable {
	
	List<String> Announces = new ArrayList<String>();
	List<String> Worlds = new ArrayList<String>();
	int Stamp = 0;
	int Max = 0;
	
	@SuppressWarnings("deprecation")
	public void run() {
		if(Main.theClass.config.getBoolean("ChatAnnouncer.Enabled") == true) {
			if(Main.theClass.config.getBoolean("ChatAnnouncer.Perworld") == false) {
				Announces = Main.theClass.config.getStringList("ChatAnnouncer.Msgs");
				int Max = Announces.size() - 1;
				if(Stamp == 0) {
					Bukkit.broadcastMessage(Announces.get(0).replace("&", "�"));
					Stamp++;
				} else if(Stamp != 0 && Stamp != Max) {
					Bukkit.broadcastMessage(Announces.get(Stamp).replace("&", "�"));
					Stamp++;
				} else if(Stamp == Max) {
					Bukkit.broadcastMessage(Announces.get(Max).replace("&", "�"));
					Stamp = 0;
				}
			} else {
				Announces = Main.theClass.config.getStringList("ChatAnnouncer.Msgs");
				Worlds = Main.theClass.config.getStringList("ChatAnnouncer.Worlds");
				int Max = Announces.size() - 1;
				if(Stamp == 0) {
					for(Player player : Bukkit.getOnlinePlayers()) {
						if(Worlds.contains(player.getWorld().getName())) {
							player.sendMessage(Announces.get(0).replace("&", "�"));
						}
					}
					Stamp++;
				} else if(Stamp != 0 && Stamp != Max) {
					for(Player player : Bukkit.getOnlinePlayers()) {
						if(Worlds.contains(player.getWorld().getName())) {
							player.sendMessage(Announces.get(Stamp).replace("&", "�"));
						}
					}
					Stamp++;
				} else if(Stamp == Max) {
					for(Player player : Bukkit.getOnlinePlayers()) {
						if(Worlds.contains(player.getWorld().getName())) {
							player.sendMessage(Announces.get(Max).replace("&", "�"));
						}
					}
					Stamp = 0;
				}
			}
		}
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
