package LLD_TicTacToe;

public class DefaultWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(int row, int col, PlayerPieice piece, Integer[] rows, Integer[] cols, Integer diagLR, Integer diagRL) {
        int value = (piece == PlayerPieice.X) ? -1 : 1;

        rows[row] += value;
        cols[col] += value;

        if (row == col) diagLR += value;
        if (row + col == 2) diagRL += value;

        System.out.println(diagRL);
        return Math.abs(rows[row]) == 3 || Math.abs(cols[col]) == 3 || Math.abs(diagLR) == 3 || Math.abs(diagRL) == 3;
    }
}
