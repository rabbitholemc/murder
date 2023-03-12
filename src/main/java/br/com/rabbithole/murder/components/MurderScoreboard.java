package br.com.rabbithole.murder.components;

import org.bukkit.entity.Player;

public class MurderScoreboard {
    private final Player player;
    ScoreboardInstance scoreboardInstance;

    public MurderScoreboard(Player player) {
        this.player = player;
        render();
    }

    void render() {
        scoreboardInstance = new ScoreboardInstance("&c&LMURDER");
        scoreboardInstance.add(" ");
        scoreboardInstance.add("&fSua Classe: ");
        scoreboardInstance.add("  ");
        scoreboardInstance.render(player);
    }

    void update() {
        if (scoreboardInstance == null) return;
        if (player == null) return;
        if (!player.isOnline()) return;

        scoreboardInstance.set("&fSua Classe:", 1);
    }

    public Player getPlayer() {
        return player;
    }
}
