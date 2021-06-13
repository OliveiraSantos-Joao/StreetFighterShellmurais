package streetFighter.arena;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import streetFighter.Game;
import streetFighter.GameOverScreen;
import streetFighter.HealthBar;
import streetFighter.fighters.Fighter;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;
import streetFighter.Sound;

import java.util.Timer;
import java.util.TimerTask;


public class Arena implements ToDo {

    private Picture arenaPic;

    private Fighter player1;
    private Fighter player2;

    private Picture picPlayer1;
    private Picture picPlayer2;

    private Picture picPlayer1Punch;
    private Picture picPlayer2Punch;

    private HealthBar hb;
    private String arenaName;

    private int jumpDistance;

    private boolean initialFacingPositions = true;
    private boolean fightOver = false;

    private boolean player1Jump = true;
    private boolean player2Jump = true;

    private boolean player1Kickback = false;
    private boolean player2Kickback = false;

    private boolean player1CanAct = true;
    private boolean player2CanAct = true;

    private boolean player1Loop = true;
    private boolean player2Loop = true;

    private boolean isGroundedP1 = false;
    private boolean isGroundedP2 = false;

    private int player2MoveCooldown = 1;
    private int player1MoveCooldown = 1;

    //private int player1PunchCooldown = 1;
    //private int player2PunchCooldown = 1;

    private Sound punch1 = new Sound("/Resources/Sounding/Movement and Fight/punch1.wav");

