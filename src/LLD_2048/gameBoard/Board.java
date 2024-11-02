package LLD_2048.gameBoard;

import java.util.Random;

public class Board {
    public int[][] board;

    private Random rand;

    public Board(int size) {
        this.board = new int[size][size];
        rand = new Random();
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0)
                    System.out.print("_ ");
                else
                    System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean putRandomNumber() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = rand.nextInt(1, 2) * 2;
                    return true;
                }
            }
        }
        return false;
    }
}
