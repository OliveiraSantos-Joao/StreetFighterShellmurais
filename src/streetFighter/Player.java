package streetFighter;

import streetFighter.fighters.Fighter;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {
    //é o jogador


    private Fighter fighter;

    public Player(){

        //chose fighter - -chamar menu streetFighter.fighters
        //fighter = new fighter(menufighters)
    }



//keyboard handler
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
