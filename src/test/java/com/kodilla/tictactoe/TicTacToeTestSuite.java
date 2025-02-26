package com.kodilla.tictactoe;

import com.kodilla.tictactoe.controller.ConsoleUi;
import com.kodilla.tictactoe.service.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;

public class TicTacToeTestSuite {
    private Game game;
    private ConsoleUi ui;
    private Method methodIsWon;
    private Method methodIsBoardFull;

    void provideInput(String data) {
        ByteArrayInputStream testInput = new ByteArrayInputStream(data.getBytes());
        System.setIn(testInput);
    }

    @BeforeEach
    void setUp() throws NoSuchMethodException {
        provideInput("1");
        ui = new ConsoleUi();
        game = new Game(ui);
        methodIsWon = Game.class.getDeclaredMethod("isWon", String[][].class, String.class);
        methodIsWon.setAccessible(true);
    }

    @AfterEach
    void tearDown() {
        System.setIn(System.in);
    }

    @Test
    void testOwinsInRows() throws Exception {
        //Given
        String[][] board1 = { { "O", "O", "O" }, { " ", " ", " " }, { " ", " ", " " } };
        String[][] board2 = { { " ", " ", " " }, { "O", "O", "O" }, { " ", " ", " " } };
        String[][] board3 = { { " ", " ", " " }, { " ", " ", " " }, { "O", "O", "O" } };

        //When
        boolean result1 = (boolean) methodIsWon.invoke(game,  board1, "O");
        boolean result2 = (boolean) methodIsWon.invoke(game,  board2, "O");
        boolean result3 = (boolean) methodIsWon.invoke(game,  board3, "O");

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertTrue(result3);
    }

    @Test
    void testOwinsInColumns() throws Exception {
        //Given
        String[][] board1 = { { "O", " ", " " }, { "O", " ", " " }, { "O", " ", " " } };
        String[][] board2 = { { " ", "O", " " }, { " ", "O", " " }, { " ", "O", " " } };
        String[][] board3 = { { " ", " ", "O" }, { " ", " ", "O" }, { " ", " ", "O" } };

        //When
        boolean result1 = (boolean) methodIsWon.invoke(game,  board1, "O");
        boolean result2 = (boolean) methodIsWon.invoke(game,  board2, "O");
        boolean result3 = (boolean) methodIsWon.invoke(game,  board3, "O");

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertTrue(result3);
    }

    @Test
    void testOwinsDiagonal() throws Exception {
        //Given
        String[][] board1 = { { "O", " ", " " }, { " ", "O", " " }, { " ", " ", "O" } };
        String[][] board2 = { { " ", " ", "O" }, { " ", "O", " " }, { "O", " ", " " } };

        //When
        boolean result1 = (boolean) methodIsWon.invoke(game,  board1, "O");
        boolean result2 = (boolean) methodIsWon.invoke(game,  board2, "O");

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
    }

    @Test
    void testXwinsInRows() throws Exception {
        //Given
        String[][] board1 = { { "X", "X", "X" }, { " ", " ", " " }, { " ", " ", " " } };
        String[][] board2 = { { " ", " ", " " }, { "X", "X", "X" }, { " ", " ", " " } };
        String[][] board3 = { { " ", " ", " " }, { " ", " ", " " }, { "X", "X", "X" } };

        //When
        boolean result1 = (boolean) methodIsWon.invoke(game,  board1, "X");
        boolean result2 = (boolean) methodIsWon.invoke(game,  board2, "X");
        boolean result3 = (boolean) methodIsWon.invoke(game,  board3, "X");

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertTrue(result3);
    }

    @Test
    void testXwinsInColumns() throws Exception {
        //Given
        String[][] board1 = { { "X", " ", " " }, { "X", " ", " " }, { "X", " ", " " } };
        String[][] board2 = { { " ", "X", " " }, { " ", "X", " " }, { " ", "X", " " } };
        String[][] board3 = { { " ", " ", "X" }, { " ", " ", "X" }, { " ", " ", "X" } };

        //When
        boolean result1 = (boolean) methodIsWon.invoke(game,  board1, "X");
        boolean result2 = (boolean) methodIsWon.invoke(game,  board2, "X");
        boolean result3 = (boolean) methodIsWon.invoke(game,  board3, "X");

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertTrue(result3);
    }

    @Test
    void testXwinsDiagonal() throws Exception {
        //Given
        String[][] board1 = { { "X", " ", " " }, { " ", "X", " " }, { " ", " ", "X" } };
        String[][] board2 = { { " ", " ", "X" }, { " ", "X", " " }, { "X", " ", " " } };

        //When
        boolean result1 = (boolean) methodIsWon.invoke(game,  board1, "X");
        boolean result2 = (boolean) methodIsWon.invoke(game,  board2, "X");

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
    }

    @Test
    void testIsGameDraw() throws Exception {
        //Given
        String[][] board1 = { { "O", "X", "O" }, { "X", "O", "X" }, { "O", "X", "X" } };
        String[][] board2 = { { "X", "O", "X" }, { "O", "X", "O" }, { "X", "X", "O" } };
        String[][] board3 = { { "X", "X", "O" }, { "O", "O", "X" }, { "X", "O", "X" } };

        //When
        methodIsBoardFull = Game.class.getDeclaredMethod("isBoardFull", String[][].class);
        methodIsBoardFull.setAccessible(true);
        boolean result1 = (boolean) methodIsBoardFull.invoke(game, (Object) board1);
        boolean result2 = (boolean) methodIsBoardFull.invoke(game, (Object) board2);
        boolean result3 = (boolean) methodIsBoardFull.invoke(game, (Object) board3);

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertTrue(result3);
    }
}
