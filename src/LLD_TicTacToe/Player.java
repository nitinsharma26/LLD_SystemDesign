package LLD_TicTacToe;


public class Player {
    private String name;
    private PlayerPieice playerPiece;

    public Player(String name, PlayerPieice playerPiece) {
        this.name = name;
        this.playerPiece = playerPiece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerPieice getPlayerPiece() {
        return playerPiece;
    }

    public void setPlayerPiece(PlayerPieice playerPiece) {
        this.playerPiece = playerPiece;
    }
}
