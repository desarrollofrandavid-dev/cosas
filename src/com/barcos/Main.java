package com.barcos;
import com.barcos.game.Board;
public class Main {
    public static void main(String[] args) {
Board board = new Board(10);
        System.out.println(board.render(true));
    }
}
