package org.example;

import java.util.Scanner;
public class TicTacToe {
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = 2;

    public static void main(String[] args) {
        int[][] board = new int[3][3];
        Scanner keyboard = new Scanner(System.in);
        int player = PLAYER_X;
        boolean done = false;
        System.out.println("start the game");

        while (!done) {
            System.out.println("");
            printBoard(board);
            System.out.printf("\nPlayer %c's turn:\n", (player == PLAYER_X) ? 'X' : 'O');
            int row = getRow(keyboard);
            int col = getCol(keyboard);

            if (isLegalMove(board, row, col)) {
                System.out.println("Invalid move, try again");
            } else {
                placeMarker(board, row, col, player);
                if (playerWins(board, player)) {
                    // Current player wins
                    System.out.printf("Player %s wins!\n", player == PLAYER_X ? "X" : "O");
                    done = true;
                } else if (!isDraw(board)) {
                    // Game is a draw
                    System.out.println("It's a draw!");
                    done = true;
                } else {
                    // Switch player
                    player = (player == PLAYER_X) ? PLAYER_O : PLAYER_X;
                }
            }
        }
        System.out.println("Thanks for playing!");
    }
    public static void printBoard(int[][] board) {
        {
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[0].length; j++){
                    board[i][j] = ' ';
                }
            }
        }
    }

    public static int getRow(Scanner keyboard) {
        int move =0;
        if(keyboard.hasNextInt()) {
            move=keyboard.nextInt();
        }
        if((move <0) || (move >=3)) {
            throw new UnsupportedOperationException("Row number greater than 3 or less than 1");
        }
        return move;	}

    public static int getCol(Scanner keyboard) {
        int move =0;
        if(keyboard.hasNextInt()) {
            move=keyboard.nextInt();
        }
        if((move <0) || (move >=3)) {
            throw new UnsupportedOperationException("colum number greater than 3 or less than 1");
        }
        return move;
    }

    public static boolean isLegalMove(int[][] board, int row, int col) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0 && row <= 2 && row >= 0 && col <= 2 && col >= 0) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void placeMarker(int[][] board, int row, int col, int player) {
        if(board[row][col]==player) {
            System.out.println("Space is already occupied.");
        }
    }

    public static boolean playerWins(int[][] board, int player) {
        int i, j;
        boolean win = false;
        for (i = 0; i < board.length && !win; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] != player){
                    break;}
            }
            if (j == board[0].length){
                win = true;}
        }

        for (j = 0; j < board[0].length && !win; j++) {
            for (i = 0; i < board.length; i++) {
                if (board[i][j] != player){
                    break;}
            }
            if (i == board.length){
                win = true;}
        }

        if (!win) {
            for (i = 0; i < board.length; i++) {
                if (board[i][i] != player){
                    break;}
            }
            if (i == board.length){
                win = true;}
        }

        if (!win) {
            for (i = 0; i < board.length; i++) {
                if (board[i][board.length - 1 - i] != player){
                    break;}
            }
            if (i == board.length){
                win = true;}
        }
        return win;
    }


    public static boolean isDraw(int[][] board) {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                if (board[row][col] == 0) {
                    return false;  // an empty cell found, not draw, exit
                }
            }
        }
        return true;  // no empty cell, it's a draw
    }
}
