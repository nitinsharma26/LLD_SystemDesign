package LLD_TicTacToe;

public class Board {
    PlayerPieice [][]board;

    public Board(int size) {
        this.board = new PlayerPieice[size][size];
    }
    public void printBoard() {
        for(int i=0;i<board.length;i++){
            for(int j=0;j< board.length;j++){
                if(board[i][j]==null){
                    System.out.print("_ ");
                }else{
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    public boolean addPiece(int row, int column, PlayerPieice playerPieice) {
        if(board[row][column] != null) {
            return false;
        }
        board[row][column] = playerPieice;
        return true;
    }
}

