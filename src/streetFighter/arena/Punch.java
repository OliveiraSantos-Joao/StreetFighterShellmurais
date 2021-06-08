package streetFighter.arena;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import streetFighter.fighters.Fighter;

public class Punch {

    private Fighter player;
    private Rectangle punch;
    private int armWidth = 100;
    private int armHeight = 50;


    public Punch(Fighter player) {

        this.player=player;
        switch (player.getPlayerType()){
            case PLAYER1:
                punch = new Rectangle(player.getPosX()+ player.getWidth(), player.getPosY() + player.getHeight()/4 ,armWidth,armHeight);
            break;
            case PLAYER2:
                punch = new Rectangle(player.getPosX() - armWidth, player.getPosY() + player.getHeight()/4,armWidth,armHeight);

                break;
        }
        punch.setColor(Color.BLUE);
        punch.fill();


    }
}
