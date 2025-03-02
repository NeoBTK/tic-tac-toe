package com.kodilla.tictactoe.controller;

public interface GameUi {

    void showMessage(String message);

    int getGameMode();

    void showBoard(String[][] board);
}
