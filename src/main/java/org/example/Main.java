package org.example;

import org.example.exception.InvalidMoveException;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        Game game = new Game();
        game.startGame();
    }
}