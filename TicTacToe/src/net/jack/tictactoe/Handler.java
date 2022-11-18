package net.jack.tictactoe;

import java.util.Scanner;

public class Handler {

    public void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public int[] askUser(char[][] board, Scanner scan) {
        System.out.println("Pick a row and column");
        int row = scan.nextInt();
        int col = scan.nextInt();

        while (board[row][col] == 'x' || board[row][col] == 'o') {
            System.out.println("Already chosen! Pick again!");
            row = scan.nextInt();
            col = scan.nextInt();
        }
        return new int[]{row, col};
    }

    public int checkWin(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'x') {
                    count++;
                } else if (board[i][j] == 'o') {
                    count--;
                }
            }
            if (count == 3 || count == -3) {
                return count;
            } else {
                count = 0;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 'x') {
                    count++;
                } else if (board[j][i] == 'o') {
                    count--;
                }
            }
            if (count == 3 || count == -3) {
                return count;
            } else {
                count = 0;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == 'x') {
                count++;
            } else if (board[i][i] == 'o') {
                count--;
            }
        }
        if (count == 3 || count == -3) {
            return count;
        } else {
            count = 0;
        }
        for (int i = 0; i < 3; i++) {
            int rowIndex = 2 - i;
            if (board[rowIndex][i] == 'x') {
                count++;
            } else if (board[rowIndex][i] == 'o') {
                count--;
            }
        }
        if (count == 3 || count == -3) {
            return count;
        } else {
            count = 0;
        }
        return count;
    }
}










