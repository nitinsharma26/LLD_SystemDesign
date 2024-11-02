package LLD_TicTacToe;

public class DefaultWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(int row, int col, PlayerPieice piece, int[] rows, int[] cols, int[] diagonals) {
        int value = (piece == PlayerPieice.X) ? -1 : 1;

        rows[row] += value;
        cols[col] += value;

        if (row == col) diagonals[0] += value;
        if (row + col == 2) diagonals[1] += value;


        return Math.abs(rows[row]) == 3 || Math.abs(cols[col]) == 3 || Math.abs(diagonals[0]) == 3 || Math.abs(diagonals[1]) == 3;
    }
}
