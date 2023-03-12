package br.com.rabbithole.murder;

import br.com.rabbithole.murder.commands.SetupCommand;
import br.com.rabbithole.murder.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class Murder extends JavaPlugin {
    private static int numberOfPlayers;

    @Override
    public void onEnable() {
        // Plugin startup logic
        registers();
        numberOfPlayers = getInstance().getConfig().getInt("players");
        Bukkit.getConsoleSender().sendMessage(StringUtils.formatString("<green>Número de Jogadores Configurados: " + numberOfPlayers));
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
    }

    void commands() {
        new SetupCommand();
    }

    void events() {}

    public static Murder getInstance() {
        return Murder.getPlugin(Murder.class);
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public static void setNumberOfPlayers(int numberOfPlayers) {
        Murder.numberOfPlayers = numberOfPlayers;
    }
}
