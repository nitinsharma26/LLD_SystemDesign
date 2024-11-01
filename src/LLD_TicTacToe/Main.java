package LLD_TicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = TicTacToeGame.getInstance(); // Singleton instance
        game.startGame();
    }
}
