package LLD_TicTacToe;
import java.util.*;


public class TicTacToeGame {

    private static TicTacToeGame ticTacToeGame = null;
    private WinningStrategy winningStrategy;  // Strategy for checking win condition
    Deque<Player> players;
    Board gameBoard;
    int[] row;
    int[] col;
    int[] diagonals = new int[2];



    //diagonal[0] for LR
    //diagonal[1] for RL



    // Singleton Pattern: Private constructor
    private TicTacToeGame() {
        initializeGame();
    }

    // Singleton Pattern: Static method to get the instance
    public static TicTacToeGame getInstance() {
        if (ticTacToeGame == null) {
            ticTacToeGame = new TicTacToeGame();
        }
        return ticTacToeGame;
    }

    public void initializeGame() {
        Scanner inputScanner = new Scanner(System.in);
        players = new LinkedList<>();
        for(int i=0;i<2;i++){
            String s = inputScanner.nextLine();
            String[] values = s.split(" ");
            String symbol = (values[0]);
            String name = (values[1]);
            players.add(PlayerFactory.createPlayer(name, symbol));  // Using Factory to create Players
        }
        gameBoard = new Board(3);
        row = new int[3];
        col = new int[3];
        Arrays.fill(row,0);
        Arrays.fill(col,0);
        winningStrategy = new DefaultWinningStrategy();  // Strategy Pattern
    }

    public void startGame(){
        int move = 0;
        while(move < 9){
            Player playerTurn = players.removeFirst();
            gameBoard.printBoard();
            Integer inputRow;
            Integer inputColumn;
            while(true){
                Scanner inputScanner = new Scanner(System.in);
                String s = inputScanner.nextLine();
                if(s.equals("exit")){
                    return;
                }

                String[] values = s.split(" ");
                inputRow = Integer.valueOf(values[0]) - 1;
                inputColumn = Integer.valueOf(values[1]) - 1;


                if(inputRow<0 || inputRow>2 || inputColumn < 0 || inputColumn > 2){
                    System.out.println("Invalid Move");
                    continue;
                }

                boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputColumn, playerTurn.getPlayerPiece());
                if(!pieceAddedSuccessfully) {
                    System.out.println("Invalid Move");
                }else{
                    move++;
                    break;
                }
            }
            players.addLast(playerTurn);
            boolean winner = false;
            winner = winningStrategy.checkWin(inputRow, inputColumn, playerTurn.getPlayerPiece(), row, col, diagonals);
            System.out.println(winner);
            if(winner) {
                gameBoard.printBoard();
                System.out.println(playerTurn.getName()+ " won the game");
                return;
            }
        }
        gameBoard.printBoard();
        System.out.println("Game Over");
    }
}
