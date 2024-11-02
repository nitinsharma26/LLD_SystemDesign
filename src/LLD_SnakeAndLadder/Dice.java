package LLD_SnakeAndLadder;

import java.util.Random;

public class Dice {

    private final Random rand = new Random();

    int rolledDice(){
        return rand.nextInt(1,6);
    }
}
