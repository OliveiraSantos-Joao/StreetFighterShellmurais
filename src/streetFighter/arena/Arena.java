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


    private Fighter player1;
    private Fighter player2;

    private boolean initialFacingPositions = true;


    private HealthBar hb;

    private GameMech gMech;

    private Picture picPlayer1;
    private Picture picPlayer2;
    private Picture picPlayer1Punch;
    private Picture picPlayer2Punch;

    private String arenaName;

    private final int FIGHTER_REACH = 20;

    // Getters e Setters
    public Picture getPicPlayer1() {
        return picPlayer1;
    }

    public Picture getPicPlayer2() {
        return picPlayer2;
    }


    //constructor
    public Arena(Fighter player1, Fighter player2, String arenaName) {

        this.arenaName = arenaName;

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
        arenaPic = new Picture(Game.PADDING, Game.PADDING, arenaName);
        arenaPic.draw();
        hb = new HealthBar(player1, player2);
        drawPlayers();
    }

    public void drawPlayers() {

        player1.setPosX(70);
        player1.setPosY(arenaPic.getHeight() - 200);
        player2.setPosX(arenaPic.getX() + arenaPic.getWidth() - 191);
        player2.setPosY(arenaPic.getHeight() - 200);

        picPlayer1 = new Picture(player1.getPosX(), player1.getPosY(),     player1.getFighter().getPhotoName(player1.getFighter()) +"_" + "stand"+"_"+ "right.png");
        picPlayer2 = new Picture(player2.getPosX(), player2.getPosY(), player2.getFighter().getPhotoName(player2.getFighter()) + "_" +"stand" + "_" + "left.png");

        picPlayer1Punch = new Picture(player1.getPosX(), player1.getPosY(),player1.getFighter().getPhotoName(player1.getFighter()) +"_" + "punch"+"_"+ "right.png");
        picPlayer2Punch = new Picture(player2.getPosX(), player2.getPosY(), player2.getFighter().getPhotoName(player2.getFighter()) + "_" +"punch" + "_" + "left.png");
        //Resources/Fighters/
        picPlayer1.draw();
        picPlayer2.draw();
    }


    @Override
    public void actionPressed(int key) {
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
                if (inBoundsLeft(player1) && initialFacingPositions) {
                    picPlayer1.translate(-player1.getPixelMovement(), 0);
                    picPlayer1Punch.translate(-player1.getPixelMovement(), 0);
                    player1.moveLeft();
                    break;

                }
                initialFacedPositions();
                break;

            case KeyboardEvent.KEY_D:
                if (inBoundsRight(player1) && !initialFacingPositions) {
                    picPlayer1.translate(player1.getPixelMovement(), 0);
                    picPlayer1Punch.translate(player1.getPixelMovement(), 0);
                    player1.moveRight();
                }
                initialFacedPositions();
                break;

            case KeyboardEvent.KEY_LEFT:
                if (inBoundsLeft(player2) && !initialFacingPositions) {
                    picPlayer2.translate(-player2.getPixelMovement(), 0);
                    picPlayer2Punch.translate(-player2.getPixelMovement(), 0);
                    player2.moveLeft();
                }
                initialFacedPositions();
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (inBoundsRight(player2) && initialFacingPositions) {
                    picPlayer2.translate(player2.getPixelMovement(), 0);
                    picPlayer2Punch.translate(player2.getPixelMovement(), 0);
                    player2.moveRight();
                }
                initialFacedPositions();
                break;

            case KeyboardEvent.KEY_1:
                picPlayer1Punch.draw();
                picPlayer1.delete();
                break;

            case KeyboardEvent.KEY_SPACE:
                picPlayer2Punch.draw();
                picPlayer2.delete();
                break;
        }
    }

    @Override
    public void actionReleased(int key) {
        switch (key) {
            case KeyboardEvent.KEY_1:
                picPlayer1.draw();
                picPlayer1Punch.delete();
                hitInTheFace(player1, player2);

                break;

            case KeyboardEvent.KEY_SPACE:
                picPlayer2.draw();
                picPlayer2Punch.delete();
                hitInTheFace(player2, player1);

                break;
        }
    }

    private boolean inBoundsRight(Fighter player) {
        if ((player.getPosX() + player.getWidth() > arenaPic.getX() + arenaPic.getWidth() - (Game.BORDER + player.getWidth()))) {
            return false;
        }
        return true;
    }

    private boolean inBoundsLeft(Fighter player) {
        if (player.getPosX() < arenaPic.getX() + Game.BORDER * 2) {
            return false;
        }
        return true;
    }

    private void hitInTheFace(Fighter playerPuncher, Fighter playerPuncherReceiver) {
        if (playerPuncher == player1) {
            if (initialFacingPositions) {
                if (Math.abs(playerPuncher.getPosX() + playerPuncher.getWidth() - playerPuncherReceiver.getPosX()) < FIGHTER_REACH) {
                    playerPuncherReceiver.hit(playerPuncher.getDamage());
                }

            } else {
                if (Math.abs(playerPuncherReceiver.getPosX() + playerPuncherReceiver.getWidth() - playerPuncher.getPosX()) < FIGHTER_REACH) {
                    playerPuncherReceiver.hit(playerPuncher.getDamage());
                }
            }

        } else {
            if (initialFacingPositions) {
                if (Math.abs(playerPuncherReceiver.getPosX() + playerPuncherReceiver.getWidth() - playerPuncher.getPosX()) < FIGHTER_REACH) {
                    playerPuncherReceiver.hit(playerPuncher.getDamage());
                }
            } else {
                if (Math.abs(playerPuncher.getPosX() + playerPuncher.getWidth() - playerPuncherReceiver.getPosX()) < FIGHTER_REACH) {
                    playerPuncherReceiver.hit(playerPuncher.getDamage());
                }
            }
        }


        hb.healthBarDelete();
        hb = new HealthBar(player1, player2);
    }


    private void initialFacedPositions() {
        if (player1.getPosX() + player1.getWidth() - player2.getPosX() > 0) {
            initialFacingPositions = true;
            return;
        }
        initialFacingPositions = false;
    }


}



