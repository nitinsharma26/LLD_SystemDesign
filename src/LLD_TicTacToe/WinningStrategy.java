package LLD_TicTacToe;

public interface WinningStrategy {
    boolean checkWin(int row, int col, PlayerPieice piece, int[] rows, int[] cols, int[] diagonals);
}
