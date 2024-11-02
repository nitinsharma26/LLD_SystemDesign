package LLD_SnakeAndLadder;

public class Player {
    private String name;
    int pos;

    public Player(String name,int pos) {
        this.name = name;
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
