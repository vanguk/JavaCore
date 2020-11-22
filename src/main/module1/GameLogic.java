package main.module1;


import java.util.Random;
import java.util.Scanner;

import static main.module1.RockScissorsPaper.*;

public class GameLogic {

    private static void startPlay(Field field) {
        GameLogic.allGetMove(field);
        for (Player player : field.getPlayers()) {
            if (player != null) System.out.println(player.rockScissorsPaper);
        }
        RockScissorsPaper[] values = field.getAllValue();
        if (containsRollTypePairExcluded(PAPER, values)) {
            validateWinnerWith(ROCK, field);
        } else if (containsRollTypePairExcluded(ROCK, values)) {
            validateWinnerWith(SCISSORS, field);
        } else if (containsRollTypePairExcluded(SCISSORS, values)) {
            validateWinnerWith(PAPER, field);
        } else {
            System.out.println("Следующий раунд " + ++field.round);
            startPlay(field);
        }
    }

    public static void start() {
        GameLogic gameLogic = new GameLogic();
        gameLogic.startPlay(new Field());
    }

    private static void getMove(Player player) {
        if (player instanceof User) {
            System.out.println("Ход игрока : Player " + player.getName());
            System.out.print("Выберите : Камень, Ножницы или Бумага \n");
            String userStr = GameLogic.scannerString();
            char charUser = userStr.charAt(0);
            switch (charUser) {
                case 'К':
                    player.setRockScissorsPaper(ROCK);
                    break;
                case 'Н':
                    player.setRockScissorsPaper(SCISSORS);
                    break;
                case 'Б':
                    player.setRockScissorsPaper(PAPER);
                    break;
                default:
                    System.out.println("Неккоректный ввод");
                    getMove(player);
            }

        } else {
            if (player instanceof Computer)
                player.setRockScissorsPaper(RockScissorsPaper.values()[new Random().nextInt(RockScissorsPaper.values().length)]);
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

    private static void allGetMove(Field field) {
        for (int i = 0; i < field.getPlayers().length; i++) {
            GameLogic.getMove(field.getPlayers()[i]);
        }
    }

    public static String scannerString() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    private static void printRSP(Field field) {
        for (RockScissorsPaper RSP : field.getAllValue()) {
            System.out.println(RSP);
        }
    }

    public static boolean hasWinner(Player[] players) {
        int count = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) count++;
        }
        return count == 1;
    }

    public static void validateWinnerWith(RockScissorsPaper roll, Field field) {
        Field newField = new Field(field.getPlayers().length);
        int j = 0;
        for (int i = 0; i < field.getPlayers().length; i++) {
            Player player = field.getPlayers()[i];
            if (player == null) continue;
            if (player.rockScissorsPaper == roll) {
                newField.getPlayers()[j] = player;
                j++;
            }
        }
        if (hasWinner(newField.getPlayers())) {
            System.out.println("Победил " + newField.getPlayers()[0].getName());
            System.out.println("Конец игры");
        }
        else {
            System.out.println("Следующий раунд " + ++field.round);
            startPlay(newField);
        }
    }

    public static boolean containsRollTypePairExcluded(RockScissorsPaper roll, RockScissorsPaper[] array) {
        for (RockScissorsPaper item : array) {
            if (item == roll) return false;
        }
        return true;
    }
}


