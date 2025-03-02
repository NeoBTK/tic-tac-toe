package com.kodilla.tictactoe.service;

public class Board {
    private final int size = 3;
    private String[][] board;


    public Board() {
        board = new String[size][size];
        initiateBoard();
    }

    public void initiateBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = " ";
            }
        }
    }

    public boolean isValidMove(int row, int column) {
        return row >= 1 && row <= size && column >= 1 && column <= size && " ".equals(board[row - 1][column - 1]);
    }

    public boolean isWon(String currentPlayer) {
        for (int i = 0; i < size; i++) {
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

    public boolean isBoardFull() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (" ".equals(board[row][col])) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setMove(int row, int column, String player) {
        board[row - 1][column - 1] = player;
    }

    public String[][] getBoard() {
        return board;
    }
}
