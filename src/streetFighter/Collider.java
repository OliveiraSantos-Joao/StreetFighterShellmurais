package streetFighter;

import streetFighter.arena.Arena;
import streetFighter.fighters.Fighter;

public class Collider {

    private Fighter player1;
    private Fighter player2;
    private Arena arena;

    public Collider(Fighter player1, Fighter player2, Arena arena) {

        this.player1 = player1;
        this.player2 = player2;
        this.arena = arena;

    }

    public boolean checkCollision() {

        int p1MaxX = player1.getPosX() + player1.getWidth();
        int p1MinX = player1.getPosX();
        int p1MinY = player1.getPosY();
        int p1MaxY = player1.getPosY() + player1.getHeight();
        int p1Corner = p1MaxX + player1.getHeight();

        int p2MaxX = player2.getPosX() + player2.getWidth();
        int p2MinX = player2.getPosX();
        int p2MinY = player2.getPosY();
        int p2MaxY = player2.getPosY() + player2.getHeight();
        int p2Corner = p2MaxX + player2.getHeight();

        if (arena.getFacingInitialPosition()) {
            if (p1MaxX >= p2MinX - 10 && p1MinY < p2MaxY && p2MinY < p1MaxY) {
                return true;
            }
        }

        if (!arena.getFacingInitialPosition()){
            if (p2MaxX >= p1MinX - 5 && p2MinY < p1MaxY && p1MinY < p2MaxY) {
                return true;
            }
        }

        return false;

    }


}
