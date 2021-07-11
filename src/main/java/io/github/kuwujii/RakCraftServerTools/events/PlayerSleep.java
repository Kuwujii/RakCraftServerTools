package io.github.kuwujii.RakCraftServerTools.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class PlayerSleep implements Listener { // Event that sends a message about every player that went to sleep
    Server server = Bukkit.getServer();
    World overworld = server.getWorlds().get(0);

    int sleepingPlayers = 0; // Amount of players that are sleeping

    @EventHandler
    void onPlayerSleep(PlayerBedEnterEvent event) {
        Player player = event.getPlayer(); // Get the player that went to sleep
        
        if(overworld.getPlayers().contains(player) && ((overworld.getTime() > 12541 && overworld.getTime() < 23460) || overworld.isThundering())) { // If the player is in overworld and it's night/thunder in the overworld
            int requiredAmount = Math.round(((float) server.getOnlinePlayers().size()*overworld.getGameRuleValue(GameRule.PLAYERS_SLEEPING_PERCENTAGE))/100); // Get the number of players required to sleep to pass the night
            sleepingPlayers++;

            server.broadcastMessage(ChatColor.YELLOW+player.getDisplayName()+" went to sleep "+sleepingPlayers+"/"+requiredAmount);
        }
    }

    @EventHandler
    void onPlayerAwake(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer(); // Get the player that got up

        int requiredAmount = Math.round(((float) server.getOnlinePlayers().size()*overworld.getGameRuleValue(GameRule.PLAYERS_SLEEPING_PERCENTAGE))/100); // Get the number of players required to sleep to pass the night
        sleepingPlayers--;

        if((overworld.getTime() > 12541 && overworld.getTime() < 23460) || overworld.isThundering()) {
            server.broadcastMessage(ChatColor.YELLOW+player.getDisplayName()+" got up "+sleepingPlayers+"/"+requiredAmount);
        }
    }
}
