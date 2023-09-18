import entity.Player;
import service.SnakeLadderService;

import java.util.Scanner;
import java.util.stream.Collectors;

public class PlaySnakeAndLadder {
    public static void main (String [] args) {
        SnakeLadderService snakeLadderService = new SnakeLadderService();
        System.out.println("Enter the command to start the game");
        Scanner sc = new Scanner(System.in);

        while  (true) {
            String command = sc.nextLine();
            String tokens[] = command.split(" ");
            String commandType = tokens[0];
            switch (commandType) {
                case "initialize_board" :
                    snakeLadderService.initializeSnakeLadderBoard();
                    break;
                case "play" :
                    String name = tokens[1];
                    System.out.println("checking name : " + name);
                    Player player = snakeLadderService.getPlayers()
                                    .stream()
                                    .filter(pl -> pl.getName().equals(name))
                                    .findFirst()
                                    .orElse(null);
                        if (player.getName().equals(name)) {
                            int position = snakeLadderService.moveOnBoard(player);
                            if (position >= 100) {
                                System.out.println(name + " Wins !!");
                                return;
                            }
                        }
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid Commad !!");
            }
        }

    }
}
