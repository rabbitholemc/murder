package br.com.rabbithole.murder;

import br.com.rabbithole.murder.player.Spicies;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

public class GameManager {
    private HashMap<Player, Spicies> playersAndSpiciesMap = new HashMap<>();

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

    public Spicies getPlayerSpicie(Player player) {
        return playersAndSpiciesMap.get(player);
    }
}
