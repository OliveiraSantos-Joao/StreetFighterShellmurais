package fighters;

public class Fighter {
    //
    Fighters fighter;
    private int health;
    private int damage;
    private boolean dead;

    public Fighter(){

        this.fighter = Fighters.values()[(int) (Math.random()* Fighters.values().length)];
        this.health = Fighters.getInitialHealth(fighter);
        this.damage = Fighters.getDamage(fighter);
        this.dead = false;
    }



    public void hit(int hit){
        this.health-=hit;
        isDead();

    }

    private void isDead(){
        if(health<=0){
            this.health=0;
            this.dead = true;
        }
    }


    public void attack(){

    }

    public void move(){

    }

    public void healthBar(){

    }


    public void defend(){
        //extra

    }
    public void jump(){
        //extra
    }

    public void finishHim(){
        //mega extra

    }


}
