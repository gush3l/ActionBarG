package me.gushel.actionbarg;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

public class ActionBarUtil {

    public static void sendActionBar(Player player, WrappedChatComponent text){
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        PacketContainer chatPacket = protocolManager.createPacket(PacketType.Play.Server.SET_ACTION_BAR_TEXT);
        chatPacket.getChatComponents().write(0, text);
        try {
            protocolManager.sendServerPacket(player, chatPacket);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static String charRemapper(String text){
        Configuration config = ActionBarG.getInstance().getConfig();
        Logger log = ActionBarG.getInstance().getLogger();
        for (String charMap : config.getStringList("characters")){
            String[] configString = charMap.split(":");
            text = text.replace(configString[0],configString[1]);
        }
        return text;
    }

}
