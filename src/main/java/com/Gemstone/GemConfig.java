package com.Gemstone;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class GemConfig {
    public static boolean returnOnDrop() {
        if (Main.getInstance() == null) {
            System.err.println("RisersGemstone: Main plugin instance is not available for GemConfig.returnOnDrop(). Defaulting to true.");
            return true;
        }
        FileConfiguration config = Main.getInstance().getConfig(); // Get the current, up-to-date config
        return config.getBoolean("gem-settings.return-on-drop", true);
    }

    public static boolean returnOnDeath() {
        if (Main.getInstance() == null) {
            System.err.println("RisersGemstone: Main plugin instance is not available for GemConfig.returnOnDeath(). Defaulting to true.");
            return true;
        }
        FileConfiguration config = Main.getInstance().getConfig();
        return config.getBoolean("gem-settings.return-on-death", true);
    }

    public static boolean returnOnContainer() {
        if (Main.getInstance() == null) {
            System.err.println("RisersGemstone: Main plugin instance is not available for GemConfig.returnOnContainer(). Defaulting to true.");
            return true;
        }
        FileConfiguration config = Main.getInstance().getConfig();
        return config.getBoolean("gem-settings.return-on-container", true);
    }
}