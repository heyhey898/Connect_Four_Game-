

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*this class contains methods for printing the board and processing the game that includes taking user input,
* generating random input for computer and checking winning conditions*/

public class Board {

    // setting the board to have 6 rows and 7 columns only
    private char[][] board;
    public final int height = 6;
    public final int length = 7;

    public Board(){
        board = new char [height][length];
    }

    // reader to read user input
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public String getUserInput(){
        String toReturn = null;
        try{
            toReturn = input.readLine();
        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }
        return toReturn;
    }

    // method to print the board in a matrix format
    public void printBoard(){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 'r'){
                    System.out.print("| r ");
                }
                else if(board[i][j] == 'y'){
                    System.out.print("| y ");
                }
                else{
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    // method to insert 'r' and 'y' as player's input into the board
    private void placeCounter(char player, int position){
        boolean placed = false;
        if(player == 'r'){
            for(int i=board.length-1; i>=0; i--){
                if(!placed){
                    if(board[i][position-1] == 'y'){
                        // skip
                    }
                    else if(board[i][position-1] != 'r'){
                        board[i][position-1] = 'r';
                        placed = true;
                    }
                }
            }
        }
        else{
            for(int i=board.length-1; i>=0; i--){
                if(!placed){
                    if(board[i][position-1] == 'r'){
                        // skip
                    }
                    else if(board[i][position-1] != 'y'){
                        board[i][position-1] = 'y';
                        placed = true;
                    }
                }
            }
        }
    }

    // begin the actual game and check winning conditions when user chose Player 1
    public void player1Game(){
        boolean win = false;
        while(!win){
            // Player 1 (human) turn
            System.out.print("Player 1 please type a column: ");
            String userInput = getUserInput();
            int move = Integer.parseInt(userInput);
            placeCounter('r',move);
            boolean hasWon = false;
            int count = 0;
            // below checks if player 1 has meet any winning conditions
            // check horizontal
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[i].length; j++){
                    if(board[i][j] == 'r'){
                        count = count + 1;
                        if(count >= 4){
                            hasWon = true;
                            System.out.println("\nPlayer 1 Have Won!!! (horizontal)");
                        }
                    }
                    else{
                        count = 0;
                    }
                }
            }
            // check vertical
            count = 0;
            for(int i=0; i<board[0].length; i++){
                for(int j=0; j<board.length; j++){
                    if(board[j][i] == 'r'){
                        count = count + 1;
                        if(count >= 4){
                            hasWon = true;
                            System.out.println("\nPlayer 1 Have Won!!! (vertical)");
                        }
                    }
                    else{
                        count = 0;
                    }
                }
            }
            //check diagonal facing: \
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (row <= board.length-4 && col <= board[row].length-4) {
                        if ('r' == board[row][col] && 'r' == board[row+1][col+1] && 'r' == board[row + 2][col+2] && 'r' == board[row + 3][col + 3]) {
                            hasWon = true;
                            System.out.println("\nPlayer 1 Have Won!!! (diagonal \\)");
                        }
                    }
                }
            }
            //check diagonal facing: /
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (row <= board.length - 4 && col >= 3){
                        if ('r' == board[row][col] && 'r' == board[row+1][col-1] && 'r' == board[row+2][col-2] && 'r' == board[row+3][col-3]) {
                            hasWon = true;
                            System.out.println("\nPlayer 1 Have Won!!! (diagonal /)");
                        }
                    }
                }
            }
            printBoard();
            if(hasWon){
                win = true;
            }
            else{
                // player 2 (computer) turn
                move = (int)(Math.random() * 7) + 1;
                System.out.println("\nComputer Player 2 has put a piece at column: " + move);;
                placeCounter('y',move);
                hasWon = false;
                count = 0;
                // below checks if player 2 has meet any winning conditions
                // check horizontal
                for(int i=0; i<board.length; i++){
                    for(int j=0; j<board[i].length; j++){
                        if(board[i][j] == 'y'){
                            count = count + 1;
                            if(count >= 4){
                                hasWon = true;
                                System.out.println("\nComputer Player 2 Have Won!!! (horizontal)");
                            }
                        }
                        else{
                            count = 0;
                        }
                    }
                }
                // check vertical
                count = 0;
                for(int i=0; i<board[0].length; i++){
                    for(int j=0; j<board.length; j++){
                        if(board[j][i] == 'y'){
                            count = count + 1;
                            if(count >= 4){
                                hasWon = true;
                                System.out.println("\nComputer Player 2 Have Won!!! (vertical)");
                            }
                        }
                        else{
                            count = 0;
                        }
                    }
                }
                //check diagonal facing: \
                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board[row].length; col++) {
                        if (row <= board.length - 4 && col <= board[row].length - 4) {
                            if ('y' == board[row][col] && 'y' == board[row + 1][col + 1] && 'y' == board[row + 2][col + 2] && 'y' == board[row + 3][col + 3]) {
                                hasWon = true;
                                System.out.println("\nComputer Player 1 Have Won!!! (diagonal \\)");
                            }
                        }
                    }
                }
                //check diagonal facing: /
                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board[row].length; col++) {
                        if (row <= board.length - 4 && col >= 3){
                            if ('y' == board[row][col] && 'y' == board[row + 1][col - 1] && 'y' == board[row + 2][col - 2] && 'y' == board[row + 3][col - 3]) {
                                hasWon = true;
                                System.out.println("\nComputer Player 1 Have Won!!! (diagonal /)");
                            }
                        }
                    }
                }
                printBoard();
                if(hasWon){
                    win = true;
                }
            }
        }
    }

    // begin the actual game and check winning conditions when user chose Player 2
    public void player2Game(){
        boolean win = false;
        while(!win){
            // player 1 (computer) turn
            int move = (int) (Math.random() * 7) + 1;
            System.out.println("\nComputer Player 1 has put a piece at column: " + move);
            placeCounter('r',move);
            boolean hasWon = false;
            int count = 0;
            // below check if player 1 meet any winning conditions
            // check horizontal
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[i].length; j++){
                    if(board[i][j] == 'r'){
                        count = count + 1;
                        if(count >= 4){
                            hasWon = true;
                            System.out.println("\nComputer Player 1 Have Won!!! (horizontal)");
                        }
                    }
                    else{
                        count = 0;
                    }
                }
            }
            // check vertical
            count = 0;
            for(int i=0; i<board[0].length; i++){
                for(int j=0; j<board.length; j++){
                    if(board[j][i] == 'r'){
                        count = count + 1;
                        if(count >= 4){
                            hasWon = true;
                            System.out.println("\nComputer Player 1 Have Won!!! (vertical)");
                        }
                    }
                    else{
                        count = 0;
                    }
                }
            }
            //check diagonal facing: \
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (row <= board.length - 4 && col <= board[row].length - 4) {
                        if ('r' == board[row][col] && 'r' == board[row + 1][col + 1] && 'r' == board[row + 2][col + 2] && 'r' == board[row + 3][col + 3]) {
                            hasWon = true;
                            System.out.println("\nComputer Player 1 Have Won!!! (diagonal \\)");
                        }
                    }
                }
            }
            //check diagonal facing: /
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (row <= board.length - 4 && col >= 3){
                        if ('r' == board[row][col] && 'r' == board[row + 1][col - 1] && 'r' == board[row + 2][col - 2] && 'r' == board[row + 3][col - 3]) {
                            hasWon = true;
                            System.out.println("\nComputer Player 1 Have Won!!! (diagonal /)");
                        }
                    }
                }
            }
            printBoard();
            if(hasWon){
                win = true;
            }
            else{
                // player 2 (human) turn
                System.out.print("Player 2 please type a column: ");
                String userInput = getUserInput();
                move = Integer.parseInt(userInput);
                placeCounter('y',move);
                hasWon = false;
                count = 0;
                // below checks if player 2 has meet any winning conditions
                // check horizontal
                for(int i=0; i<board.length; i++){
                    for(int j=0; j<board[i].length; j++){
                        if(board[i][j] == 'y'){
                            count = count + 1;
                            if(count >= 4){
                                hasWon = true;
                                System.out.println("\nPlayer 2 Have Won!!! (horizontal)");
                            }
                        }
                        else{
                            count = 0;
                        }
                    }
                }
                // check vertical
                count = 0;
                for(int i=0; i<board[0].length; i++){
                    for(int j=0; j<board.length; j++){
                        if(board[j][i] == 'y'){
                            count = count + 1;
                            if(count >= 4){
                                hasWon = true;
                                System.out.println("\nPlayer 2 Have Won!!! (vertical)");
                            }
                        }
                        else{
                            count = 0;
                        }
                    }
                }
                //check diagonal facing: \
                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board[row].length; col++) {
                        if (row <= board.length - 4 && col <= board[row].length - 4) {
                            if ('y' == board[row][col] && 'y' == board[row + 1][col + 1] && 'y' == board[row + 2][col + 2] && 'y' == board[row + 3][col + 3]) {
                                hasWon = true;
                                System.out.println("\nPlayer 2 Have Won!!! (diagonal \\)");
                            }
                        }
                    }
                }
                //check diagonal facing: /
                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board[row].length; col++) {
                        if (row <= board.length - 4 && col >= 3){
                            if ('y' == board[row][col] && 'y' == board[row + 1][col - 1] && 'y' == board[row + 2][col - 2] && 'y' == board[row + 3][col - 3]) {
                                hasWon = true;
                                System.out.println("\nPlayer 2 Have Won!!! (diagonal /)");
                            }
                        }
                    }
                }
                printBoard();
                if(hasWon){
                    win = true;
                }
            }
        }
    }

    // begin the actual game and check winning conditions for human vs human
    public void humanGame(){
        boolean win = false;
        while(!win){
            // Player 1 (human) turn
            System.out.print("Player 1 please type a column: ");
            String userInput = getUserInput();
            int move = Integer.parseInt(userInput);
            placeCounter('r',move);
            boolean hasWon = false;
            int count = 0;
            // below checks if player 1 has meet any winning conditions
            // check horizontal
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[i].length; j++){
                    if(board[i][j] == 'r'){
                        count = count + 1;
                        if(count >= 4){
                            hasWon = true;
                            System.out.println("\nPlayer 1 Have Won!!! (horizontal)");
                        }
                    }
                    else{
                        count = 0;
                    }
                }
            }
            // check vertical
            count = 0;
            for(int i=0; i<board[0].length; i++){
                for(int j=0; j<board.length; j++){
                    if(board[j][i] == 'r'){
                        count = count + 1;
                        if(count >= 4){
                            hasWon = true;
                            System.out.println("\nPlayer 1 Have Won!!! (vertical)");
                        }
                    }
                    else{
                        count = 0;
                    }
                }
            }
            //check diagonal facing: \
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (row <= board.length-4 && col <= board[row].length-4) {
                        if ('r' == board[row][col] && 'r' == board[row+1][col+1] && 'r' == board[row + 2][col+2] && 'r' == board[row + 3][col + 3]) {
                            hasWon = true;
                            System.out.println("\nPlayer 1 Have Won!!! (diagonal \\)");
                        }
                    }
                }
            }
            //check diagonal facing: /
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (row <= board.length - 4 && col >= 3){
                        if ('r' == board[row][col] && 'r' == board[row+1][col-1] && 'r' == board[row+2][col-2] && 'r' == board[row+3][col-3]) {
                            hasWon = true;
                            System.out.println("\nPlayer 1 Have Won!!! (diagonal /)");
                        }
                    }
                }
            }
            printBoard();
            if(hasWon){
                win = true;
            }
            else{
                // player 2 (human) turn
                System.out.print("Player 2 please type a column: ");
                userInput = getUserInput();
                move = Integer.parseInt(userInput);
                placeCounter('y',move);
                hasWon = false;
                count = 0;
                // below checks if player 2 has meet any winning conditions
                // check horizontal
                for(int i=0; i<board.length; i++){
                    for(int j=0; j<board[i].length; j++){
                        if(board[i][j] == 'y'){
                            count = count + 1;
                            if(count >= 4){
                                hasWon = true;
                                System.out.println("\nPlayer 2 Have Won!!! (horizontal)");
                            }
                        }
                        else{
                            count = 0;
                        }
                    }
                }
                // check vertical
                count = 0;
                for(int i=0; i<board[0].length; i++){
                    for(int j=0; j<board.length; j++){
                        if(board[j][i] == 'y'){
                            count = count + 1;
                            if(count >= 4){
                                hasWon = true;
                                System.out.println("\nPlayer 2 Have Won!!! (vertical)");
                            }
                        }
                        else{
                            count = 0;
                        }
                    }
                }
                //check diagonal facing: \
                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board[row].length; col++) {
                        if (row <= board.length - 4 && col <= board[row].length - 4) {
                            if ('y' == board[row][col] && 'y' == board[row + 1][col + 1] && 'y' == board[row + 2][col + 2] && 'y' == board[row + 3][col + 3]) {
                                hasWon = true;
                                System.out.println("\nPlayer 1 Have Won!!! (diagonal \\)");
                            }
                        }
                    }
                }
                //check diagonal facing: /
                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board[row].length; col++) {
                        if (row <= board.length - 4 && col >= 3){
                            if ('y' == board[row][col] && 'y' == board[row + 1][col - 1] && 'y' == board[row + 2][col - 2] && 'y' == board[row + 3][col - 3]) {
                                hasWon = true;
                                System.out.println("\nPlayer 1 Have Won!!! (diagonal /)");
                            }
                        }
                    }
                }
                printBoard();
                if(hasWon){
                    win = true;
                }
            }
        }
    }

}