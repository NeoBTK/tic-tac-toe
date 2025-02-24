package com.kodilla.tictactoe.service;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner scanner = new Scanner(System.in);
    private final String symbol;

    public HumanPlayer(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int[] getMove(String[][] board) {
        System.out.println("Player " + symbol + " enter your move (row 1-3, column 1-3): ");
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        return new int[]{row, column};
    }
}
