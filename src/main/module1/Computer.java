package main.module1;

import java.util.Random;

public class Computer extends Player {
    private String name;

    public Computer() {
        this.name = "Компьютер " + id++;
    }
    public String getName() {
        return name;
    }
}
