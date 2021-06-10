package streetFighter.arena;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import streetFighter.Game;
import streetFighter.GameMech;
import streetFighter.HealthBar;
import streetFighter.MainMenu;
import streetFighter.fighters.Fighter;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;

public class Arena implements ToDo {

    private Picture arena;
    private Rectangle player1Rec;
    private Rectangle player2Rec;
    private Fighter player1;
    private Fighter player2;
    private GameMech gMech;


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

        //Método temporário

        arena = new Picture(Game.PADDING, Game.PADDING, "arena2.png");
        arena.draw();

        player1Rec = new Rectangle(player1.getPosX(), player1.getPosY(), player1.getWidth(), player1.getHeight());
        player1Rec.setColor(Color.GREEN);
        player1Rec.fill();

        player2Rec = new Rectangle(player2.getPosX(), player2.getPosY(), player2.getWidth(), player2.getHeight());
        player2Rec.setColor(Color.CYAN);
        player2Rec.fill();

        HealthBar hb = new HealthBar(player1.getHealth(), player2.getHealth());

        Punch punch = new Punch(player2);
        Punch punch2 = new Punch(player1);

    }


    @Override
    public void action(int key) {
        switch (key) {
            case KeyboardEvent.KEY_P:
                if (gMech.isFlag())
                {
                    gMech.setFlagFalse();
                } else {
                    gMech.setFlagTrue();
                    gMech.init();
                }

                break;
        }
    }
}



