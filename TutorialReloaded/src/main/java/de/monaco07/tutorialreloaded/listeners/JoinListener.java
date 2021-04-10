package de.monaco07.tutorialreloaded.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GREEN.toString() + player.getName() + " hat den besten Server betreten");

        player.sendMessage(ChatColor.DARK_RED + "MOIN MEISTA ");

    }

}
