package br.com.rabbithole.murder;

import br.com.rabbithole.murder.player.Spicies;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameManager {

    private GameStatus gameStatus = GameStatus.LOBBY;
    private HashMap<Player, Spicies> playersAndSpiciesMap = new HashMap<>();


    public Spicies getPlayerSpicie(Player player) {
        return playersAndSpiciesMap.get(player);
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    private void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void startGame() {
        startingStatus();
    }

    private void lobbyStatus() {

    }

    private void startingStatus() {
        setGameStatus(GameStatus.STARTING);

        sortSpiciesToPlayers(new ArrayList<Player>(playersAndSpiciesMap.keySet()));

        playingStatus();
    }

    private void playingStatus() {
        setGameStatus(GameStatus.PLAYING);
    }

    private void endStatus() {

    }

    public void sortSpiciesToPlayers(List<Player> playerList) {
        /*
        *   Pegar players
        *   sortir um player e  dar detetive
        *   sortir outro e dar murderer
        *   setar todos player restante para inocente
        **/
        // Sort and set Detective and remove detective to playerList variable.
        Player sortedPlayer = (Player) playerList.stream().sorted();
        playersAndSpiciesMap.put(sortedPlayer, Spicies.DETECTIVE);
        playerList.remove(sortedPlayer);

        //Sort and set Murder and remove detective to playerList variable.
        sortedPlayer = (Player) playerList.stream().sorted();
        playersAndSpiciesMap.put(sortedPlayer, Spicies.MURDERER);
        playerList.remove(sortedPlayer);

        playerList.forEach(player -> {
            playersAndSpiciesMap.put(player, Spicies.INNOCENT);
        });
    }


}
