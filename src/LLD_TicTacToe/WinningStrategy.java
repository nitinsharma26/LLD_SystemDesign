package LLD_TicTacToe;

public interface WinningStrategy {
    boolean checkWin(int row, int col, PlayerPieice piece, Integer[] rows, Integer[] cols, Integer diagLR, Integer diagRL);
}
