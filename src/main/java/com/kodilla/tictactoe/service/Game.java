package com.kodilla.tictactoe.service;

import com.kodilla.tictactoe.controller.GameUi;

public class Game {
    private final Board board;
    private final GameUi ui;
    private Player playerX;
    private Player playerO;
    private String currentPlayer = "X";

    public Game(GameUi ui) {
        this.board = new Board();
        this.ui = ui;
        setupPlayers();
    }

    public void run() {
        boolean endOfGame = false;

        while (!endOfGame && !board.isBoardFull()) {
            ui.showBoard(board.getBoard());
            Player current = currentPlayer.equals("X") ? playerX : playerO;
            int[] move = current.getMove(board.getBoard());
            int row = move[0];
            int column = move[1];

            if (board.isValidMove(row, column)) {
                board.setMove(row, column, currentPlayer);
                endOfGame = board.isWon(currentPlayer);
                if (currentPlayer.equals("X")) {
                    currentPlayer = "O";
                } else {
                    currentPlayer = "X";
                }
            } else {
                ui.showMessage("Invalid move! Try again.");
            }
        }
        ui.showBoard(board.getBoard());
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
}
