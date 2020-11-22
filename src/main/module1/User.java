package main.module1;

import java.util.Scanner;

public class User extends Player {
    private String name;


    public User() {

        this.name = "Игрок " + id++;
    }


    public String getName() {
        return name;
    }
}
