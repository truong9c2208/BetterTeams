package com.booksaw.betterTeams.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.booksaw.betterTeams.Team;

public class PlayerEvents implements Listener {
    @EventHandler
    public void onPlayer(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        Team team = Team.getTeam(player);
        if (team == null) {
            return;
        };

        Location location = team.getTeamHome();
        if (location == null) {
            return;
        }

        event.setRespawnLocation(location);
    }
}