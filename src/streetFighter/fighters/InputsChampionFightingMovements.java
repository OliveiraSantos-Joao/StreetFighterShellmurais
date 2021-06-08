package streetFighter.fighters;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import streetFighter.Game;

public class InputsChampionFightingMovements implements KeyboardHandler {

    Fighter champion;

    public InputsChampionFightingMovements(Fighter champion) {
        this.champion = champion;

    }

    public void movement(){
        Keyboard keyboard = new Keyboard(this);

    //keys player1
        KeyboardEvent rightPressedP1 = new KeyboardEvent();
        rightPressedP1.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressedP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftPressedP1 = new KeyboardEvent();
        leftPressedP1.setKey(KeyboardEvent.KEY_LEFT);
        leftPressedP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


    //keys player2
        KeyboardEvent rightPressedP2 = new KeyboardEvent();
        rightPressedP2.setKey(KeyboardEvent.KEY_D);
        rightPressedP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftPressedP2 = new KeyboardEvent();
        leftPressedP2.setKey(KeyboardEvent.KEY_A);
        leftPressedP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        //Event Listeners
        //P1
        keyboard.addEventListener(rightPressedP1);
        keyboard.addEventListener(leftPressedP1);

        //P2
        keyboard.addEventListener(rightPressedP2);
        keyboard.addEventListener(leftPressedP2);

    }




    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){

            case KeyboardEvent.KEY_RIGHT:
                if(champion.getPosX() >= Game.width){
                    break;
                }
                champion.moveRight();
                break;

            case KeyboardEvent.KEY_LEFT:
                if(champion.getPosX() <= 0){
                    break;
                }
                champion.moveLeft();

            case KeyboardEvent.KEY_A:
                if(champion.getPosX() >= Game.width){
                    break;
                }
                champion.moveRight();
                break;

            case KeyboardEvent.KEY_D:
                if(champion.getPosX() <= 0){
                    break;
                }
                champion.moveLeft();
        }



    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
