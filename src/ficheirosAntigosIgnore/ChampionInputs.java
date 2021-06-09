package ficheirosAntigosIgnore;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import streetFighter.ChooseFighter;

public class ChampionInputs implements KeyboardHandler {

    private int pressedCharacterP1;
    private int pressedCharacterP2;
    private ChooseFighter chooseFighter;

    //*****Classe constructor*****
    public ChampionInputs(int pressedCharacterP1 , int pressedCharacterP2 , ChooseFighter chooseFighters){
        this.pressedCharacterP1 = pressedCharacterP1;
        this.pressedCharacterP2 = pressedCharacterP2;
        this.chooseFighter = chooseFighters;
    }

    public void menuChooseChampions(){

            Keyboard keyboard = new Keyboard(this);
            //Key for P1
            KeyboardEvent rightPressedP1 = new KeyboardEvent();
            rightPressedP1.setKey(KeyboardEvent.KEY_RIGHT);
            rightPressedP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            KeyboardEvent leftPressedP1 = new KeyboardEvent();
            leftPressedP1.setKey(KeyboardEvent.KEY_LEFT);
            leftPressedP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            KeyboardEvent spacePressedP1 = new KeyboardEvent();
            spacePressedP1.setKey(KeyboardEvent.KEY_SPACE);
            spacePressedP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            //Keys for P2
            KeyboardEvent rightPressedP2 = new KeyboardEvent();
            rightPressedP2.setKey(KeyboardEvent.KEY_D);
            rightPressedP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            KeyboardEvent leftPressedP2 = new KeyboardEvent();
            leftPressedP2.setKey(KeyboardEvent.KEY_A);
            leftPressedP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            KeyboardEvent spacePressedP2 = new KeyboardEvent();
            spacePressedP2.setKey(KeyboardEvent.KEY_W);
            spacePressedP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            //Event Listeners
            //P1
            keyboard.addEventListener(rightPressedP1);
            keyboard.addEventListener(leftPressedP1);
            keyboard.addEventListener(spacePressedP1);
            //P2
            keyboard.addEventListener(rightPressedP2);
            keyboard.addEventListener(leftPressedP2);
            keyboard.addEventListener(spacePressedP2);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                switch (pressedCharacterP1) {

                    case 1:
                        pressedCharacterP1++;
                        break;

                    case 2:
                        pressedCharacterP1++;
                        break;

                    case 3:
                        pressedCharacterP1++;
                        break;

                    case 4:
                        pressedCharacterP1 = 1;
                        break;
                }
                break;

            case KeyboardEvent.KEY_LEFT:

                switch  (pressedCharacterP1){

                    case 1:
                        pressedCharacterP1 = chooseFighter.getMaxchampions();//para voltar ao ultimo
                        break;
                    case 2:
                        pressedCharacterP1--;
                        break;
                    case 3:
                        pressedCharacterP1--;
                        break;

                    case 4:
                        pressedCharacterP1--;
                        break;
                }
                break;

            case KeyboardEvent.KEY_D:
                switch (pressedCharacterP2) {
                    case 1:
                        pressedCharacterP2 ++;
                        break;

                    case 2:
                        pressedCharacterP2 ++;
                        break;

                    case 3:
                        pressedCharacterP2 ++;
                        break;

                    case 4:
                        pressedCharacterP2 = 1; //pq da a volta !!
                        break;
                }
                break;

            case KeyboardEvent.KEY_A:
                switch (pressedCharacterP2){
                    case 1:
                        pressedCharacterP2 = chooseFighter.getMaxchampions();
                        break;

                    case 2:
                        pressedCharacterP2--;
                        break;

                    case 3:
                        pressedCharacterP2--;
                        break;

                    case 4:
                        pressedCharacterP2--;
                        break;

                }
                break;
        }
        update();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    private void update(){

        for (int i = 0; i < chooseFighter.getPhotoFrame().length; i++) {
            if(pressedCharacterP1 == i+1 && pressedCharacterP2 == i+1){
                chooseFighter.getPhotoFrame()[i].setColor(Color.WHITE);
                chooseFighter.getPhotoFrame()[i].draw();
                continue;
            }
            if(pressedCharacterP1 == i + 1) {
                chooseFighter.getPhotoFrame()[i].setColor(Color.RED);
                chooseFighter.getPhotoFrame()[i].draw();
                continue;
            }
            if(pressedCharacterP2 == i + 1) {
                chooseFighter.getPhotoFrame()[i].setColor(Color.BLUE);
                chooseFighter.getPhotoFrame()[i].draw();
                continue;
            }
            chooseFighter.getPhotoFrame()[i].delete();
        }

    }
}
