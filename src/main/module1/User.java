package main.module1;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Locale;
import java.util.Scanner;

public class User extends Player {
    private int name;
    private Scanner inputScanner;

    public User() {
        this.inputScanner = new Scanner(System.in);
        this.name = id ++;
    }

    public boolean playAgain() {
        System.out.println("Хотите сыграть еще раз");
        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        char firstChar = userInput.charAt(0);
        return firstChar == 'Д';
    }

    @Override
    public RockScissorsPaper getMove() {
        System.out.println("Ход игрока : Player " + name);
        System.out.print("Выбирите : Камень, Ножницы или Бумага \n");
        String userStr = new Scanner(System.in).nextLine();
        userStr = userStr.toUpperCase();
        char charUser = userStr.charAt(0);
        switch (charUser) {
            case 'К':
                return RockScissorsPaper.ROCK;
            case 'Н':
                return RockScissorsPaper.SCISSORS;
            case 'Б':
                return RockScissorsPaper.PAPER;
        }
        System.out.println("Неккоректный ввод");
        return getMove();
    }

    public int getName() {
        return name;
    }
}
