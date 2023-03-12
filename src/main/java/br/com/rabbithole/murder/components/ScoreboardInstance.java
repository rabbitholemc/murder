package br.com.rabbithole.murder.components;

import br.com.rabbithole.murder.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

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
}
