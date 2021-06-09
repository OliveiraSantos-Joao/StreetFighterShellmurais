package streetFighter;

public class GameMech {

    private boolean flag = true;

    public void mechInit() {

        while (flag) {
            System.out.println("do the stuffs");

        }

    }

    public void setMechRunning(boolean flag){

        this.flag = flag;

    }

}
