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

    private Rectangle rectangle;
    private Rectangle rectangle2;
    private Rectangle rectangle3;

    private Text text;
    private Text text2;
    private Text text3;

    private int currentlyPressedPosition = 1;


//Contructor MainMenu
    public MainMenu() {

        Inputs.setInputScreen(this);

        mainMenuPic = new Picture(10, 10, "BlackBackground2.png");
        mainMenuPic.draw();

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
    public Rectangle getRectangle() {
        return rectangle;
    }
    public Rectangle getRectangle2() {
        return rectangle2;
    }
    public Rectangle getRectangle3() {
        return rectangle3;
    }




// methods
    public void startGame() {

        ChooseFighter chooseFighter = new ChooseFighter();
        System.out.println("start");
        deleteAll();
        ChooseFighter chooseFighter = new ChooseFighter();

    }

    public void drawMainMenu(){

        //First Text
        text = new Text(mainMenuPic.getWidth() / 2, mainMenuPic.getHeight() * (0.6), "Start street");
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

    public void deleteAll(){
        rectangle.delete();
        rectangle2.delete();
        rectangle3.delete();
        text.delete();
        text2.delete();
        text3.delete();
        mainMenuPic.delete();
    }



    @Override
    public void action(int key) {
        switch (key){
            case KeyboardEvent.KEY_DOWN:
                switch (getCurrentlyPressedPosition()) {

                    case 1:
                        getRectangle().delete();
                        getRectangle2().draw();
                        incrementCurrentlyPressedPosition();

                        break;

                    case 2:
                        getRectangle2().delete();
                        getRectangle3().draw();
                        incrementCurrentlyPressedPosition();
                        break;

                    case 3:
                        getRectangle3().delete();
                        getRectangle().draw();
                        setCurrentlyPressedPosition(1);
                        break;
                }
                break;

            case KeyboardEvent.KEY_UP:
                switch (getCurrentlyPressedPosition()) {

                    case 1:
                        getRectangle().delete();
                        getRectangle3().draw();
                        setCurrentlyPressedPosition(3);
                        break;

                    case 2:
                        getRectangle2().delete();
                        getRectangle().draw();
                        decrementCurrentlyPressedPosition();
                        break;

                    case 3:
                        getRectangle3().delete();
                        getRectangle2().draw();
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

