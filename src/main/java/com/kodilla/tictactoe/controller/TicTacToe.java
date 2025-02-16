package com.kodilla.tictactoe.controller;

import com.kodilla.tictactoe.service.Game;
import com.kodilla.tictactoe.service.GameImpl;

import java.util.Scanner;

public class TicTacToe {
    private int a = 3;
    private final String[][] board = new String[a][a];
    private String currentPlayer = "X";
    Game engine = new GameImpl();
    
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean endOfGame = false;

        while (!endOfGame) {
            showBoard();
            System.out.println("Player " + currentPlayer + " enter your move (row 1-3, column 1-3): ");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            if (engine.isValidMove(board, row, column)) {
                board[row - 1][column - 1] = currentPlayer;
                endOfGame = engine.isWon(board, currentPlayer, a);
                if (currentPlayer.equals("X")) {
                    currentPlayer = "O";
                } else {
                    currentPlayer = "X";
                }
            } else {
                System.out.println("Invalid move");
            }
        }
        showBoard();
        if (endOfGame) {
            if (currentPlayer.equals("X")) {
                System.out.println("Player 'O' won!");
            } else {
                System.out.println("Player 'X' won!");
            }
        } else {
            System.out.println("It'a draw");
        }
    }

    private void showBoard() {
        for (int row = 0; row < a; row++) {
            for (int col = 0; col < a; col++) {
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
