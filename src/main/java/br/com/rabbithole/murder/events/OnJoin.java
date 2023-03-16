package br.com.rabbithole.murder.events;

import br.com.rabbithole.murder.GameManager;
import br.com.rabbithole.murder.Murder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class OnJoin implements Listener {

    private final Plugin plugin;
    private final GameManager gameManager = Murder.getGameManager();

    public OnJoin(Plugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        gameManager.addPlayer(player);

        if(gameManager.canStart()) {
            gameManager.start();
        }
    }
}
