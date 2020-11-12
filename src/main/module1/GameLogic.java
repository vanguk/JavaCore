package main.module1;

public class GameLogic {


    public static void start(){
        GameLogic gameLogic = new GameLogic();
        gameLogic.startPlay( new Field());
    }

    public void startPlay(Field field) {
        System.out.println("КАМЕНЬ, НОЖНИЦЫ, БУМАГА");

        RockScissorsPaper firstPlayer = field.getPlayers()[0].getMove();
        RockScissorsPaper secondPlayer = field.getPlayers()[1].getMove();
        System.out.println("Player " + field.getPlayers()[0].getName() + " выкидывает " + firstPlayer);
        System.out.println("Player " + field.getPlayers()[1].getName() + " выкидывает " + secondPlayer);
        int compareRockScissorPaper = firstPlayer.compareMove(secondPlayer);
        switch (compareRockScissorPaper) {
            case 0:
                System.out.println("Ничья");
                break;
            case 1:
                System.out.println("Player " + field.getPlayers()[0].getName() + " выграл у " + field.getPlayers()[1].getName());
                break;
            case -1:
                System.out.println("Player " + field.getPlayers()[0].getName() + " проиграл " + field.getPlayers()[1].getName());
                break;
        }
        if (field.getPlayers()[0].playAgain()){
            startPlay(field);
        }else {
            System.exit(0);
        }
    }

}

