package io.github.kuwujii.RakCraftServerTools;

import org.bukkit.plugin.java.JavaPlugin;

import io.github.kuwujii.RakCraftServerTools.events.PlayerSleep;

public class RakCraftServerTools extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerSleep(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("???");
    }
}
