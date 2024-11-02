package LLD_2048.makeMove;

import LLD_2048.gameBoard.Board;

public class DownMove implements StrategyMove {

    int prev = 0;

    @Override
    public void move(int[][] board) {
        int size = board.length;
        int k;
        for (int col = 0; col < size; col++) {
            int row = size - 1;
            k = size - 1;
            while (row >= 0) {
                if (board[row][col] != 0) {
                    if (prev == 0) {
                        prev = board[row][col];
                    } else {
                        if (prev == board[row][col]) {
                            prev += prev;
                            board[k--][col] = prev;
                            prev = 0;
                        } else {
                            board[k--][col] = prev;
                            board[k--][col] = board[row][col];
                            prev = 0;
                        }
                    }
                    row--;
                } else {
                    row--;
                }
            }
            if (prev != 0) {
                board[k--][col] = prev;
                prev = 0;
            }

            for (; k >= 0; k--) {
                board[k++][col] = 0;
            }
        }
    }
}