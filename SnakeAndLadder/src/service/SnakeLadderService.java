package service;

import entity.Player;
import repository.SnakeLadderRepo;

import java.util.List;

public class SnakeLadderService {
    SnakeLadderRepo snakeLadderRepo;
    public SnakeLadderService() {
        this.snakeLadderRepo = new SnakeLadderRepo();
    }

    public void initializeSnakeLadderBoard() {
        this.snakeLadderRepo.initializeBoard();
    }

    public int moveOnBoard(Player player) {
        return this.snakeLadderRepo.play(player);
    }

    public List<Player> getPlayers() {
        return this.snakeLadderRepo.getPlayers();
    }


}
