package de.immernochnoah.ssp.events;

import de.immernochnoah.ssp.file_system.File_Manager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEventHandler implements Listener {

    @EventHandler
    public void handlePlayerJoinEvent(PlayerJoinEvent event) {
        Player p  = event.getPlayer();
        File_Manager fm = new File_Manager();
        boolean sendMessage = Boolean.parseBoolean(fm.getConfigText("SETTINGS", "Send Join Message"));
        boolean sendPrivateMessage = Boolean.parseBoolean(fm.getConfigText("SETTINGS", "Send Private Join Message"));

        if (sendPrivateMessage) {
            p.sendMessage(fm.getConfigText("PREFIX", "Server Prefix") + fm.getConfigText("MESSAGES", "Private Join Message"));
        }
        if (sendMessage) {
            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                onlinePlayers.sendMessage(fm.getConfigText("PREFIX", "Server Prefix") + String.format(fm.getConfigText("MESSAGES", "Join Message"), p.getName()));
            }
        }
        event.setJoinMessage(null);
    }
}
