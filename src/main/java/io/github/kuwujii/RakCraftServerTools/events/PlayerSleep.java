package io.github.kuwujii.RakCraftServerTools.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class PlayerSleep implements Listener { // Event that sends a message about every player that went to sleep
    @EventHandler
    void onPlayerSleep(PlayerBedEnterEvent event) {
        Player player = event.getPlayer(); // Get the player that went to sleep
        Bukkit.broadcastMessage(player.getDisplayName()+" went to sleep");
    }

    @EventHandler
    void onPlayerSleep(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer(); // Get the player that got up
        Bukkit.broadcastMessage(player.getDisplayName()+" got up");
    }
}