    private Timer timer = new Timer();
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            /*if (player1PunchCooldown > 0) {
                player1PunchCooldown--;
            }
            if (player2PunchCooldown > 0) {
                player2PunchCooldown--;
            }*/
            if (player1MoveCooldown > 0) {
                player1MoveCooldown--;
            }
            if (player2MoveCooldown > 0) {
                player2MoveCooldown--;
            }
        }
    };


    private int teste = 0;
    private final int FIGHTER_REACH = 20;


    //constructor
    public Arena(Fighter player1, Fighter player2, String arenaName) {

        this.arenaName = arenaName;
        Inputs.setInputScreen(this);
        this.player1 = player1;
        this.player2 = player2;
        this.jumpDistance = 15;

        timer.schedule(task, 50, 50);
        init();
    }

    public void init() {
        drawArena();
        player1ThreadJump.start();
        player2ThreadJump.start();
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

    ////////////////Keys action PRESSED
    @Override
    public void actionPressed(int key) {
        switch (key) {
            case KeyboardEvent.KEY_W:
                if (isGroundedP1) {
                    player1Jump = true;
                }
                break;

            //case KeyboardEvent.KEY_P:
            //   break;

            case KeyboardEvent.KEY_A:


                if (inBoundsLeft(player1) && player1CanAct && player1Loop && player1MoveCooldown == 0) {
                    picPlayer1.translate(-player1.getPixelMovement(), 0);
                    picPlayer1Punch.translate(-player1.getPixelMovement(), 0);
                    player1.moveLeft();
                    player1MoveCooldown = 1;

                }
                break;

            case KeyboardEvent.KEY_D:
                if (inBoundsRight(player1) && player1CanAct && player1Loop && player1MoveCooldown == 0) {
                    if (facingInitialPosition()) {
                        picPlayer1.translate(player1.getPixelMovement(), 0);
                        picPlayer1Punch.translate(player1.getPixelMovement(), 0);
                        player1.moveRight();
                        player1MoveCooldown = 1;
                    }
                }
                break;

            case KeyboardEvent.KEY_UP:
                if (isGroundedP2) {
                    player2Jump = true;
                    //player2JumpCooldown = 1;
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                if (inBoundsLeft(player2) && player2CanAct && player2Loop && player2MoveCooldown == 0) {
                    if (facingInitialPosition()) {
                        picPlayer2.translate(-player2.getPixelMovement(), 0);
                        picPlayer2Punch.translate(-player2.getPixelMovement(), 0);
                        player2.moveLeft();

                        player2MoveCooldown = 1;
                    }

                }
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (inBoundsRight(player2) && player2CanAct && player2Loop && player2MoveCooldown == 0) {
                    picPlayer2.translate(player2.getPixelMovement(), 0);
                    picPlayer2Punch.translate(player2.getPixelMovement(), 0);
                    player2.moveRight();
                    player2MoveCooldown = 1;
                }
                break;

            case KeyboardEvent.KEY_1:

                if (player1CanAct && player1Loop) {
                    picPlayer1Punch.draw();
                    picPlayer1.delete();
                    // player1PunchCooldown = 1;
                }
                break;

            case KeyboardEvent.KEY_SPACE:

                if (player2CanAct && player2Loop) {
                    picPlayer2Punch.draw();
                    picPlayer2.delete();
                    //player2PunchCooldown = 1;

                }
                break;
        }
    }

    ///////////// action RELEASED
    @Override
    public void actionReleased(int key) {
        switch (key) {
            case KeyboardEvent.KEY_1:
                if (player1CanAct && player1Loop) {
                    picPlayer1.draw();
                    picPlayer1Punch.delete();
                    hitInTheFace(player1, player2);
                }
                break;

            case KeyboardEvent.KEY_SPACE:

                if (player2CanAct && player2Loop) {
                    picPlayer2.draw();
                    picPlayer2Punch.delete();
                    hitInTheFace(player2, player1);
                }
                break;
        }
    }

///////////////////// Metodos
    public void deleteAll(){
        arenaPic.delete();
        picPlayer1.delete();
        picPlayer2.delete();
        picPlayer1Punch.delete();
        picPlayer2Punch.delete();
        hb.healthBarDelete();
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
                    punch1.play(true);
                    whoKicksback();
                }
            } else {
                if (Math.abs(playerPuncherReceiver.getPosX() + playerPuncherReceiver.getWidth() - playerPuncher.getPosX()) < FIGHTER_REACH) {
                    playerPuncherReceiver.hit(playerPuncher.getDamage());
                    punch1.play(true);
                    whoKicksback();
                }
            }
        } else {
            if (initialFacingPositions) {
                if (Math.abs(playerPuncherReceiver.getPosX() + playerPuncherReceiver.getWidth() - playerPuncher.getPosX()) < FIGHTER_REACH) {
                    playerPuncherReceiver.hit(playerPuncher.getDamage());
                    punch1.play(true);
                    whoKicksback();
                }
            } else {
                if (Math.abs(playerPuncher.getPosX() + playerPuncher.getWidth() - playerPuncherReceiver.getPosX()) < FIGHTER_REACH) {
                    playerPuncherReceiver.hit(playerPuncher.getDamage());
                    punch1.play(true);
                    whoKicksback();
                }
            }
        }

        hb.healthBarDelete();
        hb = new HealthBar(player1, player2);
        checkIfDead();
    }

    private void checkIfDead() {

        if (player1.checkIfDead()) {
            fightOver = true;
            System.out.println("player 2 won");

            player1Loop = false;
            player2Loop = false;
            new GameOverScreen(2,this);
        }

        if (player2.checkIfDead()) {
            fightOver = true;
            System.out.println("Player 1 won");

            player1Loop = false;
            player2Loop = false;
            new GameOverScreen(1,this);
        }

    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
//Threads
    private boolean facingInitialPosition() {
        if (player1.getPosX() + player1.getWidth() + 10 < player2.getPosX()) {
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
        }

        void callKickback() {

            for (int i = 0; i < 5; i++) {

                player1Kickback();


                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            player1Kickback = false;

        }

        void callGravity() {
            player1Gravity();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            while (player1Loop) {

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (player1Jump) {
                    jump();
                    player1Jump = false;
                }

                if (player1Kickback) {
                    callKickback();
                    player1CanAct = true;
                }

                callGravity();
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
        }

        void callKickback() {
            for (int i = 0; i < 5; i++) {
                player2Kickback();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            player2Kickback = false;
        }

        void callGravity() {
            player2Gravity();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (player2Loop) {

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                if (player2Jump) {
                    jump();
                    player2Jump = false;
                }

                if (player2Kickback) {
                    callKickback();
                    player2CanAct = true;
                }
                callGravity();
            }
        }
    });

    public void goUp1() {
        player1CanAct = false;
        picPlayer1.translate(0, -jumpDistance);
        picPlayer1Punch.translate(0, -jumpDistance);
        player1CanAct = true;
    }

    public void player1Gravity() {
        player1CanAct = false;
        if (picPlayer1.getY() + picPlayer1.getHeight() <= arenaPic.getHeight() - 50) {
            isGroundedP1 = false;
            picPlayer1.translate(0, jumpDistance);
            picPlayer1Punch.translate(0, jumpDistance);
            player1CanAct = true;
            return;
        }
        player1CanAct = true;
        isGroundedP1 = true;
    }

    public void player1Kickback() {
        player1CanAct = false;
        picPlayer1.translate(-player1.getPixelMovement(), 0);
        picPlayer1Punch.translate(-player1.getPixelMovement(), 0);
        player1.moveLeft();
    }

    public void goUp2() {
        player2CanAct = false;
        picPlayer2.translate(0, -jumpDistance);
        picPlayer2Punch.translate(0, -jumpDistance);
        player2CanAct = true;
    }

    public void player2Gravity() {
        player2CanAct = false;
        if (picPlayer2.getY() + picPlayer2.getHeight() <= arenaPic.getHeight() - 50) {
            isGroundedP2 = false;
            picPlayer2.translate(0, jumpDistance);
            picPlayer2Punch.translate(0, jumpDistance);
            player2CanAct = true;
            return;
        }
        player2CanAct = true;
        isGroundedP2 = true;
    }

    public void player2Kickback() {
        player2CanAct = false;
        picPlayer2.translate(player2.getPixelMovement(), 0);
        picPlayer2Punch.translate(player2.getPixelMovement(), 0);
        player2.moveRight();
    }

    public void whoKicksback () {
        if(player1.getPosX() + player1.getWidth() >= arenaPic.getWidth() / 2)
        {
            player1Kickback = true;
            return;
        }

        if(player2.getPosX() <= arenaPic.getWidth() / 2)
        {
            player2Kickback = true;
            return;
        }

    }





}
