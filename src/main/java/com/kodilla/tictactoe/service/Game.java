package com.kodilla.tictactoe.service;

import com.kodilla.tictactoe.controller.ConsoleUi;

public class Game {
    private int a = 3;
    private final String[][] board = new String[a][a];
    private final ConsoleUi ui;
    private Player playerX;
    private Player playerO;
    private String currentPlayer = "X";


    public Game(ConsoleUi ui) {
        this.ui = ui;
        setupPlayers();
    }

    public void run() {
        boolean endOfGame = false;
        initiateBoard(board);

        while (!endOfGame && !isBoardFull(board)) {
            ui.showBoard(board);
            Player current = currentPlayer.equals("X") ? playerX : playerO;
            int[] move = current.getMove(board);
            int row = move[0];
            int column = move[1];

            if (isValidMove(board, row, column)) {
                board[row - 1][column - 1] = currentPlayer;
                endOfGame = isWon(board, currentPlayer);
                if (currentPlayer.equals("X")) {
                    currentPlayer = "O";
                } else {
                    currentPlayer = "X";
                }
            } else {
                ui.showMessage("Invalid move! Try again.");
            }
        }
        ui.showBoard(board);
        if (endOfGame) {
            ui.showMessage("Player '" + (currentPlayer.equals("X") ? "O" : "X") + "' won!");
        } else {
            ui.showMessage("It's a draw");
        }

    }

    private void setupPlayers() {
        int mode = ui.getGameMode();
        if (mode == 1) {
            playerX = new HumanPlayer("X");
            playerO = new HumanPlayer("O");
        } else {
            playerX = new HumanPlayer("X");
            playerO = new CpuPlayer("O");
        }
    }

    private void initiateBoard(String[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = " ";
            }
        }
    }

    private boolean isValidMove(String[][] board, int row, int column) {
        return row >= 1 && row <= 3 && column >= 1 && column <= 3 && " ".equals(board[row - 1][column - 1]);
    }

    private boolean isWon(String[][] board, String currentPlayer) {
        for (int i = 0; i < board.length; i++) {
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

    private boolean isBoardFull(String[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (" ".equals(board[row][col])) {
                    return false;
                }
            }
        }
        return true;
    }
}
