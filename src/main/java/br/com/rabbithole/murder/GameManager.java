package br.com.rabbithole.murder;

import br.com.rabbithole.murder.player.Role;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.*;

public class GameManager {

    private Plugin plugin;
    private int maxOfPlayers;
    private final int minimalPlayerToPlay = 2;
    private GameStatus gameStatus = GameStatus.LOBBY;
    private final Set<Player> playerSet = new HashSet<>();
    private final HashMap<Player, Role> playerRoleHashMap = new HashMap<>();

    public GameManager(Plugin plugin) {
        this.plugin = plugin;
        maxOfPlayers = plugin.getConfig().getInt("players");
    }

    public int getMaxOfPlayers() {
        return maxOfPlayers;
    }

    public void setMaxOfPlayers(int number) {
        maxOfPlayers = number;
    }

    public void addPlayer(Player player) {
        playerSet.add(player);
    }

    public int getAmountPlayers() {
        return playerSet.size();
    }

    public Role getPlayerRole(Player player) {
        return playerRoleHashMap.get(player);
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    private void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    private void onLobby() {
        if(getAmountPlayers() >= minimalPlayerToPlay) {
            setGameStatus(GameStatus.STARTING);
            return;
        }
    }

    public void start() {

    }

    private void onStarting() {
        if(getAmountPlayers() >= minimalPlayerToPlay) {
            setGameStatus(GameStatus.PLAYING);
            raffleRoleToPlayers(new ArrayList<Player>(playerRoleHashMap.keySet()));
            return;
        }
    }

    private void onPlaying() {

    }

    public void raffleRoleToPlayers(List<Player> playerList) {
        Random random = new Random();

        // Random and set Detective and remove Detective to playerList variable.
        Player randomPlayer = (Player) playerList.get(random.nextInt(playerList.size()));
        playerRoleHashMap.put(randomPlayer, Role.DETECTIVE);
        playerList.remove(randomPlayer);

        //Random and set Murder and remove Murder to playerList variable.
        randomPlayer = (Player) playerList.get(random.nextInt(playerList.size()));
        playerRoleHashMap.put(randomPlayer, Role.MURDERER);
        playerList.remove(randomPlayer);

        playerList.forEach(player -> {
            playerRoleHashMap.put(player, Role.INNOCENT);
        });
    }

    public boolean canStart() {
        return playerSet.size() >= minimalPlayerToPlay;
    }

}
