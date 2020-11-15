package main.module1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import static main.module1.RockScissorsPaper.*;

public class GameLogic {

    private void startPlay(Field field) {
        for (int i = 0; i < field.getPlayers().length; i++) {
            Player player = field.getPlayers()[i];
            GameLogic.getMove(player);
        }
        if (Arrays.asList(field.getAllValue()).contains(ROCK) &
                Arrays.asList(field.getAllValue()).contains(PAPER) &
                Arrays.asList(field.getAllValue()).contains(SCISSORS)) {
            for (RockScissorsPaper RSP : field.getAllValue()) {
                System.out.println(RSP);
            }
            System.out.println("Ничья");
            startPlay(field);
        } else if (field.getPlayers().length == 2) {
            switch (GameLogic.compareMove(field.getPlayers()[0], field.getPlayers()[1])) {
                case 0:
                    System.out.println(field.getPlayers()[0].rockScissorsPaper + " vs " + field.getPlayers()[1].rockScissorsPaper + " Ничья");
                    break;
                case 1:
                    System.out.println(field.getPlayers()[0].rockScissorsPaper + " vs " + field.getPlayers()[1].rockScissorsPaper + " Вы выграли");
                    break;
                case -1:
                    System.out.println(field.getPlayers()[0].rockScissorsPaper + " vs " + field.getPlayers()[1].rockScissorsPaper + " Вы проиграли");
                    break;
            }
        } else if (Arrays.asList(field.getAllValue()).contains(ROCK) &
                Arrays.asList(field.getAllValue()).contains(SCISSORS)) {
            Player[] newPlayers = new Player[field.getPlayers().length];
            for (int i = 0; i < field.getPlayers().length; i++) {
                Player player = field.getPlayers()[i];
                if (player.rockScissorsPaper == ROCK) {
                    newPlayers[i] = player;
                }
            }
            field.setPlayers(newPlayers);
            startPlay(field);
        } else if (Arrays.asList(field.getAllValue()).contains(SCISSORS) &
                Arrays.asList(field.getAllValue()).contains(PAPER)) {
            Player[] newPlayers = new Player[field.getPlayers().length];
            for (int i = 0; i < field.getPlayers().length; i++) {
                Player player = field.getPlayers()[i];
                if (player.rockScissorsPaper == SCISSORS) {
                    newPlayers[i] = player;
                }
            }
            field.setPlayers(newPlayers);
            startPlay(field);
        } else if (Arrays.asList(field.getAllValue()).contains(PAPER) &
                Arrays.asList(field.getAllValue()).contains(ROCK)) {
            Player[] newPlayers = new Player[field.getPlayers().length];
            for (int i = 0; i < field.getPlayers().length; i++) {
                Player player = field.getPlayers()[i];
                if (player.rockScissorsPaper == PAPER) {
                    newPlayers[i] = player;
                }
            }
            field.setPlayers(newPlayers);
            startPlay(field);
        }
    }


    public static void start(Field field) {
        GameLogic gameLogic = new GameLogic();
        gameLogic.startPlay(field);
    }

    private static void getMove(Player player) {
        if (player instanceof User) {
            System.out.println("Ход игрока : Player " + player.getName());
            System.out.print("Выбирите : Камень, Ножницы или Бумага \n");
            Scanner scanner = new Scanner(System.in);
            String userStr = scanner.nextLine();
            userStr = userStr.toUpperCase();
            char charUser = userStr.charAt(0);
            switch (charUser) {
                case 'К':
                    player.setRockScissorsPaper(ROCK);
                case 'Н':
                    player.setRockScissorsPaper(SCISSORS);
                case 'Б':
                    player.setRockScissorsPaper(PAPER);
            }
            scanner.close();
            System.out.println("Неккоректный ввод");
            getMove(player);
        } else {
            player.rockScissorsPaper = RockScissorsPaper.values()[new Random().nextInt(RockScissorsPaper.values().length)];
        }
    }

    private static int compareMove(Player p1, Player p2) {
        if (p1.rockScissorsPaper == p2.rockScissorsPaper) {
            return 0;
        } else {
            switch (p1.rockScissorsPaper) {
                case ROCK:
                    return p2.rockScissorsPaper == SCISSORS ? 1 : -1;
                case PAPER:
                    return p2.rockScissorsPaper == ROCK ? 1 : -1;
                case SCISSORS:
                    return p2.rockScissorsPaper == PAPER ? 1 : -1;
            }
        }
        return 0;
    }
}


