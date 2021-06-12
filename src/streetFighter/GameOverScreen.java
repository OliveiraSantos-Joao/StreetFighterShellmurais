package streetFighter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import streetFighter.arena.Arena;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;

import java.awt.*;

public class GameOverScreen implements ToDo {

    private Rectangle mainMenuRect;
    private Text mainMenuText;
    private Rectangle startAgainRect;
    private Text startAgainText;
    private Text winnerText;
    private Rectangle winnerRect;

    private Rectangle pauseRect;


    private int keyPressed = 1;
    private int maxChoices = 2;


    private final int halfWidth = Game.WIDTH / 2;
    private final int halfHeight = Game.HEIGHT / 2;
    private int winner;
    private Arena arena;

//contructor
    public GameOverScreen(int winner,Arena arena) {
        Inputs.setInputScreen(this);
        this.arena = arena;
        this.winner = winner;
        init();

    }

    private void init() {

        //winner text and rect
        winnerText = new Text(halfWidth ,halfHeight - (halfHeight/2),"Player " + winner + " is the WINNER CARALHO!");
        winnerText.grow(300,40);

        winnerRect = new Rectangle(winnerText.getX() - 15, winnerText.getY(), winnerText.getWidth() - 150, winnerText.getHeight() +10 );
        winnerRect.setColor(Color.BLACK);

        winnerRect.fill();
        winnerText.setColor(Color.ORANGE);
        winnerText.draw();

        //pause rectangle
        pauseRect = new Rectangle(Game.WIDTH/3 + Game.PADDING, Game.HEIGHT/3 + Game.PADDING, Game.WIDTH/3, Game.HEIGHT/3 + 100);
        pauseRect.fill();

        //text creation
        mainMenuText = new Text(halfWidth, halfHeight, "Main Menu");
        mainMenuText.grow(100, 20);

        startAgainText = new Text(halfWidth, halfHeight + 100, "Start again");
        startAgainText.grow(100, 20);

        //rec creation
        mainMenuRect = new Rectangle(mainMenuText.getX() - 15, mainMenuText.getY(), mainMenuText.getWidth() - 40, mainMenuText.getHeight() - 5);
        startAgainRect = new Rectangle(startAgainText.getX() - 15, startAgainText.getY() - 5, startAgainText.getWidth() - 40, startAgainText.getHeight() + 5);

        //set colours
        mainMenuRect.setColor(Color.WHITE);
        startAgainRect.setColor(Color.WHITE);

        mainMenuText.setColor(Color.BLACK);
        startAgainText.setColor(Color.WHITE);

        //draw and fill
        mainMenuRect.fill();
        mainMenuText.draw();
        startAgainText.draw();

    }


    @Override
    public void actionPressed(int key) {

        switch (key){
            case KeyboardEvent.KEY_UP:
                switch (keyPressed) {
                    case 1:
                        updateDelete();
                        choiceStartAgain();
                        keyPressed = maxChoices;
                        break;

                    case 2:
                        updateDelete();
                        choiceMainMenu();
                        keyPressed--;
                        break;
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                switch (keyPressed) {
                    case 1:
                        updateDelete();
                        choiceStartAgain();
                        keyPressed++;
                        break;
                    case 2:
                    updateDelete();
                    choiceMainMenu();
                        keyPressed = 1;
                    break;
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                switch (keyPressed) {
                    case (1):
                        deleteAll();
                        arena.deleteAll();
                        new MainMenu();
                        break;
                        //interromper tudo da arena e ir para main menu
                    case(2):
                        deleteAll();
                        arena.deleteAll();
                        new ChooseFighter();
                        //interromper tudo da arena e ir para champ select
                        break;
                }
                break;

        }
    }

    @Override
    public void actionReleased(int key) {

    }

    private void updateDelete(){
        startAgainRect.delete();
        mainMenuRect.delete();
        startAgainText.delete();
        mainMenuText.delete();

    }
    private void choiceMainMenu(){
        startAgainRect.setColor(Color.BLACK);
        startAgainText.setColor(Color.WHITE);
        mainMenuRect.setColor(Color.WHITE);
        mainMenuText.setColor(Color.BLACK);

        startAgainRect.fill();
        mainMenuRect.fill();
        startAgainText.draw();
        mainMenuText.draw();
    }

    private void choiceStartAgain(){
        startAgainRect.setColor(Color.WHITE);
        startAgainText.setColor(Color.BLACK);
        mainMenuRect.setColor(Color.BLACK);
        mainMenuText.setColor(Color.WHITE);
        startAgainRect.fill();
        mainMenuRect.fill();
        startAgainText.draw();
        mainMenuText.draw();

    }
    private void deleteAll(){
        startAgainRect.delete();
        mainMenuRect.delete();
        startAgainText.delete();
        mainMenuText.delete();
        pauseRect.delete();
        winnerText.delete();
        winnerRect.delete();
    }
}
