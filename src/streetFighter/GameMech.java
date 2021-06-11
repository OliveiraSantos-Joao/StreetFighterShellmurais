package streetFighter;

public class GameMech {

    private boolean paused = true;

    public void init() {

//        while(flag) {
//            System.out.println("mech");
//        }

    }

    public void setPausedTrue(){
        this.paused = true;
    }

    public void setPausedFalse(){
        this.paused = false;
    }

    public boolean isPaused() {
        return paused;
    }

}
