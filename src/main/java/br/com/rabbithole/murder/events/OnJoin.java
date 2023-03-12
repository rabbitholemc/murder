package br.com.rabbithole.murder.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class OnJoin {

    private List<Player> playerList = new ArrayList<>();

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        playerList.add(player);

    }

    public int getAmountPlayer() {
        return playerList.size();
    }
}
