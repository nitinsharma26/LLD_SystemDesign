package LLD_SnakeAndLadder.dice;

import java.util.Random;

public class SixSidedDice implements DiceStrategy {
    @Override
    public int rollDice() {
        return rand.nextInt(6)+1;
    }
}
