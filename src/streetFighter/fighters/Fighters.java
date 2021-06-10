package streetFighter.fighters;

public enum Fighters {

    SARA(35, 100),
    PEDRO(50,100),
    PAULO(35, 100),
    IGREJA(35, 100);


    private int damage;
    private int health;



    Fighters(int damage, int health){
        this.damage = damage;
        this.health = health;


    }

    public static int getDamage(Fighters champion){

        switch (champion){
            case SARA:
                return SARA.damage;
            case PAULO:
                return PAULO.damage;
            case PEDRO:
                return PEDRO.damage;
            case IGREJA:
                return IGREJA.damage;
            default:
                return 0;
        }

    }

    public static int getInitialHealth(Fighters champion){

        switch (champion){
            case SARA:
                return SARA.health;
            case PAULO:
                return PAULO.health;
            case PEDRO:
                return PEDRO.health;
            case IGREJA:
                return IGREJA.health;
            default:
                return 5;

        }
    }




}



