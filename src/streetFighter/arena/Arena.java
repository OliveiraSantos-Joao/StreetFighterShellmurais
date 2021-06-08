package streetFighter.arena;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import streetFighter.Game;
import streetFighter.HealthBar;
import streetFighter.fighters.Fighter;

public class Arena {

    Picture arena;
    Rectangle player1Rec;
    Rectangle player2Rec;
    Fighter player1;
    Fighter player2;


    public Arena(Fighter player1, Fighter player2){
        this.player1 = player1;
        this.player2 = player2;


        arena = new Picture(Game.PADDING,Game.PADDING,"arena2.png");
        arena.draw();

        player1Rec = new Rectangle(player1.getPosX() , player1.getPosY(),100,250);
        player1Rec.setColor(Color.GREEN);
        player1Rec.fill();

        player2Rec = new Rectangle(player2.getPosX() , player2.getPosY(),100,250);
        player2Rec.setColor(Color.CYAN);
        player2Rec.fill();

        HealthBar hb = new HealthBar(player1.getHealth(),player2.getHealth());




    }

    public void arenaInit(){


    }



}
