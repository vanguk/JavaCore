package main.module1;

import java.util.Random;

public class Computer extends Player {
    private int name;

    public Computer() {
        this.name = id++;
    }
    @Override
    public boolean playAgain() {
        return false;
    }
    public int getName() {
        return name;
    }
}
