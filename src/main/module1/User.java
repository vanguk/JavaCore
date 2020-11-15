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


    public int getName() {
        return name;
    }
}
