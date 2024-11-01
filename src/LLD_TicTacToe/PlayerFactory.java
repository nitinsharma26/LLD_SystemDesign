package LLD_TicTacToe;

public class PlayerFactory {
    public static Player createPlayer(String name, String symbol) {
        if (symbol.equalsIgnoreCase("X")) {
            return new Player(name, PlayerPieice.X);
        } else if (symbol.equalsIgnoreCase("O")) {
            return new Player(name, PlayerPieice.O);
        } else {
            throw new IllegalArgumentException("Invalid symbol. Choose X or O.");
        }
    }
}