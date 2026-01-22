package com.tresenraya.game;

import com.tresenraya.player.Player;
import com.tresenraya.ui.UI;

public class Game {
    private final Board board = new Board(3);
    private final Player p1;
    private final Player p2;
    private final UI ui;
    private final WinnerChecker winnerChecker = new WinnerChecker();

    private Player current;

    public Game(Player p1, Player p2, UI ui) {
        this.p1 = p1;
        this.p2 = p2;
        this.ui = ui;
        this.current = p1;
    }

    public void play() {
        ui.showMessage("🎲 3 en raya iniciado");
        while (true) {
            ui.showBoard(board);

            Move move = askMove(current);
            board.place(move.row(), move.col(), current.getSymbol());

            if (winnerChecker.hasWinner(board, current.getSymbol())) {
                ui.showBoard(board);
                ui.showMessage("🏆 Ha ganado " + current.getName() + " (" + current.getSymbol() + ")");
                return;
            }

            if (board.isFull()) {
                ui.showBoard(board);
                ui.showMessage("🤝 Empate. Tablero lleno.");
                return;
            }

            current = (current == p1) ? p2 : p1;
        }
    }

    private Move askMove(Player player) {
        int n = board.getSize();
        while (true) {
            ui.showMessage("Turno de " + player.getName() + " (" + player.getSymbol() + ")");
            int row = ui.askInt("Fila (1-" + n + "): ", 1, n) - 1;
            int col = ui.askInt("Columna (1-" + n + "): ", 1, n) - 1;

            if (!board.isEmpty(row, col)) {
                ui.showMessage("⛔ Esa casilla ya está ocupada. Elige otra.");
                continue;
            }
            return new Move(row, col);
        }
    }
}
