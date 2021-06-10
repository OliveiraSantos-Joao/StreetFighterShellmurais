package streetFighter;

import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MainMenu implements ToDo {

    private Picture mainMenuPic;

    private Rectangle rectangleStart;
    private Rectangle rectangleInstructions;
    private Rectangle rectangleExit;

    private Text textStart;
    private Text textInstructions;
    private Text textExit;

    private int RECT_X_DEFAULT;

    private int currentlyPressedPosition = 1;


//Contructor MainMenu
    public MainMenu() {

        Inputs.setInputScreen(this);

        mainMenuPic = new Picture(10, 10, "BlackBackground2.png");
        mainMenuPic.draw();

        RECT_X_DEFAULT=mainMenuPic.getWidth() / 2;

        currentlyPressedPosition = 1;
        drawMainMenu();

    }

// Getters Setters
    public int getCurrentlyPressedPosition() {
        return currentlyPressedPosition;
    }
    public void incrementCurrentlyPressedPosition() {
        this.currentlyPressedPosition++;
    }
    public void decrementCurrentlyPressedPosition() {
        this.currentlyPressedPosition--;
    }
    public void setCurrentlyPressedPosition(int currentlyPressedPosition) {
        this.currentlyPressedPosition = currentlyPressedPosition;
    }
    public Rectangle getRectangleStart() {
        return rectangleStart;
    }
    public Rectangle getRectangleInstructions() {
        return rectangleInstructions;
    }
    public Rectangle getRectangleExit() {
        return rectangleExit;
    }




// methods
    public void startGame() {

        ChooseFighter chooseFighter = new ChooseFighter();
        System.out.println("start");
        deleteAll();

    }

    public void drawMainMenu(){

        //First Text
        textStart = new Text(RECT_X_DEFAULT, mainMenuPic.getHeight() * (0.6), "Start street");
        textStart.setColor(Color.WHITE);
        textStart.draw();
        //First Text Rectangle
        rectangleStart = new Rectangle(textStart.getX() - 50, textStart.getY() - 10, textStart.getWidth() + 100, textStart.getHeight() + 20);
        rectangleStart.setColor(Color.WHITE);
        rectangleStart.draw();

        //Second Text
        textInstructions = new Text(textStart.getX(), textStart.getY() + 60, "Instructions");
        textInstructions.setColor(Color.WHITE);
        textInstructions.draw();
        //Second Text Rectangle
        rectangleInstructions = new Rectangle(textInstructions.getX() - 50, textInstructions.getY() - 10, textInstructions.getWidth() + 100, textInstructions.getHeight() + 20);
        rectangleInstructions.setColor(Color.WHITE);

        //Third Text
        textExit = new Text(textInstructions.getX() + 20, textInstructions.getY() + 60, "Exit");
        textExit.setColor(Color.WHITE);
        textExit.draw();
        //Third Text Rectangle
        rectangleExit = new Rectangle(textInstructions.getX() - 50, textExit.getY() - 10, textStart.getWidth() + 100, textExit.getHeight() + 20);
        rectangleExit.setColor(Color.WHITE);

    }

    public void deleteAll(){
        rectangleStart.delete();
        rectangleInstructions.delete();
        rectangleExit.delete();
        textStart.delete();
        textInstructions.delete();
        textExit.delete();
        mainMenuPic.delete();
    }



    @Override
    public void action(int key) {
        switch (key){
            case KeyboardEvent.KEY_DOWN:
                switch (getCurrentlyPressedPosition()) {

                    case 1:
                        getRectangleStart().delete();
                        getRectangleInstructions().draw();
                        incrementCurrentlyPressedPosition();

                        break;

                    case 2:
                        getRectangleInstructions().delete();
                        getRectangleExit().draw();
                        incrementCurrentlyPressedPosition();
                        break;

                    case 3:
                        getRectangleExit().delete();
                        getRectangleStart().draw();
                        setCurrentlyPressedPosition(1);
                        break;
                }
                break;

            case KeyboardEvent.KEY_UP:
                switch (getCurrentlyPressedPosition()) {

                    case 1:
                        getRectangleStart().delete();
                        getRectangleExit().draw();
                        setCurrentlyPressedPosition(3);
                        break;

                    case 2:
                        getRectangleInstructions().delete();
                        getRectangleStart().draw();
                        decrementCurrentlyPressedPosition();
                        break;

                    case 3:
                        getRectangleExit().delete();
                        getRectangleInstructions().draw();
                        decrementCurrentlyPressedPosition();
                        break;
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                switch (getCurrentlyPressedPosition()) {

                    case 1:
                        System.out.println("1");
                        deleteAll();
                        startGame();
                        break;

                    case 2:
                        System.out.println("2");
                        deleteAll();
                        new Instructions();
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

}

