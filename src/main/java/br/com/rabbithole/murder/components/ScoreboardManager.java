package br.com.rabbithole.murder.components;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardManager {
    public static List<MurderScoreboard> scoreboards = new ArrayList<>();

    public static void init(Plugin plugin) {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (MurderScoreboard scoreboard : scoreboards) {
                    scoreboard.update();
                }
            }
        }.runTaskTimer(plugin, 0, 20L);
    }

    public static void addPlayer(Player player) {
        scoreboards.add(new MurderScoreboard(player));
    }

    public static void removePlayer(Player player) {
        scoreboards.removeIf(scoreboards -> scoreboards.getPlayer().equals(player));
    }
}
