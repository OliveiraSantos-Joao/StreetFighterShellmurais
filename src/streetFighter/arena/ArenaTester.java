package streetFighter.arena;

import streetFighter.Game;
import streetFighter.Player;
import streetFighter.fighters.Fighter;

public class ArenaTester {

    public static void main(String[] args) {
       Player player1 = new Player( 30 ,400);
       Player player2 = new Player(Game.width-10-100 , 400);

        Arena arena = new Arena(player1.getFighter(),player2.getFighter());
    }
}
