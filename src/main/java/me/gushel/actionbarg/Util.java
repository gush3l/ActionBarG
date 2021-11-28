package me.gushel.actionbarg;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Util {

    public static String color(Player player,String text){
        return ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player,text));
    }



}
