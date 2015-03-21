package me.Fabricio20.API.V1_8.v2;

import net.minecraft.server.v1_8_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R2.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R2.IChatBaseComponent;
import net.minecraft.server.v1_8_R2.PacketPlayOutChat;
import net.minecraft.server.v1_8_R2.PacketPlayOutTitle;

import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionAPI {
	
	public static void sendAction(Player player, String message) {
		IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
		PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
		((CraftPlayer)player).getHandle().playerConnection.sendPacket(bar);
	}
	
	public static void sendTitle(Player player, String message) {
		IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, icbc);
		((CraftPlayer)player).getHandle().playerConnection.sendPacket(title);
	}
	
	public static void sendSubtitle(Player player, String message) {
		IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
		PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, icbc);
		((CraftPlayer)player).getHandle().playerConnection.sendPacket(subtitle);
	}
	
}

