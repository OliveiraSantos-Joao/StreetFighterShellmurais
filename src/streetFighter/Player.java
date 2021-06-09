package streetFighter;

import streetFighter.fighters.Fighter;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import streetFighter.fighters.PlayerType;

public class Player {
    //é o jogador


    private Fighter fighter;
    private PlayerType playerType;

    public Player(int xInitial, int yInitial, PlayerType playerType){
        this.playerType = playerType;

        this.fighter =  new Fighter(xInitial, yInitial, playerType);

        //chose fighter - -chamar menu streetFighter.fighters
        //fighter = new fighter(menufighters)
    }

    public Fighter getFighter() {
        return fighter;
    }


}
