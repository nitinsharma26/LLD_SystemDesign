package LLD_TicTacToe;
import java.util.*;


public class TicTacToeGame {

    private static TicTacToeGame ticTacToeGame = null;
    private WinningStrategy winningStrategy;  // Strategy for checking win condition
    Deque<Player> players;
    Board gameBoard;
    Integer[] row;
    Integer[] col;
    Integer diglr=0;
    Integer digrl=0;



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
        row = new Integer[3];
        col = new Integer[3];
        Arrays.fill(row,0);
        Arrays.fill(col,0);
        winningStrategy = new DefaultWinningStrategy();  // Strategy Pattern
    }

    public void startGame(){
        boolean noWinner = true;
        while(noWinner){
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
                    break;
                }
            }
            players.addLast(playerTurn);
            boolean winner =  winningStrategy.checkWin(inputRow, inputColumn, playerTurn.getPlayerPiece(), row, col, diglr, digrl);
            if(winner) {
                gameBoard.printBoard();
                System.out.println(playerTurn.getName()+ " won the game");
                noWinner = false;
                break;
            }
        }
        if(!noWinner) return;
        System.out.println("Game Over");
    }

    private boolean iswinner(int x, int y, PlayerPieice symbol){
        if(symbol==PlayerPieice.O){
            row[x]+=1;
            col[y]+=1;
            if(x==y) diglr+=1;
            if(x+y==2) digrl+=1;
            if(row[x]==3 || col[y]==3 ||diglr==3 || digrl==3)
                return true;
        }else{
            row[x]-=1;
            col[y]-=1;
            if(x==y) diglr-=1;
            if(x+y==2) digrl-=1;
            if(row[x]==-3 || col[y]==-3 ||diglr==-3 || digrl==-3)
                return true;
        }
        return false;
    }
}
