package br.com.rabbithole.murder;

import br.com.rabbithole.murder.player.Spicies;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

public class GameManager {
    private HashMap<Player, Spicies> playersAndSpiciesMap = new HashMap<>();

    public void sortSpiciesToPlayers(List<Player> playerList) {

        boolean haveDetetive;
        boolean haveMurderer;

        for (Player player : playerList) {
            /*
            Pegar players
            sortir um player e  dar detetive
            sortir outro e dar murderer
            setar todos player restante para inocente
            * */
        }
    }
}
