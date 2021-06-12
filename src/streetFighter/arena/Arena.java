package streetFighter.arena;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import streetFighter.Game;
import streetFighter.GameMech;
import streetFighter.HealthBar;
import streetFighter.fighters.Fighter;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;

import java.util.Timer;
import java.util.TimerTask;


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

    private int jumpDistance;
    private String arenaName;

    private boolean player1Jump = true;
    private boolean player2Jump = true;

    private boolean player1CanPunch = true;
    private boolean player2CanPunch = true;

    private boolean player1Loop = true;
    private boolean player2Loop = true;

    private int player1PunchCooldown = 1;
    private int player2PunchCooldown = 1;

    private int secondsPassed = 0;
    private Timer timer = new Timer();
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsPassed++;
            if (player1PunchCooldown > 0) { player1PunchCooldown--; }
            if (player2PunchCooldown > 0) { player2PunchCooldown--; }
        }
    };


    private int teste = 0;
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

        this.jumpDistance = 15;

        timer.schedule(task, 1000, 1000);
        init();

        player1ThreadJump.start();
        player2ThreadJump.start();

    }

    public void init() {
        drawArena();
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

        picPlayer1 = new Picture(player1.getPosX(), player1.getPosY(), player1.getFighter().getPhotoName(player1.getFighter()) + "_" + "stand" + "_" + "right.png");
        picPlayer2 = new Picture(player2.getPosX(), player2.getPosY(), player2.getFighter().getPhotoName(player2.getFighter()) + "_" + "stand" + "_" + "left.png");

        picPlayer1Punch = new Picture(player1.getPosX(), player1.getPosY(), player1.getFighter().getPhotoName(player1.getFighter()) + "_" + "punch" + "_" + "right.png");
        picPlayer2Punch = new Picture(player2.getPosX(), player2.getPosY(), player2.getFighter().getPhotoName(player2.getFighter()) + "_" + "punch" + "_" + "left.png");
        //Resources/Fighters/


        picPlayer1.draw();
        picPlayer2.draw();

    }


    @Override
    public void actionPressed(int key) {
        switch (key) {
            case KeyboardEvent.KEY_W:
                player1Jump = true;
                break;

            case KeyboardEvent.KEY_P:
                break;

            case KeyboardEvent.KEY_A:

                if (inBoundsLeft(player1)) {
                    if (facingInitialPosition()) {
                        picPlayer1.translate(-player1.getPixelMovement(), 0);
                        picPlayer1Punch.translate(-player1.getPixelMovement(), 0);
                        player1.moveLeft();
                    }
                }
                break;

            case KeyboardEvent.KEY_D:
                if (inBoundsRight(player1)) {
                    if (facingInitialPosition()) {

                        picPlayer1.translate(player1.getPixelMovement(), 0);
                        picPlayer1Punch.translate(player1.getPixelMovement(), 0);
                        player1.moveRight();

                    }
                }
                break;

            case KeyboardEvent.KEY_UP:
                player2Jump = true;
                break;

            case KeyboardEvent.KEY_LEFT:
                if (inBoundsLeft(player2)) {
                    if (facingInitialPosition()) {

                        picPlayer2.translate(-player2.getPixelMovement(), 0);
                        picPlayer2Punch.translate(-player2.getPixelMovement(), 0);
                        player2.moveLeft();
                    }
                }
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (inBoundsRight(player2)) {
                    if (facingInitialPosition()) {
                        picPlayer2.translate(player2.getPixelMovement(), 0);
                        picPlayer2Punch.translate(player2.getPixelMovement(), 0);
                        player2.moveRight();
                    }
                }
                break;

            case KeyboardEvent.KEY_1:
                if (player1CanPunch && player1PunchCooldown == 0) {
                    picPlayer1Punch.draw();
                    picPlayer1.delete();
                    player1PunchCooldown = 1;
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                if (player2CanPunch && player2PunchCooldown == 0 ) {
                    picPlayer2Punch.draw();
                    picPlayer2.delete();
                    player2PunchCooldown = 1;
                }
                break;
        }
    }

    @Override
    public void actionReleased(int key) {
        switch (key) {
            case KeyboardEvent.KEY_1:
                if (player1CanPunch) {
                    picPlayer1.draw();
                    picPlayer1Punch.delete();
                    hitInTheFace(player1, player2);
                }
                break;

            case KeyboardEvent.KEY_SPACE:

                if (player2CanPunch) {
                    picPlayer2.draw();
                    picPlayer2Punch.delete();
                    hitInTheFace(player2, player1);
                }
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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
//Threads
    private boolean facingInitialPosition() {
        if (player1.getPosX() + player1.getWidth() - 10 < player2.getPosX()) {
            return true;
        }
        return false;
    }

    Thread player1ThreadJump = new Thread(new Runnable() {

        void jump() {

            for (int i = 0; i < 20; i++) {

                goUp1();

                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < 20; i++) {

                goDown1();

                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        @Override
        public void run() {

            while (player1Loop) {

                System.out.println("is pissas");

                if (player1Jump) {
                    jump();
                    player1Jump = false;
                }

            }

        }

    });

    Thread player2ThreadJump = new Thread(new Runnable() {

        void jump() {

            for (int i = 0; i < 20; i++) {

                goUp2();

                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < 20; i++) {

                goDown2();

                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        @Override
        public void run() {


            while (player2Loop) {

                System.out.println("is pissas");

                if (player2Jump) {

                    jump();
                    player2Jump = false;

                }

            }

        }


    });


    public void goUp1() {
        player1CanPunch = false;
        picPlayer1.translate(0, -jumpDistance);
        picPlayer1Punch.translate(0, -jumpDistance);
        player1CanPunch = true;
    }

    public void goDown1() {
        player1CanPunch = false;
        picPlayer1.translate(0, jumpDistance);
        picPlayer1Punch.translate(0, jumpDistance);
        player1CanPunch = true;
    }

    public void goUp2() {
        player2CanPunch = false;
        picPlayer2.translate(0, -jumpDistance);
        picPlayer2Punch.translate(0, -jumpDistance);
        player2CanPunch = true;
    }

    public void goDown2() {
        player2CanPunch = false;
        picPlayer2.translate(0, jumpDistance);
        picPlayer2Punch.translate(0, jumpDistance);
        player2CanPunch = true;
    }

}

//    private void initialFacedPositions() {
//
//
  /*      if (player1.getPosX() + player1.getWidth() < player2.getPosX()) {
            initialFacingPositions = true;
//            System.out.println(player1.getPosX() + player1.getWidth() - player2.getPosX());
//            System.out.println(player1.getPosX());
//            System.out.println(player1.getWidth());
//            System.out.println(player2.getPosX());
//            System.out.println("teste1");
//            return;
            return;
        }

            initialFacingPositions = false;*/





