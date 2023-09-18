package repository;

import entity.Board;
import entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SnakeLadderRepo {
    Board snakeLadderBoard;
    List<Player> players;
    public SnakeLadderRepo() {
        this.snakeLadderBoard = new Board();
        players = new ArrayList<>();
    }

    public void initializeBoard() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of snake");
        int noOfSnake = sc.nextInt();
        System.out.println("Enter starting and end points of snake");
        for (int i = 0; i < noOfSnake; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            this.snakeLadderBoard.getBoard().set(start, end);
        }
        System.out.println("Enter Number of ladder");
        int noOfLadder = sc.nextInt();
        System.out.println("Enter starting and end points of ladder");
        for (int i = 0; i < noOfLadder; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            this.snakeLadderBoard.getBoard().set(start, end);
        }
        System.out.println("Enter Number of players");
        int noOfPlayers = sc.nextInt();
        System.out.println("Enter name of players");
        for (int i = 0; i < noOfPlayers; i++) {
            this.players.add(new Player(sc.next(), i + 1, 0));
        }
        System.out.println("snake and ladder board is created !!");
    }

    public int RollDice() {
        return new Random().nextInt(6) + 1;
    }

    public int move(int position) {
        while (position < 100 && position != this.snakeLadderBoard.getBoard().get(position)) {
            System.out.println("move position : " + position);
            System.out.println("move position compared : " + this.snakeLadderBoard.getBoard().get(position));
            position = this.snakeLadderBoard.getBoard().get(position);
        }
        return position;
    }

    public int play(Player player) {
        int diceValue = RollDice();
        System.out.println("Dice Value is : " + diceValue);
        int initialPosition = player.getPlayerLocation();
        System.out.println("initial location is : " + initialPosition);
        int finalPosition = move(initialPosition + diceValue);
        System.out.println("final position is : " + initialPosition);
        player.setPlayerLocation(finalPosition);
        System.out.println(player.getName() + " rolled a " + diceValue + " and moved from " + initialPosition + " to " + finalPosition);
        return finalPosition;
    }

    public List<Player> getPlayers() {
        return this.players;
    }
}
