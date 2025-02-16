package com.kodilla.tictactoe.service;

public class GameImpl implements Game {

    @Override
    public boolean isValidMove(String[][] board, int row, int column) {
        return row >= 1 && row <= 3 && column >= 1 && column <= 3 && board[row - 1][column - 1].equals(" ");
    }

    @Override
    public boolean isBoardFull(String[][] board, int a) {
        for (int row = 0; row < a; row++) {
            for (int col = 0; col < a; col++) {
                if (" ".equals(board[row][col])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isWon(String[][] board, String currentPlayer, int a) {
        for (int i = 0; i < a; i++) {
            if (board[i][0].equals(currentPlayer) && board[i][1].equals(currentPlayer) && board[i][2].equals(currentPlayer)) {
                return true;
            }
            if (board[0][i].equals(currentPlayer) && board[1][i].equals(currentPlayer) && board[2][i].equals(currentPlayer)) {
                return true;
            }
        }
        return (board[0][0].equals(currentPlayer) && board[1][1].equals(currentPlayer) && board[2][2].equals(currentPlayer)) ||
                (board[0][2].equals(currentPlayer) && board[1][1].equals(currentPlayer) && board[2][0].equals(currentPlayer));
    }
}