package com.kodilla.tictactoe.service;

public interface Game {

    boolean isValidMove(String[][] board, int row, int column);

    boolean isBoardFull(String[][] board, int a);

    boolean isWon(String[][] board, String currentPlayer, int a);
}
