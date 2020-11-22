package main.module1;


import java.util.Arrays;

public class Field {
    private Player[] players;
    int round = 1;

    public Field(int i) {
        this.players = new Player[i];
    }


    public Field() {
        System.out.println("Введите количество игроков");
        Integer howPlayer = Integer.valueOf(GameLogic.scannerString());
        this.players = new Player[howPlayer];
        players[0] = new User();
        for (int i = 1; i < howPlayer; i++) {
            players[i] = new Computer();
        }
    }

    public RockScissorsPaper[] getAllValue() {
        RockScissorsPaper[] mas = new RockScissorsPaper[this.players.length];
        for (int i = 0; i < this.players.length; i++) {
            if (players[i] != null) {
                mas[i] = this.players[i].getRockScissorsPaper();
            }

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

    public boolean isEmpty() {
        boolean b = true;
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                b = false;
            }
        }
        return b;
    }
}
