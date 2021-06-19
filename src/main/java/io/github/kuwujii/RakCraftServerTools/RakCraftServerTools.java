package io.github.kuwujii.RakCraftServerTools;

import org.bukkit.plugin.java.JavaPlugin;

public class RakCraftServerTools extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Działa");
    }

    @Override
    public void onDisable() {
        getLogger().info("Nie działa");
    }
}
