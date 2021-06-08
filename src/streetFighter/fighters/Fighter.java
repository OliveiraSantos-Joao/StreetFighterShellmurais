package streetFighter.fighters;

public class Fighter {
    //
    Fighters fighter;
    private int health;
    private int damage;
    private boolean dead;

    private int posX;
    private int posY;
    private int pixelMovement = 10;
    private int jump = 20;



    public Fighter(){

        this.fighter = Fighters.values()[(int) (Math.random()* Fighters.values().length)];
        this.health = Fighters.getInitialHealth(fighter);
        this.damage = Fighters.getDamage(fighter);
        this.dead = false;
    }

// getters && setters

    public boolean isDead() {
        return dead;
    }

    public int getHealth() {
        return health;
    }

    public int getPosX() {
        return posX;
    }

    public void moveRight() {
        this.posX = posX + pixelMovement;
    }
    public void moveLeft() {
        this.posX = posX - pixelMovement;
    }


    public int getPosY() {
        return posY;
    }

    public void jump(){
        this.posY = posY + jump;
    }

    // methods

    public void hit(int hit){
        this.health -= hit;
        checkIfDead();

    }

    private void checkIfDead(){
        if(health <= 0){
            this.health = 0;
            this.dead = true;
        }
    }


    public void attack(){

    }

    public void move(){

        InputsChampionFightingMovements champMove = new InputsChampionFightingMovements(this);
        champMove.movement();
    }

    public void healthBar(){

    }


    public void defend(){
        //extra

    }


    public void finishHim(){
        //mega extra

    }


}
