package streetFighter;

import streetFighter.inputs.Inputs;

public class GameMech {

    private boolean flag = true;

    public void init() {

        while(flag) {
            System.out.println("mech");
        }

    }

    public void setFlagTrue(){
        this.flag = true;
    }

    public void setFlagFalse(){
        this.flag = false;
    }

    public boolean isFlag() {
        return flag;
    }

}
