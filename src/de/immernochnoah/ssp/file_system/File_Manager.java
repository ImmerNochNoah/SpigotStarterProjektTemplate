package de.immernochnoah.ssp.file_system;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class File_Manager {

    private static File folder;
    private static File file;
    private static YamlConfiguration cfg;
    private static ArrayList<String> configKey = new ArrayList<>();
    private static ArrayList<String> textOutput = new ArrayList<>();
    private static String folder_Name = "SpigotStarterProjekt";

    static {
        File_Manager.folder = new File("plugins/"+ folder_Name +"/");
        File_Manager.file = new File("plugins/"+ folder_Name +"/config.yml");
        File_Manager.cfg = YamlConfiguration.loadConfiguration(File_Manager.file);
    }

    public void reloadFile() {
        File_Manager.cfg = YamlConfiguration.loadConfiguration(File_Manager.file);
        System.out.println(folder_Name + " Einstellungen wurden aktualisiert!");
    }

    public void setupFiles() {
        if (!File_Manager.folder.exists()) {
            File_Manager.folder.mkdir();
        }
        if (!File_Manager.file.exists()) {
            try {
                File_Manager.file.createNewFile();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void saveConfigFile() {
        try {
            File_Manager.cfg.save(File_Manager.file);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public boolean configIsExisting(final String name) {
        return File_Manager.cfg.get("Config." + name) != null;
    }

    public String getConfigText(String config, String key) {
        String t1 = File_Manager.cfg.getString("Config." + config + "." + key);
        String t2 = t1.replace("&", "§");
        return t2;
    }

    public void saveConfig(final String config) {
        for(int i=0;i<configKey.size();i++){
            File_Manager.cfg.set("Config." + config + configKey.get(i), (Object)textOutput.get(i));
        }
        finishConfig();
        saveConfigFile();
    }

    public void addConfigText(String key, String text) {
        configKey.add("." + key);
        textOutput.add(text);
    }

    public void finishConfig() {
        configKey.clear();
        textOutput.clear();
    }

}
