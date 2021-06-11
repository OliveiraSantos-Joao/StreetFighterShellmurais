package streetFighter.arena;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import streetFighter.Game;
import streetFighter.GameMech;
import streetFighter.HealthBar;
import streetFighter.fighters.Fighter;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;

public class Arena implements ToDo {
    private Picture arenaPic;

    private Rectangle player1Rec;
    private Rectangle player2Rec;

    private Fighter player1;
    private Fighter player2;

    private HealthBar hb;

    private GameMech gMech;

    private Picture picPlayer1;
    private Picture picPlayer2;
    private Picture picPlayer1Punch;
    private Picture picPlayer2Punch;



    // Getters e Setters


    public Picture getPicPlayer1() {
        return picPlayer1;
    }

    public Picture getPicPlayer2() {
        return picPlayer2;
    }

    public Arena(Fighter player1, Fighter player2) {

        Inputs.setInputScreen(this);

        gMech = new GameMech();




        this.player1 = player1;
        this.player2 = player2;

        this.gMech = gMech;

        init();

    }


    public void init() {
        drawArena();
        gMech.init();
    }


    public void drawArena() {
        arenaPic = new Picture(Game.PADDING, Game.PADDING, "elephantes_1280x720.jpeg");
        arenaPic.draw();
        hb = new HealthBar(player1, player2);
        drawPlayers();
    }

    public void drawPlayers (){
        player1.setPosX(70);
        player1.setPosY(arenaPic.getHeight()-200);
        player2.setPosX(arenaPic.getX() + arenaPic.getWidth() - 100 );
        player2.setPosY(arenaPic.getHeight()-200);

        picPlayer1 = new Picture(player1.getPosX(), player1.getPosY(), "RyuLeft.png");
        picPlayer2 = new Picture(player2.getPosX(), player2.getPosY(), "KenRight.png");

        picPlayer1Punch = new Picture(player1.getPosX(), player1.getPosY(), "RyuLeftPunch.png");
        picPlayer2Punch = new Picture(player2.getPosX(), player2.getPosY(), "KenRightPunch.png");

        picPlayer1.grow(10,10);
        picPlayer2.grow(4,4);
        picPlayer1.draw();
        picPlayer2.draw();
    }


    @Override
    public void action(int key) {
        switch (key) {
            case KeyboardEvent.KEY_P:
                if (gMech.isPaused()) {
                    gMech.setPausedFalse();
                } else {
                    gMech.setPausedTrue();
                    gMech.init();
                }
                break;
            case KeyboardEvent.KEY_A:
                picPlayer1.translate(-player1.getPixelMovement(), 0);
                picPlayer1Punch.translate(-player1.getPixelMovement(), 0);
                picPlayer1.draw();

                player1.moveLeft();
                break;
            case KeyboardEvent.KEY_D:
                picPlayer1.translate(player1.getPixelMovement(), 0);
                picPlayer1Punch.translate(player1.getPixelMovement(), 0);
                player1.moveRight();
                break;

            case KeyboardEvent.KEY_LEFT:
                picPlayer2.translate(-player2.getPixelMovement(),0);
                picPlayer2Punch.translate(-player2.getPixelMovement(),0);
                player2.moveLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                picPlayer2.translate(player2.getPixelMovement(),0);
                picPlayer2Punch.translate(player2.getPixelMovement(),0);
                player2.moveRight();
                break;

            case KeyboardEvent.KEY_1:
                picPlayer1.delete();
                picPlayer1Punch.draw();
                picPlayer1Punch.delete();

                break;

            case KeyboardEvent.KEY_SPACE:
                picPlayer2Punch.draw();
                picPlayer2.delete();

                break;
        }

    }



}



