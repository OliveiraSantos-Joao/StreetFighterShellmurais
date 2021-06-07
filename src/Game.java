import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private int playernumber = 2;
    private Player player1;
    private Player player2;

    public static final int PADDING = 10;
    public static final int height = 720;
    public static final int width = 1280;


    public Game(){

        MainMenu main = new MainMenu();

    }

    public void init() {

       // mainmenu(){
        //help();
        //criar 2 players

        Rectangle screen = new Rectangle(PADDING, PADDING, width, height);
        screen.draw();
        MainMenu main = new MainMenu();


        //players
        player1 = new Player();
        player2 = new Player();

    }


    public void start(){
        //choose fighter
        //arena init
        //arena start

    }

    private void mainMenu(){
        //1 - start
        //2 - quit
        //3 - help

    }

}
