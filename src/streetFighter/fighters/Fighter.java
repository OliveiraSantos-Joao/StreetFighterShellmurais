package streetFighter.fighters;

public class Fighter {
    //
    Fighters fighter;
    private int health;
    private int damage;
    private boolean dead;

    private PlayerType playerType;
    private int posX;
    private int posY;
    private int pixelMovement = 10;
    private int jump = 20;
    private int height = 250;
    private int width = 100;



    public Fighter(PlayerType playerType, Fighters fighter){

        this.playerType = playerType;

        if (playerType == PlayerType.PLAYER1) { posX = 100; } else  { posX = 400; }

        this.fighter = fighter;
        this.health = Fighters.getInitialHealth(fighter);
        this.damage = Fighters.getDamage(fighter);
        this.dead = checkIfDead();

        System.out.println(playerType + " " + fighter);

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
    public int getPosY() {
        return posY;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public int getHeight() { return height; }
    public int getWidth() { return width; }

    public void moveRight() { this.posX = posX + pixelMovement; }
    public void moveLeft() { this.posX = posX - pixelMovement; }

    public int getPixelMovement() { return pixelMovement; }



    // methods

    public void jump(){
        this.posY = posY + jump;
    }

    public void hit(int hit){

        this.health -= hit;
        checkIfDead();

    }

    private boolean checkIfDead(){

        if(health <= 0){

            this.health = 0;
            return true;

        }

        return false;

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
