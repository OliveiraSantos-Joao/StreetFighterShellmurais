package streetFighter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import streetFighter.arena.Arena;
import streetFighter.fighters.Fighter;
import streetFighter.fighters.Fighters;
import streetFighter.fighters.PlayerType;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;


public class ChooseFighter implements ToDo {


    private Picture saraPic;
    private Picture pauloPic;
    private Picture pedroPic;
    private Picture fighter1Pic;

    private Picture mainMenu;

    Rectangle rect1;
    Rectangle rect2;
    Rectangle rect3;
    Rectangle rect4;

    private int maxchampions = 4;

    private int pressedCharacterP1 = 1;
    private int pressedCharacterP2 = maxchampions;

    private boolean p1Ready = false;
    private boolean p2Ready = false;
    private Fighter fighterP1ready;
    private Fighter fighterP2ready;

    private Arena arena;

    private Rectangle[] photoFrame = new Rectangle[maxchampions];


    public ChooseFighter() {
        Inputs.setInputScreen(this);
        createFighters();


    }


    public Rectangle[] getPhotoFrame() {
        return photoFrame;
    }

    public void createFighters() {

        mainMenu = new Picture(Game.PADDING, Game.PADDING, "BlackBackground2.png");
        mainMenu.draw();

        saraPic = new Picture(mainMenu.getWidth() / 2, mainMenu.getHeight() * 0.6, "sara.png");
        saraPic.draw();

        pauloPic = new Picture(saraPic.getX() - saraPic.getWidth() - 20, saraPic.getY(), "paulo2_72x72.jpeg");
        pauloPic.draw();

        pedroPic = new Picture(pauloPic.getX() - pauloPic.getWidth() - 20, pauloPic.getY(), "paulo2_72x72.jpeg");
        pedroPic.draw();

        fighter1Pic = new Picture((pedroPic.getX()) - pedroPic.getWidth() - 20, pauloPic.getY(), "sara.png");
        fighter1Pic.draw();

        rect1 = new Rectangle(saraPic.getX(), saraPic.getY(), saraPic.getWidth(), pauloPic.getHeight());
        rect1.setColor(Color.BLUE);
        rect1.draw();
        photoFrame[3] = rect1;

        rect2 = new Rectangle(pauloPic.getX(), pauloPic.getY(), pauloPic.getWidth(), pauloPic.getHeight());
        photoFrame[2] = rect2;

        rect3 = new Rectangle(pedroPic.getX(), pedroPic.getY(), pedroPic.getWidth(), pedroPic.getHeight());
        photoFrame[1] = rect3;

        rect4 = new Rectangle(fighter1Pic.getX(), fighter1Pic.getY(), fighter1Pic.getWidth(), fighter1Pic.getHeight());
        rect4.setColor(Color.RED);
        rect4.draw();
        photoFrame[0] = rect4;

    }

    public int getMaxChampions() {
        return maxchampions;
    }

    public void deleteAll(){
        saraPic.delete();
        pauloPic.delete();
        pedroPic.delete();
        fighter1Pic.delete();
        mainMenu.delete();

        rect1.delete();
        rect2.delete();
        rect3.delete();
        rect4.delete();
    }


    @Override
    public void action(int key) {

        switch (key) {

            case KeyboardEvent.KEY_RIGHT:

                if (p2Ready == true) {
                    break;
                }

                switch (pressedCharacterP2) {
                    case 1:
                        pressedCharacterP2++;
                        break;

                    case 2:
                        pressedCharacterP2++;
                        break;

                    case 3:
                        pressedCharacterP2++;
                        break;

                    case 4:
                        pressedCharacterP2 = 1;
                        break;
                }
                break;

            case KeyboardEvent.KEY_LEFT:

                if (p2Ready == true) {
                    break;
                }

                switch (pressedCharacterP2) {

                    case 1:
                        pressedCharacterP2 = getMaxChampions();//para voltar ao ultimo
                        break;
                    case 2:
                        pressedCharacterP2--;
                        break;
                    case 3:
                        pressedCharacterP2--;
                        break;

                    case 4:
                        pressedCharacterP2--;
                        break;
                }
                break;

            case KeyboardEvent.KEY_D:

                if (p1Ready == true) {
                    break;
                }

                switch (pressedCharacterP1) {
                    case 1:
                        pressedCharacterP1++;
                        break;

                    case 2:
                        pressedCharacterP1++;
                        break;

                    case 3:
                        pressedCharacterP1++;
                        break;

                    case 4:
                        pressedCharacterP1 = 1; //pq da a volta !!
                        break;
                }
                break;

            case KeyboardEvent.KEY_A:

                if (p1Ready == true) {
                    break;
                }

                switch (pressedCharacterP1) {
                    case 1:
                        pressedCharacterP1 = getMaxChampions();
                        break;

                    case 2:
                        pressedCharacterP1--;
                        break;

                    case 3:
                        pressedCharacterP1--;
                        break;

                    case 4:
                        pressedCharacterP1--;
                        break;
                }
                break;

            case KeyboardEvent.KEY_1:

                if (p1Ready == true) {
                    break;
                }
                p1Ready = true;

                switch (pressedCharacterP1) {
                    case 1:
                        fighterP1ready = new Fighter(PlayerType.PLAYER1, Fighters.PAULO);
                        break;

                    case 2:
                        fighterP1ready = new Fighter(PlayerType.PLAYER1, Fighters.SARA);
                        break;

                    case 3:
                        fighterP1ready = new Fighter(PlayerType.PLAYER1, Fighters.PEDRO);
                        break;

                    case 4:
                        fighterP1ready = new Fighter(PlayerType.PLAYER1, Fighters.IGREJA);
                        break;
                }
                if (p1Ready && p2Ready) {
                    deleteAll();
                    arena = new Arena(fighterP1ready, fighterP2ready);
                }
                break;

            case KeyboardEvent.KEY_SPACE:

                if (p2Ready == true) {

                    break;
                }
                p2Ready = true;

                switch (pressedCharacterP2) {
                    case 1:
                        fighterP1ready = new Fighter(PlayerType.PLAYER2, Fighters.PAULO);
                        break;

                    case 2:
                        fighterP1ready = new Fighter(PlayerType.PLAYER2, Fighters.SARA);
                        break;

                    case 3:
                        fighterP1ready = new Fighter(PlayerType.PLAYER2, Fighters.PEDRO);
                        break;

                    case 4:
                        fighterP1ready = new Fighter(PlayerType.PLAYER2, Fighters.IGREJA);
                        break;
                }
                if (p1Ready && p2Ready) {
                    deleteAll();
                    arena = new Arena(fighterP1ready, fighterP2ready);
                }
                break;
        }
        update();
    }

    private void update() {

        for (int i = 0; i < getPhotoFrame().length; i++) {
            if (pressedCharacterP1 == i + 1 && pressedCharacterP2 == i + 1) {
                getPhotoFrame()[i].setColor(Color.WHITE);
                getPhotoFrame()[i].draw();
                continue;
            }

            if (pressedCharacterP1 == i + 1) {
                getPhotoFrame()[i].setColor(Color.RED);
                getPhotoFrame()[i].draw();
                continue;
            }

            if (pressedCharacterP2 == i + 1) {
                getPhotoFrame()[i].setColor(Color.BLUE);
                getPhotoFrame()[i].draw();
                continue;
            }

            getPhotoFrame()[i].delete();

        }

    }

}

