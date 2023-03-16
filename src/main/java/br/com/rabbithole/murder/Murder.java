package br.com.rabbithole.murder;

import br.com.rabbithole.murder.commands.SetupCommand;
import br.com.rabbithole.murder.components.ScoreboardManager;
import br.com.rabbithole.murder.events.OnJoin;
import br.com.rabbithole.murder.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class Murder extends JavaPlugin {
    private static GameManager gameManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        registers();
        gameManager = new GameManager(this);
        Bukkit.getConsoleSender().sendMessage(StringUtils.formatString("<green>Número de Jogadores Configurados: " + gameManager.getMaxOfPlayers()));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        HandlerList.unregisterAll(this);
    }

    void registers() {
        saveDefaultConfig();
        commands();
        events();
        ScoreboardManager.init(this);
    }

    void commands() {
        new SetupCommand(this);
    }

    void events() {
        new OnJoin(this);
    }

    public static GameManager getGameManager() {
        return gameManager;
    }
}
