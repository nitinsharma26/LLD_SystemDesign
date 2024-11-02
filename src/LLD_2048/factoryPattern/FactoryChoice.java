package LLD_2048.factoryPattern;

import LLD_2048.gameBoard.Board;
import LLD_2048.makeMove.*;

public class FactoryChoice {
    private StrategyMove leftMove = new LeftMove();
    private StrategyMove rightMove = new RightMove();
    private StrategyMove upMove = new UpMove();
    private StrategyMove dowmMove = new DownMove();
    public void Choice(int choice, int[][] board){
        if(choice==0) {
            leftMove.move(board);
        }
        else if(choice==1){
            rightMove.move(board);
        }
        else if(choice==2) {
            upMove.move(board);
        }else if(choice==3){
            dowmMove.move(board);
        }else{
            throw new IllegalArgumentException();
        }
    }
}
