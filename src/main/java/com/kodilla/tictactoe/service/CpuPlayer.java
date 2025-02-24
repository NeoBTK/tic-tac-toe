package com.kodilla.tictactoe.service;

import java.util.Random;

public class CpuPlayer implements Player {
    private final Random random = new Random();
    private final String symbol;

    public CpuPlayer(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int[] getMove(String[][] board) {
        int row, column;
        do {
            row = random.nextInt(board.length) + 1;
            column = random.nextInt(board.length) + 1;
        } while (!" ".equals(board[row - 1][column - 1]));
        System.out.println("CPU \"" + symbol + "\" played " + row + ", " + column);
        return new int[]{row, column};
    }
}
