package streetFighter;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import streetFighter.MainMenu;
import streetFighter.Player;
import streetFighter.fighters.PlayerType;
import streetFighter.inputs.Inputs;

public class Game {

    public static final int PADDING = 10;
    public static final int height = 720;
    public static final int width = 1280;

    private MainMenu mainMenu;
    private ChooseFighter chooseFighter;

    public Game(){



    }

    public void init() {

       // mainmenu(){
        //help();
        //criar 2 players

        Rectangle screen = new Rectangle(PADDING, PADDING, width, height);
        screen.draw();

        new Inputs(); //inicialização keyboard;

        MainMenu mainMenu = new MainMenu();


    }

    public void start(){

        chooseFighter = new ChooseFighter();

    }


}
