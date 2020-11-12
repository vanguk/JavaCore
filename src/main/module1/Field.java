package main.module1;

public class Field {
    private Player[] players;
    int round = 0;

    public Field(int howPlayers) {
        this.players = new Player[howPlayers];

    }

    public Field() {
        this.players = new Player[2];
        players[0] = new User();
        players[1] = new Computer();
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
