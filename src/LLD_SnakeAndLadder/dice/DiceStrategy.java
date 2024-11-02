package LLD_SnakeAndLadder.dice;

import java.util.Random;

public interface DiceStrategy {
    Random rand = new Random();
    int rollDice();
}