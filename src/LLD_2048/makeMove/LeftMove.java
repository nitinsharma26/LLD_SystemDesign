package LLD_2048.makeMove;

public class LeftMove implements StrategyMove {
    int prev = 0;
    @Override
    public void move(int[][] board) {
        int size = board.length;
        int k;
        for(int row=0;row<size;row++){
            int col = 0;
            k = 0;
            while(col<size){
                if(board[row][col]!=0){
                    if(prev == 0) {
                        prev = board[row][col];
                    }
                    else{
                        if(prev == board[row][col]){
                            prev+=prev;
                            board[row][k++]=prev;
                            prev = 0;
                        }else{
                            board[row][k++]=prev;
                            board[row][k++]=board[row][col];
                            prev=0;
                        }
                    }
                    col++;
                }else{
                    col++;
                }
            }
            if(prev!=0){
                board[row][k++]=prev;
                prev=0;
            }

            for(;k<size;k++){
                board[row][k]=0;
            }
        }
        return;
    }
}
