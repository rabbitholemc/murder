package br.com.rabbithole.murder.components;

import br.com.rabbithole.murder.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardInstance {
    private String title;
    private List<String> lines = new ArrayList<>();
    private Player player;
    Scoreboard scoreboard;
    Objective objective;

    public ScoreboardInstance(String title) {
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        this.title = title;

        objective = scoreboard.registerNewObjective("score", Criteria.DUMMY, StringUtils.formatString(title));
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    public void add(String line) {
        lines.add(line);
    }

    public void set(String line, int index) {
        lines.set(index, line);
    }

    void update(String line, String newLine) {
        if (!Bukkit.getOnlinePlayers().contains(player) || player.getScoreboard() == null) {
            return;
        }

        int scoreValue = -1;
        for (String string : player.getScoreboard().getEntries()) {
            if (string.equals(line)) {
                scoreValue = player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore(string).getScore();
                player.getScoreboard().resetScores(string);
                break;
            }
        }

        Scoreboard score = player.getScoreboard();
        score.getObjective(DisplaySlot.SIDEBAR).getScore(newLine).setScore(scoreValue);
    }

    public void render(Player player) {
        int lineSize = lines.size();
        for (String line : lines) {
            Score score = objective.getScore(line);
            score.setScore(lineSize);
            lineSize--;
        }

        player.setScoreboard(scoreboard);
        this.player = player;
    }
}
