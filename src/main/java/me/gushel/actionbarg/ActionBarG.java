package me.gushel.actionbarg;

import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.logging.Logger;

public final class ActionBarG extends JavaPlugin {

    private static ActionBarG plugin;

    @Override
    public void onEnable() {
        Logger log = getLogger();
        plugin=this;
        saveDefaultConfig();
        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.runTaskTimer(this, () -> {
            for (Player player : Bukkit.getOnlinePlayers()){
                ActionBarUtil.sendActionBar(player, WrappedChatComponent.fromText(ActionBarUtil.charRemapper(Util.color(player,getConfig().getString("actionbar.text")))));
            }
        }, getConfig().getInt("actionbar.refresh.delay"), getConfig().getInt("actionbar.refresh.period"));
        log.info("Plugin started succesfully!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ActionBarG getInstance(){
        return plugin;
    }

}
