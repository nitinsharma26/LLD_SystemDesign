package LLD_SnakeAndLadder;

import LLD_SnakeAndLadder.dice.DiceStrategy;
import LLD_SnakeAndLadder.dice.SixSidedDice;

import java.util.*;

public class SnakeAndLadder {
    private static SnakeAndLadder snakeAndLadder = null;
    HashMap<Integer,Integer> jump = new HashMap<>();

    private Deque<Player> playerList;

    DiceStrategy dice;

    private SnakeAndLadder(){

    }
    static SnakeAndLadder getInstance(){
        if(snakeAndLadder == null){
            snakeAndLadder = new SnakeAndLadder();
        }
        return snakeAndLadder;
    }

    public void init(){
        int snake;
        Scanner sc = new Scanner(System.in);
        dice = new SixSidedDice();
        snake = sc.nextInt();

        while(snake>0){
            int from, end;
            from = sc.nextInt();
            end = sc.nextInt();
            jump.put(from,end);
            snake--;
        }
        System.out.println("Enter Ladder");

        int ladder;
        ladder = sc.nextInt();
        while(ladder>0){
            int from, end;
            from = sc.nextInt();
            end = sc.nextInt();
            jump.put(from,end);
            ladder--;
        }

        System.out.println("Enter player");
        int numPlayer;
        numPlayer = sc.nextInt();
        sc.nextLine();
        playerList = new LinkedList<>();
        while(numPlayer>0){
            String name = sc.nextLine();
            Player player = new Player(name);
            playerList.add(player);
            numPlayer--;
        }
    }

    public void start() {
        while(true){
            Player currentPlayer = playerList.removeFirst();
            int rollnumber = dice.rollDice();
            int curPos = currentPlayer.pos + rollnumber > 100 ? currentPlayer.pos : currentPlayer.pos + rollnumber;
            if(jump.containsKey(curPos)){
                curPos = jump.get(curPos);
            }

            System.out.println(currentPlayer.getName() + " rolled a "+ rollnumber +" and moved from "+ currentPlayer.pos +" to "+ curPos);

            if(curPos == 100){
                System.out.println(currentPlayer.getName() + " wins the game");
                return;
            }
            currentPlayer.setPos(curPos);
            playerList.addLast(currentPlayer);
        }
    }
}
