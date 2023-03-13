package br.com.rabbithole.murder.components;

public class ScoreboardExecutor {
    public ScoreboardInstance createScoreboard(String name, String... lines) {
        ScoreboardInstance scoreboardInstance = new ScoreboardInstance(name);
        for (String line : lines) {
            scoreboardInstance.add(line);
        }
        return scoreboardInstance;
    }
}
