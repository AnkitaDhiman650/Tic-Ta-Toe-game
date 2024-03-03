package SnakeAndLadderModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GameBoard {
    private int size;
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Map<String,Integer> playersCurrentPosition;

    GameBoard(Dice dice, int size, Queue<Player> nextTurn, List<Jumper> snakes, List<Jumper> ladders, Map<String,Integer> playersCurrentPosition) {
        this.dice = dice;
        this.size = size;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playersCurrentPosition = playersCurrentPosition;
    }

}
