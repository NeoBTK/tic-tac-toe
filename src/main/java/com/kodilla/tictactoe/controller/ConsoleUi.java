package com.kodilla.tictactoe.controller;

import java.util.Scanner;

public class ConsoleUi {
    private final Scanner scanner = new Scanner(System.in);

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int getGameMode() {
        int gameMode = 0;
        while (gameMode != 1 && gameMode != 2) {
            System.out.println("Select game mode: 1 - Human vs. Human, 2 - Human vs. CPU");
            gameMode = scanner.nextInt();
        }
        return gameMode;
    }

    public void showBoard(String[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == null) {
                    board[row][col] = " ";
                }
                System.out.print("|");
                System.out.print(board[row][col]);
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
