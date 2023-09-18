package entity;

public class Player {
    String name;
    int playerId;
    int playerLocation;

    public Player(String name, int playerId, int playerLocation) {
        this.name = name;
        this.playerId = playerId;
        this.playerLocation = playerLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(int playerLocation) {
        this.playerLocation = playerLocation;
    }
}
