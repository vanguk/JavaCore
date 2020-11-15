package main.module1;

import java.util.Random;

public abstract class Player {
    protected static int id = 0;
    protected RockScissorsPaper rockScissorsPaper;


    public abstract boolean playAgain();

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Player.id = id;
    }

    public RockScissorsPaper getRockScissorsPaper() {
        return rockScissorsPaper;
    }

    public void setRockScissorsPaper(RockScissorsPaper rockScissorsPaper) {
        this.rockScissorsPaper = rockScissorsPaper;
    }

    public abstract int getName();
}
