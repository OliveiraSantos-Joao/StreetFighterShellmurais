package ficheirosAntigosIgnore;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import streetFighter.MainMenu;

public class KeyboardInstructions implements KeyboardHandler {

    MainMenu mainMenu;
    Keyboard keyboard;
    public KeyboardInstructions(MainMenu mainMenu){
        this.mainMenu = mainMenu;

    }

    public void init(){

        keyboard = new Keyboard(this);

        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_SPACE);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
           switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_SPACE:
                System.out.println("entrou");
                //mainMenu.deleteInstruction();
                mainMenu = new MainMenu();
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
