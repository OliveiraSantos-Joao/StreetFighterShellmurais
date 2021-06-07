import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MainMenu implements KeyboardHandler {

    private Picture mainMenu;

    private Rectangle rectangle;
    private Rectangle rectangle2;
    private Rectangle rectangle3;

    private Text text;
    private Text text2;
    private Text text3;

    private int currentlyPressedPosition = 1;

    public MainMenu() {

        mainMenu = new Picture(10, 10, "BlackBackground2.png");
        mainMenu.draw();
        init();
    }

    public void init() {

        currentlyPressedPosition = 1;

        drawMainMenu();

        //Initializes the Keyboard to get input
        keyboardInit();
    }

    private void keyboardInit() {

        Keyboard keyboard = new Keyboard(this);


        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_UP);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(upPressed);
        keyboard.addEventListener(downPressed);
        keyboard.addEventListener(spacePressed);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_DOWN:
                switch (currentlyPressedPosition) {

                    case 1:
                        rectangle.delete();
                        rectangle2.draw();
                        currentlyPressedPosition++;
                        break;

                    case 2:
                        rectangle2.delete();
                        rectangle3.draw();
                        currentlyPressedPosition++;
                        break;

                    case 3:
                        rectangle3.delete();
                        rectangle.draw();
                        currentlyPressedPosition = 1;
                        break;
                }
                break;

            case KeyboardEvent.KEY_UP:
                switch (currentlyPressedPosition) {

                    case 1:
                        rectangle.delete();
                        rectangle3.draw();
                        currentlyPressedPosition = 3;
                        break;

                    case 2:
                        rectangle2.delete();
                        rectangle.draw();
                        currentlyPressedPosition--;
                        break;

                    case 3:
                        rectangle3.delete();
                        rectangle2.draw();
                        currentlyPressedPosition--;
                        break;
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                switch (currentlyPressedPosition) {

                    case 1:
                        System.out.println("1");
                        startGame();
                        break;

                    case 2:
                        System.out.println("2");
                        instructions();
                        break;

                    case 3:
                        // Exit clause (DONE)
                        System.out.println("3");
                        Runtime.getRuntime().exit(0);
                        break;
                    default:
                        System.out.println("DEFAULT");
                }
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    public void instructions() {

        System.out.println("inst");

        Rectangle rectangleInst = new Rectangle(Game.PADDING + 35, Game.PADDING + 35, Game.width - 70, Game.height - 70);

        rectangleInst.setColor(Color.DARK_GRAY);
        rectangleInst.fill();

        Text textInst1 = new Text(Game.PADDING + 45, Game.PADDING + 45, "Teste");
        textInst1.setColor(Color.WHITE);


        textInst1.draw();


    }


    public void startGame() {

        System.out.println("start");

    }

    public void drawMainMenu(){

        //First Text
        text = new Text(mainMenu.getWidth() / 2, mainMenu.getHeight() * (0.6), "Start Game");
        text.setColor(Color.WHITE);
        text.draw();
        //First Text Rectangle
        rectangle = new Rectangle(text.getX() - 50, text.getY() - 10, text.getWidth() + 100, text.getHeight() + 20);
        rectangle.setColor(Color.WHITE);
        rectangle.draw();

        //Second Text
        text2 = new Text(text.getX(), text.getY() + 60, "Instructions");
        text2.setColor(Color.WHITE);
        text2.draw();
        //Second Text Rectangle
        rectangle2 = new Rectangle(text2.getX() - 50, text2.getY() - 10, text2.getWidth() + 100, text2.getHeight() + 20);
        rectangle2.setColor(Color.WHITE);

        //Third Text
        text3 = new Text(text2.getX(), text2.getY() + 60, "\t\t\tExit");
        text3.setColor(Color.WHITE);
        text3.draw();
        //Third Text Rectangle
        rectangle3 = new Rectangle(text3.getX() - 50, text3.getY() - 10, text3.getWidth() + 100, text3.getHeight() + 20);
        rectangle3.setColor(Color.WHITE);

    }


}
