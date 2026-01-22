package com.tresenraya;

import com.tresenraya.game.Game;
import com.tresenraya.player.HumanPlayer;
import com.tresenraya.player.Player;
import com.tresenraya.ui.ConsoleUI;
import com.tresenraya.ui.UI;

public class Main {
    public static void main(String[] args) {
        UI ui = new ConsoleUI();
        Player p1 = new HumanPlayer("Jugador 1", 'X');
        Player p2 = new HumanPlayer("Jugador 2", 'O');

        Game game = new Game(p1, p2, ui);
        game.play();
    }
}
