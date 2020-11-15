package main.module1;

import java.io.InputStream;
import java.util.Scanner;

public class Field {
    private Player[] players;
    int round = 0;

    public Field() {
        System.out.println("Введите количество игроков");
        Scanner scanner = new Scanner(System.in);
        Integer howPlayer = scanner.nextInt();
        scanner.close();
        this.players = new Player[howPlayer];
        players[0] = new User();
        for (int i = 1; i < howPlayer; i++) {
            players[i] = new Computer();
        }
    }
    public RockScissorsPaper[] getAllValue (){
        RockScissorsPaper[] mas = new RockScissorsPaper[players.length];
        for (int i = 0; i < players.length; i++) {
            mas[i] = players[i].getRockScissorsPaper();
        }
        return mas;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public int getRound() {
        return round;
    }
}
