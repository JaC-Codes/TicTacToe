package net.jack.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    static Handler handler = new Handler();

    public static void main(String[] args) {
        System.out.println("\nLets play tic tac toe");

        char[][] board = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        handler.printBoard(board);
        System.out.println();

        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                System.out.println("Turn: x");
                int[] spot = handler.askUser(board, scan);
                board[spot[0]][spot[1]] = 'x';
            } else {
                System.out.println("Turn: o");
                int[] spot = handler.askUser(board, scan);
                board[spot[0]][spot[1]] = 'o';
            }
            handler.printBoard(board);
            int count = handler.checkWin(board);
            if (count == 3) {
                System.out.println("x wins!");
                break;
            } else if (count == -3) {
                System.out.println("o wins!");
                break;
            } else if (i == 8) {
                System.out.println("It's a tie");
            }
        }
        scan.close();

    }


}
