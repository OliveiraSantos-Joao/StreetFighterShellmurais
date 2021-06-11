package streetFighter.arena;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import streetFighter.Game;
import streetFighter.GameMech;
import streetFighter.HealthBar;
import streetFighter.fighters.Fighter;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;

public class Arena implements ToDo {

    private Picture arenaGraf;

    private Rectangle player1Rec;
    private Rectangle player2Rec;

    private Fighter player1;
    private Fighter player2;

    private HealthBar hb;

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
        System.out.println("entrou");

        drawPLayers();

        gMech.init();

    }


    public void drawArena() {

        arenaGraf = new Picture(Game.PADDING, Game.PADDING, "arena2.png");
        arenaGraf.draw();

        hb = new HealthBar(player1.getHealth(), player2.getHealth());

    }

    public void drawPLayers(){

        hb = new HealthBar(player1.getHealth(), player2.getHealth());

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



