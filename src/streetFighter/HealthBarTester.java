package streetFighter;

import streetFighter.fighters.Fighter;

public class HealthBarTester {
    public static void main(String[] args) {
        Fighter p1 = new Fighter();
        Fighter p2 = new Fighter();

//        HealthBar healthBar =  new HealthBar(p1.getHealth(),p2.getHealth());
        HealthBar healthBar =  new HealthBar(20 , 10 );
    }
}
