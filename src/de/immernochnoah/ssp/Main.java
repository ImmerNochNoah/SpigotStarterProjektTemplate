package de.immernochnoah.ssp;

import de.immernochnoah.ssp.commands.Help_Cmd;
import de.immernochnoah.ssp.commands.Reload_Cmd;
import de.immernochnoah.ssp.events.PlayerJoinEventHandler;
import de.immernochnoah.ssp.events.PlayerQuitEventHandler;
import de.immernochnoah.ssp.file_system.Config_File;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Config_File config_file = new Config_File();
        config_file.createConfig();

        Bukkit.getPluginManager().registerEvents(new PlayerJoinEventHandler(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitEventHandler(), this);

        getCommand("hilfe").setExecutor(new Help_Cmd());
        getCommand("ssp_reload").setExecutor(new Reload_Cmd());
    }

    @Override
    public void onDisable() {

    }
}
