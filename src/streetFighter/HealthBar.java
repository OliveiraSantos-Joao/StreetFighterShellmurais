package streetFighter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class HealthBar {

    private Text player1Name;
    private Text player2Name;
    private Text text;

    Rectangle rectangleP1;
    Rectangle lifeP1;

    Rectangle rectangleP2;
    Rectangle lifeP2;

    private Picture mainMenu;
    private int healthP1 = 50;
    private int healthP2 = 90;
    private int barWidth = 500;
    private int barHeight = 40;


    public HealthBar() {
        init();
    }

    public void init() {

        mainMenu = new Picture(Game.PADDING, Game.PADDING, "BlackBackground2.png");
        mainMenu.draw();

        rectangleP1 = new Rectangle(mainMenu.getX()+ 70, mainMenu.getY() +50, barWidth, barHeight);
        rectangleP1.setColor(Color.WHITE);
        rectangleP1.draw();

        player1Name = new Text(rectangleP1.getX(), rectangleP1.getY() - 20,"Player 1");
        player1Name.setColor(Color.WHITE);
        player1Name.draw();

        rectangleP2 = new Rectangle(mainMenu.getWidth() - 70 - barWidth, mainMenu.getY() +50, barWidth, barHeight);
        rectangleP2.setColor(Color.WHITE);
        rectangleP2.draw();

        player2Name = new Text(rectangleP2.getX()+rectangleP2.getWidth()-50, rectangleP2.getY() - 20,"Player 2");
        player2Name.setColor(Color.WHITE);
        player2Name.draw();

        lifeP1 = new Rectangle(rectangleP1.getX()+5, rectangleP1.getY() + 5, (rectangleP1.getWidth()-10) * healthP1 /100, rectangleP1.getHeight()- 10 );

        lifeP2 = new Rectangle(rectangleP2.getX() + (rectangleP2.getWidth() - healthP2*5) +5 , rectangleP2.getY() + 5, (rectangleP2.getWidth()-10) * healthP2 /100, rectangleP2.getHeight()- 10 );

        if(healthP1 < 33) {
            lifeP1.setColor(Color.RED);
        }
        else if (healthP1 < 60) {
            lifeP1.setColor(Color.YELLOW);
        }
        else if( healthP1 < 101) {
            lifeP1.setColor(Color.GREEN);
        }

        lifeP1.fill();

        if(healthP2 < 33) {
            lifeP2.setColor(Color.RED);
        }
        else if (healthP2 < 60) {
            lifeP2.setColor(Color.YELLOW);
        }
        else if( healthP2 < 101) {
            lifeP2.setColor(Color.GREEN);
        }

        lifeP2.fill();

    }
}
