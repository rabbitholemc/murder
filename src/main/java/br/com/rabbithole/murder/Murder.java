package br.com.rabbithole.murder;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class Murder extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registers();
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

    void commands() {}

    void events() {}
}
