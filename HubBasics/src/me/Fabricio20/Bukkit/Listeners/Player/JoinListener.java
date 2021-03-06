package me.Fabricio20.Bukkit.Listeners.Player;

import java.util.ArrayList;
import java.util.List;

import me.Fabricio20.Bukkit.Main;
import me.Fabricio20.Bukkit.API.BookAPI;
import me.Fabricio20.Bukkit.API.ItemsAPI;
import me.Fabricio20.Bukkit.API.MagicClockAPI;
import me.Fabricio20.Bukkit.Methods.JoinItems;
import me.Fabricio20.Bukkit.Methods.ModuleManager;
import me.Fabricio20.Bukkit.Methods.Managers.SettingsManager;
import me.Fabricio20.Bukkit.Runnables.BossAnnouncer;
import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {	
	 
	 @SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGH)
	 public void Join(PlayerJoinEvent e) {
		 if(Main.theClass.config.getBoolean("JoinEvents.DisableMessage") == true) {
			 e.setJoinMessage(null);
		 } else {
			 e.setJoinMessage(Main.theClass.config.getString("JoinEvents.Message").replace("&", "�").replace("%p", e.getPlayer().getName()));
		 }
		 if(Main.theClass.config.getBoolean("JoinEvents.SilentOpJoin") == true) {
			 if(e.getPlayer().isOp()) {
				 e.setJoinMessage(null);
			 }
		 }
		if(Main.theClass.config.getBoolean("JoinEvents.HubAtLogin") == true) {
			if(Main.theClass.Hub.contains("Hub.World")) {
				Location loc = Bukkit.getWorlds().get(0).getSpawnLocation();
				if(Bukkit.getWorld(Main.theClass.Hub.getString("Hub.World")) != null) {
					loc.setWorld(Bukkit.getWorld(Main.theClass.Hub.getString("Hub.World")));
					loc.setX(Main.theClass.Hub.getDouble("Hub.X"));
					loc.setY(Main.theClass.Hub.getDouble("Hub.Y"));
					loc.setZ(Main.theClass.Hub.getDouble("Hub.Z"));
					loc.setYaw(Main.theClass.Hub.getInt("Hub.Yaw"));
					loc.setPitch(Main.theClass.Hub.getInt("Hub.Pitch"));
					e.getPlayer().teleport(loc);
				}
			}
		}
		if(Main.theClass.config.getBoolean("BookSystem.Enabled") == true) {
			if(ModuleManager.theClass.isInWorld(e.getPlayer())) {
				if(!e.getPlayer().getInventory().contains(JoinItems.Book(e.getPlayer().getName()))) {
					if(Main.theClass.config.getBoolean("BookSystem.FirstJoinOnly") == true) {
						if(BookAPI.shouldGive(e.getPlayer().getName()) == true) {
							if(Main.theClass.config.getBoolean("BookSystem.Give") == false) {
								e.getPlayer().getInventory().setItem(Main.theClass.config.getInt("BookSystem.Slot"), JoinItems.Book(e.getPlayer().getName()));
								BookAPI.give(e.getPlayer().getName());
							} else {
								e.getPlayer().getInventory().addItem(JoinItems.Book(e.getPlayer().getName()));
								BookAPI.give(e.getPlayer().getName());
							}
						}
					} else {
						if(Main.theClass.config.getBoolean("BookSystem.Give") == false) {
							e.getPlayer().getInventory().setItem(Main.theClass.config.getInt("BookSystem.Slot"), JoinItems.Book(e.getPlayer().getName()));
						} else {
							e.getPlayer().getInventory().addItem(JoinItems.Book(e.getPlayer().getName()));
						}
					}
				}
			}
		}
		if(Main.theClass.config.getBoolean("BossAnnouncer.Enabled") == true && Main.theClass.config.getBoolean("JoinEvents.BossBarOnJoin") == true) {
			List<String> Announces = new ArrayList<String>();
			Announces = Main.theClass.config.getStringList("BossAnnouncer.Msgs");
			BarAPI.setMessage(e.getPlayer(), Announces.get(BossAnnouncer.Stamp));
		}
		if(Main.theClass.config.getBoolean("MagicClock.Enabled") == true) {
			if(ModuleManager.theClass.isInWorld(e.getPlayer())) {
				if(!e.getPlayer().getInventory().contains(ItemsAPI.get("MagicClock", SettingsManager.theClass.isPlayersEnabled(e.getPlayer().getName())))) {
					e.getPlayer().getInventory().setItem(Main.theClass.config.getInt("MagicClock.Slot"), ItemsAPI.get("MagicClock", SettingsManager.theClass.isPlayersEnabled(e.getPlayer().getName())));
				}
			}
			for(Player player: Bukkit.getOnlinePlayers()) { // Updates Everyone's Clock Satus When Someone Joins
				MagicClockAPI.theClass.toggleClock(player);
			}
		}
	}
	 
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 
}