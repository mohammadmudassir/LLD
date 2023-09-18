package entity;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Integer> board;
    public Board() {
        this.board = new ArrayList<>(101);
        for (int i = 0; i < 101; i++) {
            this.board.add(i);
        }
    }

    public List<Integer> getBoard() {
        return board;
    }

    public void setBoard(List<Integer> board) {
        this.board = board;
    }
}
