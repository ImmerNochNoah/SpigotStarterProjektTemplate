package de.immernochnoah.ssp.events;

import de.immernochnoah.ssp.file_system.File_Manager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitEventHandler implements Listener {

    @EventHandler
    public void handlePlayerJoinEvent(PlayerQuitEvent event) {
        Player p  = event.getPlayer();
        File_Manager fm = new File_Manager();
        boolean sendMessage = Boolean.parseBoolean(fm.getConfigText("SETTINGS", "Send Leave Message"));

        if (sendMessage) {
            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                onlinePlayers.sendMessage(fm.getConfigText("PREFIX", "Server Prefix") + String.format(fm.getConfigText("MESSAGES", "Leave Message"), p.getName()));
            }
        }
        event.setQuitMessage(null);
    }
}
