package com.kodilla.tictactoe;

import com.kodilla.tictactoe.service.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicTacToeTestSuite {

    @Test
    void testOwinsInRows() {
        //Given
        Board board1 = new Board();
        board1.setMove(1, 1, "O");
        board1.setMove(1, 2, "O");
        board1.setMove(1, 3, "O");

        Board board2 = new Board();
        board2.setMove(2, 1, "O");
        board2.setMove(2, 2, "O");
        board2.setMove(2, 3, "O");

        Board board3 = new Board();
        board3.setMove(3, 1, "O");
        board3.setMove(3, 2, "O");
        board3.setMove(3, 3, "O");

        //When
        boolean result1 = board1.isWon("O");
        boolean result2 = board2.isWon("O");
        boolean result3 = board3.isWon("O");

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertTrue(result3);
    }

    @Test
    void testOwinsInColumns() {
        //Given
        Board board1 = new Board();
        board1.setMove(1, 1, "O");
        board1.setMove(2, 1, "O");
        board1.setMove(3, 1, "O");

        Board board2 = new Board();
        board2.setMove(1, 2, "O");
        board2.setMove(2, 2, "O");
        board2.setMove(3, 2, "O");

        Board board3 = new Board();
        board3.setMove(1, 3, "O");
        board3.setMove(2, 3, "O");
        board3.setMove(3, 3, "O");

        //When
        boolean result1 = board1.isWon("O");
        boolean result2 = board2.isWon("O");
        boolean result3 = board3.isWon("O");

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertTrue(result3);
    }

    @Test
    void testOwinsDiagonal() {
        //Given
        Board board1 = new Board();
        board1.setMove(1, 1, "O");
        board1.setMove(2, 2, "O");
        board1.setMove(3, 3, "O");

        Board board2 = new Board();
        board2.setMove(1, 3, "O");
        board2.setMove(2, 2, "O");
        board2.setMove(3, 1, "O");

        //When
        boolean result1 = board1.isWon("O");
        boolean result2 = board2.isWon("O");

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
    }

    @Test
    void testXwinsInRows() {
        //Given
        Board board1 = new Board();
        board1.setMove(1, 1, "X");
        board1.setMove(1, 2, "X");
        board1.setMove(1, 3, "X");

        Board board2 = new Board();
        board2.setMove(2, 1, "X");
        board2.setMove(2, 2, "X");
        board2.setMove(2, 3, "X");

        Board board3 = new Board();
        board3.setMove(3, 1, "X");
        board3.setMove(3, 2, "X");
        board3.setMove(3, 3, "X");

        //When
        boolean result1 = board1.isWon("X");
        boolean result2 = board2.isWon("X");
        boolean result3 = board3.isWon("X");

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertTrue(result3);
    }

    @Test
    void testXwinsInColumns() {
        //Given
        Board board1 = new Board();
        board1.setMove(1, 1, "X");
        board1.setMove(2, 1, "X");
        board1.setMove(3, 1, "X");

        Board board2 = new Board();
        board2.setMove(1, 2, "X");
        board2.setMove(2, 2, "X");
        board2.setMove(3, 2, "X");

        Board board3 = new Board();
        board3.setMove(1, 3, "X");
        board3.setMove(2, 3, "X");
        board3.setMove(3, 3, "X");

        //When
        boolean result1 = board1.isWon("X");
        boolean result2 = board2.isWon("X");
        boolean result3 = board3.isWon("X");

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertTrue(result3);
    }

    @Test
    void testXwinsDiagonal() {
        //Given
        Board board1 = new Board();
        board1.setMove(1, 1, "X");
        board1.setMove(2, 2, "X");
        board1.setMove(3, 3, "X");

        Board board2 = new Board();
        board2.setMove(1, 3, "X");
        board2.setMove(2, 2, "X");
        board2.setMove(3, 1, "X");

        //When
        boolean result1 = board1.isWon("X");
        boolean result2 = board2.isWon("X");

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
    }

    @Test
    void testIsGameDraw() {
        //Given
        Board board = new Board();
        board.setMove(1, 1, "X");
        board.setMove(1, 2, "O");
        board.setMove(1, 3, "X");
        board.setMove(2, 1, "X");
        board.setMove(2, 2, "O");
        board.setMove(2, 3, "X");
        board.setMove(3, 1, "O");
        board.setMove(3, 2, "X");
        board.setMove(3, 3, "O");

        //When
        boolean result1 = board.isWon("X");
        boolean result2 = board.isWon("O");
        boolean result3 = board.isBoardFull();

        //Then
        Assertions.assertFalse(result1);
        Assertions.assertFalse(result2);
        Assertions.assertTrue(result3);
    }
}
