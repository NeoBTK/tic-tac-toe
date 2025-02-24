package com.kodilla.tictactoe;

import com.kodilla.tictactoe.controller.ConsoleUi;
import com.kodilla.tictactoe.service.Game;

public class Application {

    public static void main(String[] args) {
        ConsoleUi ui = new ConsoleUi();
        Game game = new Game(ui);
        game.run();
    }

}
