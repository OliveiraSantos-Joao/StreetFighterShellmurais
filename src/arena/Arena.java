package arena;

public class Arena {
    ArenaType arenaType;

    public Arena(){

        arenaType = ArenaType.values()[(int) (Math.random()* ArenaType.values().length)];
    }

    public void arenaInit(){


    }



}
