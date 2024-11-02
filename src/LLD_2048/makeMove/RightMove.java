package LLD_2048.makeMove;

import LLD_2048.gameBoard.Board;

public class RightMove implements StrategyMove {
    int prev = 0;
    @Override
    public void move(int[][] board) {
        int size = board.length;
        int k;
        for(int row=0;row<size;row++){
            int col = size-1;
            k = size-1;
            while(col>=0){
                if(board[row][col]!=0){
                    if(prev == 0) {
                        prev = board[row][col];
                    }
                    else{
                        if(prev == board[row][col]){
                            prev+=prev;
                            board[row][k--]=prev;
                            prev = 0;
                        }else{
                            board[row][k--]=prev;
                            board[row][k--]=board[row][col];
                            prev=0;
                        }
                    }
                    col--;
                }else{
                    col--;
                }
            }
            if(prev!=0){
                board[row][k--]=prev;
                prev=0;
            }
            for(;k>=0;k--){
                board[row][k]=0;
            }
        }
        return;
    }
}
