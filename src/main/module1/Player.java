package main.module1;

import java.util.Random;

public abstract class Player {
    protected static int id = 0;
    protected RockScissorsPaper rockScissorsPaper;


    public RockScissorsPaper getMove() {
        rockScissorsPaper = RockScissorsPaper.values()[new Random().nextInt(RockScissorsPaper.values().length)];
        System.out.println("");
        return rockScissorsPaper = RockScissorsPaper.values()[new Random().nextInt(RockScissorsPaper.values().length)];
    }

    public abstract boolean playAgain();

    public void setRockScissorsPaper(RockScissorsPaper rockScissorsPaper) {
        this.rockScissorsPaper = rockScissorsPaper;
    }

    public abstract int getName();
}
