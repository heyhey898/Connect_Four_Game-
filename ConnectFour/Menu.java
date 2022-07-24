

import java.util.Scanner;

/* this class contains the menu introducing connect 4 and ask the user to choose a player */

public class Menu {

    private Board board = new Board();

    public void gameMenu() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.print("Type '1' or '2' to select player and played against a computer, type '3' to play against human: ");

        Scanner scan = new Scanner(System.in);    // create scanner object to read user input
        int chosenPlayer = scan.nextInt();

        while(chosenPlayer > 3 || chosenPlayer == 0){     //to make sure user type 1, 2 or 3 only
            System.out.println("Please type 1, 2 or 3 only: ");
            chosenPlayer = scan.nextInt();
        }
        if (chosenPlayer == 1) {
            System.out.println("You are now Player 1 and you are represented by 'r'");
            startGame1();
        } else if (chosenPlayer == 2) {
            System.out.println("You are now Player 2 and you are represented by 'y'");
            startGame2();
        } else if (chosenPlayer == 3) {
            System.out.println("You are now playing against human, Player 1 is 'r' and Player 2 is 'y'");
            startGame3();
        }
    }

    // use this method if the user chose Player 1
    private void startGame1() {
        board.printBoard();
        board.player1Game();
    }

    // use this method if the user chose Player 2
    private void startGame2() {
        board.player2Game();
    }

    // use this method if the user chose '3' human vs human
    //I have created this method mainly for testing win conditions
    private void startGame3() {
        board.printBoard();
        board.humanGame();
    }
}