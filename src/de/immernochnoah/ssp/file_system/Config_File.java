package de.immernochnoah.ssp.file_system;

public class Config_File {

    public void createConfig() {
        File_Manager fm = new File_Manager();
        if(!fm.configIsExisting("PREFIX")) {
            fm.addConfigText("Server Prefix", "&cPrefix &8:");
            fm.saveConfig("PREFIX");
        }
        if(!fm.configIsExisting("MESSAGES")) {
            fm.addConfigText("Private Join Message", " &7Willkommen auf &eTestServer.de");
            fm.addConfigText("Join Message", " &a%s &7ist dem Server beigetreten.");
            fm.addConfigText("Leave Message", " &a%s &7hat den Server verlassen.");
            fm.addConfigText("Help", " &7Wenn du Hilfe brauchst, kannst du auf unseren Discord vorbei schauen...");
            fm.addConfigText("Reload Message", " &aEinstellungen wurden aktualisiert!");
            fm.addConfigText("No Permisson", " &cDu hast keine Rechte!");
            fm.saveConfig("MESSAGES");
        }
        if(!fm.configIsExisting("SETTINGS")) {
            fm.addConfigText("Reload Permission", "ssp:reload:plugin");
            fm.addConfigText("Send Join Message", "true");
            fm.addConfigText("Send Private Join Message", "true");
            fm.addConfigText("Send Leave Message", "true");
            fm.saveConfig("SETTINGS");
        }
    }
}
