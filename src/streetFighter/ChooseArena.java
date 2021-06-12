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


public class ChooseArena implements ToDo {


    private Picture arena1;
    private Picture arena2;
    private Picture arena3;
    private Picture arena4;

    private Picture mainMenu;

    Rectangle rect1;
    Rectangle rect2;
    Rectangle rect3;
    Rectangle rect4;

    private int maxArena = 4;

    private int pressedArena = 1;

    private boolean fightersReady = false;

    private Arena arena;

    private Fighter player1;
    private Fighter player2;

    private Rectangle[] photoFrame = new Rectangle[maxArena];


    public ChooseArena(Fighter player1, Fighter player2) {

        Inputs.setInputScreen(this);
        this.player1 = player1;
        this.player2 = player2;

        createArena();


    }


    public Rectangle[] getPhotoFrame() {
        return photoFrame;
    }

    public void createArena() {

        mainMenu = new Picture(Game.PADDING, Game.PADDING, "BlackBackground2.png");
        mainMenu.draw();

        arena1 = new Picture(mainMenu.getWidth() / 2, mainMenu.getHeight() * 0.6, "Resources/arena1Resized.png");
        arena1.draw();

        arena2 = new Picture(arena1.getX() - arena1.getWidth() - 20, arena1.getY(), "Resources/arena2Resized.png");
        arena2.draw();

        arena3 = new Picture(arena2.getX() - arena2.getWidth() - 20, arena2.getY(), "Resources/arena3Resized.png");
        arena3.draw();

        arena4 = new Picture((arena3.getX()) - arena3.getWidth() - 20, arena1.getY(), "Resources/elephantes_1280x720Resized.jpeg");
        arena4.draw();

        rect1 = new Rectangle(arena1.getX(), arena1.getY(), arena1.getWidth(), arena1.getHeight());
        rect1.setColor(Color.WHITE);
        rect1.draw();
        photoFrame[3] = rect1;

        rect2 = new Rectangle(arena2.getX(), arena2.getY(), arena2.getWidth(), arena2.getHeight());
        photoFrame[2] = rect2;

        rect3 = new Rectangle(arena3.getX(), arena3.getY(), arena3.getWidth(), arena3.getHeight());
        photoFrame[1] = rect3;

        rect4 = new Rectangle(arena4.getX(), arena4.getY(), arena4.getWidth(), arena4.getHeight());
        photoFrame[0] = rect4;

    }

    public int getMaxChampions() {
        return maxArena;
    }

    public void deleteAll() {
        arena1.delete();
        arena2.delete();
        arena3.delete();
        arena4.delete();
        mainMenu.delete();

        rect1.delete();
        rect2.delete();
        rect3.delete();
        rect4.delete();
        for (int i = 0; i < getPhotoFrame().length; i++) {
            getPhotoFrame()[i].delete();

        }
    }


    @Override
    public void actionPressed(int key) {
        update();
        switch (key) {
            case KeyboardEvent.KEY_RIGHT:
                switch (pressedArena) {
                    case 4:
                        //getPhotoFrame()[pressedArena].delete();
                        pressedArena = 1;
                        //getPhotoFrame()[pressedArena].draw();
                        break;
                    default:
                        //getPhotoFrame()[pressedArena].delete();
                        pressedArena++;
                        // getPhotoFrame()[pressedArena].draw();
                        break;
                }
                break;

            case KeyboardEvent.KEY_LEFT:

                switch (pressedArena) {
                    case 1:
                        //getPhotoFrame()[pressedArena].delete();
                        pressedArena = getMaxChampions();//para voltar ao ultimo
                        //getPhotoFrame()[pressedArena].draw();
                        break;
                    default:
                        //getPhotoFrame()[pressedArena].delete();
                        pressedArena--;
                        //getPhotoFrame()[pressedArena].draw();
                        break;
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                switch (pressedArena) {
                    case 1:
                        deleteAll();
                        new Arena(player1, player2, "Resources/arena1.png");
                        break;

                    case 2:
                        deleteAll();
                        new Arena(player1, player2, "Resources/arena2.png");
                        break;

                    case 3:
                        deleteAll();
                        new Arena(player1, player2, "Resources/arena3.png");
                        break;

                    case 4:
                        deleteAll();
                        new Arena(player1, player2, "Resources/elephantes_1280x720.jpeg");
                        break;
                }

        }

    }

    @Override
    public void actionReleased(int key) {
    }

    private void update() {

        for (int i = 0; i < getPhotoFrame().length; i++) {

          //  System.out.println(getPhotoFrame()[i]);

            if (pressedArena == i +1) {
                getPhotoFrame()[i].setColor(Color.WHITE);
                getPhotoFrame()[i].draw();
                continue;
            }
            getPhotoFrame()[i].delete();
        }
    }
}

