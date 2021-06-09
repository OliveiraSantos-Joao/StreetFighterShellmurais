package tester;

import streetFighter.Game;
import streetFighter.Player;
import streetFighter.arena.Arena;
import streetFighter.fighters.Fighter;
import streetFighter.fighters.PlayerType;

public class ArenaTester {

    public static void main(String[] args) {
       Player player1 = new Player( 30 ,400, PlayerType.PLAYER1);
       Player player2 = new Player(Game.width-10-100 , 400, PlayerType.PLAYER2);

        Arena arena = new Arena(player1.getFighter(),player2.getFighter());
    }
}
