package me.Fabricio20.listeners;

import java.util.List;
import me.Fabricio20.methods.CustomConfigs;
import me.Fabricio20.methods.Items;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinListenerForItems implements Listener {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private static JavaPlugin plugin;

	public JoinListenerForItems(JavaPlugin plugin) {
		JoinListenerForItems.plugin = plugin;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@EventHandler
	public void PlayerJoinGetItem(PlayerJoinEvent e) {
		 List<String> worlds = plugin.getConfig().getStringList("Worlds");
		 Player player = e.getPlayer();
		 if(worlds.contains(e.getPlayer().getWorld().getName())) {
			 if(plugin.getConfig().getBoolean("Others.ClearInventory") == true) {
				 e.getPlayer().getInventory().clear();
			 }
			 if(plugin.getConfig().getBoolean("Others.JoinItems") == true) {
    ////////////////////////////////////////////////////////////////////////////////////////- Start Of 1
				if(CustomConfigs.getItemConfig().getBoolean("Item1.Enabled") == true) {
					if(!player.getInventory().contains(Items.Item1(e.getPlayer().getName()))) {
						e.getPlayer().getInventory().setItem(CustomConfigs.getItemConfig().getInt("Item1.Slot"), Items.Item1(e.getPlayer().getName()));
					}
				}
	////////////////////////////////////////////////////////////////////////////////////////- End Of 1 & Start Of 2
				if(CustomConfigs.getItemConfig().getBoolean("Item2.Enabled") == true) {
					if(!player.getInventory().contains(Items.Item2(e.getPlayer().getName()))) {
						e.getPlayer().getInventory().setItem(CustomConfigs.getItemConfig().getInt("Item2.Slot"), Items.Item2(e.getPlayer().getName()));
					}
				}
	////////////////////////////////////////////////////////////////////////////////////////- End Of 2 & Start Of 3
				if(CustomConfigs.getItemConfig().getBoolean("Item3.Enabled") == true) {
					if(!player.getInventory().contains(Items.Item3(e.getPlayer().getName()))) {
						e.getPlayer().getInventory().setItem(CustomConfigs.getItemConfig().getInt("Item3.Slot"), Items.Item3(e.getPlayer().getName()));
					}
				}
	////////////////////////////////////////////////////////////////////////////////////////- End Of 3 & Start Of 4
				if(CustomConfigs.getItemConfig().getBoolean("Item4.Enabled") == true) {
					if(!player.getInventory().contains(Items.Item4(e.getPlayer().getName()))) {
						e.getPlayer().getInventory().setItem(CustomConfigs.getItemConfig().getInt("Item4.Slot"), Items.Item4(e.getPlayer().getName()));
					}
				}
	////////////////////////////////////////////////////////////////////////////////////////- End Of 4 & Start Of 5
				if(CustomConfigs.getItemConfig().getBoolean("Item5.Enabled") == true) {
					if(!player.getInventory().contains(Items.Item5(e.getPlayer().getName()))) {
						e.getPlayer().getInventory().setItem(CustomConfigs.getItemConfig().getInt("Item5.Slot"), Items.Item5(e.getPlayer().getName()));
					}
				}
	////////////////////////////////////////////////////////////////////////////////////////- End Of 5 & Start Of 6
				if(CustomConfigs.getItemConfig().getBoolean("Item6.Enabled") == true) {
					if(!player.getInventory().contains(Items.Item6(e.getPlayer().getName()))) {
						e.getPlayer().getInventory().setItem(CustomConfigs.getItemConfig().getInt("Item6.Slot"), Items.Item6(e.getPlayer().getName()));
					}
				}
	////////////////////////////////////////////////////////////////////////////////////////- End Of 6 & Start Of 7
				if(CustomConfigs.getItemConfig().getBoolean("Item7.Enabled") == true) {
					if(!player.getInventory().contains(Items.Item7(e.getPlayer().getName()))) {
						e.getPlayer().getInventory().setItem(CustomConfigs.getItemConfig().getInt("Item7.Slot"), Items.Item7(e.getPlayer().getName()));
					}
				}
	////////////////////////////////////////////////////////////////////////////////////////- End Of 7 & Start Of 8
				if(CustomConfigs.getItemConfig().getBoolean("Item8.Enabled") == true) {
					if(!player.getInventory().contains(Items.Item8(e.getPlayer().getName()))) {
						e.getPlayer().getInventory().setItem(CustomConfigs.getItemConfig().getInt("Item8.Slot"), Items.Item8(e.getPlayer().getName()));
					}
				}
	////////////////////////////////////////////////////////////////////////////////////////- End Of 8 & Start Of 9
				if(CustomConfigs.getItemConfig().getBoolean("Item9.Enabled") == true) {
					if(!player.getInventory().contains(Items.Item9(e.getPlayer().getName()))) {
						e.getPlayer().getInventory().setItem(CustomConfigs.getItemConfig().getInt("Item9.Slot"), Items.Item9(e.getPlayer().getName()));
					}
				}
	////////////////////////////////////////////////////////////////////////////////////////- End Of 9
			}
		 }
	}	
}
