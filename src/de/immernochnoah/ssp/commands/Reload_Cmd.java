package de.immernochnoah.ssp.commands;

import de.immernochnoah.ssp.file_system.File_Manager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload_Cmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        File_Manager fm = new File_Manager();
        if (!player.hasPermission(fm.getConfigText("SETTINGS", "Reload Permission"))) {
            player.sendMessage(fm.getConfigText("MESSAGES", "No Permisson"));
        } else {
            fm.reloadFile();
            player.sendMessage(fm.getConfigText("MESSAGES", "Reload Message"));
        }
        return false;
    }
}
