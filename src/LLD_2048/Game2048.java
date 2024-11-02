package LLD_2048;

import LLD_2048.factoryPattern.FactoryChoice;
import LLD_2048.gameBoard.Board;
import LLD_2048.makeMove.StrategyMove;

import java.util.Scanner;

public class Game2048 {
    private static Game2048 instance = null;
    private StrategyMove strategyMove;

    private FactoryChoice factoryChoice;
    private Board board;

    private Game2048() {
        this.board = new Board(4);
        board.putRandomNumber();
        board.putRandomNumber();
        factoryChoice = new FactoryChoice();
    }

    public static Game2048 getInstance() {
        if (instance == null)
            instance = new Game2048();
        return instance;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            board.printBoard();
            System.out.println("Make Move");
            System.out.println("0  -  Left");
            System.out.println("1  -  Right");
            System.out.println("2  -  Top");
            System.out.println("3  -  Bottom");
            int choice = sc.nextInt();
            factoryChoice.Choice(choice, board.board);
            if(isWinner(board.board)){
                System.out.println("Opps! Game Over");
                board.printBoard();
                return;
            }

            boolean isPlaced = board.putRandomNumber();
            if(!isPlaced){
                System.out.println("Opps! Game Over");
                return;
            }
        }
    }

    private boolean isWinner(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 2048){
                    return true;
                }
            }
        }
        return false;
    }
}
