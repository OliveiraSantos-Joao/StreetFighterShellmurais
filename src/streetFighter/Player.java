package streetFighter;

import streetFighter.fighters.Fighter;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import streetFighter.fighters.PlayerType;

public class Player {
    //é o jogador
    // ESTA CLASSE É OBSOLETA PARA JÁ

    private Fighter fighter;
    private PlayerType playerType;

    public Player(int xInitial, int yInitial, PlayerType playerType){

    }

    public Fighter getFighter() {
        return fighter;
    }

}
