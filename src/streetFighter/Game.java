package streetFighter;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import streetFighter.MainMenu;
import streetFighter.Player;
import streetFighter.fighters.PlayerType;
import streetFighter.inputs.Inputs;

public class Game {

    private int playernumber = 2;
    private Player player1;
    private Player player2;

    public static final int PADDING = 10;
    public static final int height = 720;
    public static final int width = 1280;

    private MainMenu mainMenu;

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

        //players
        player1 = new Player((Game.width/4),400, PlayerType.PLAYER1);
        player2 = new Player(Game.width/4 *3 , 400,PlayerType.PLAYER2);

    }


    public void start(){
        //choose fighter
        //streetFighter.arena init
        //streetFighter.arena start
    }

    private void mainMenu(){
        //1 - start
        //2 - quit
        //3 - help

    }

}
