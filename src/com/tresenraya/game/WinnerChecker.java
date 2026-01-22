package com.tresenraya.game;

public class WinnerChecker {

    public boolean hasWinner(Board board, char symbol) {
        int n = board.getSize();

        // Filas
        for (int r = 0; r < n; r++) {
            boolean ok = true;
            for (int c = 0; c < n; c++) {
                if (board.get(r, c) != symbol) { ok = false; break; }
            }
            if (ok) return true;
        }

        // Columnas
        for (int c = 0; c < n; c++) {
            boolean ok = true;
            for (int r = 0; r < n; r++) {
                if (board.get(r, c) != symbol) { ok = false; break; }
            }
            if (ok) return true;
        }

        // Diagonal principal
        boolean okDiag1 = true;
        for (int i = 0; i < n; i++) {
            if (board.get(i, i) != symbol) { okDiag1 = false; break; }
        }
        if (okDiag1) return true;

        // Diagonal secundaria
        boolean okDiag2 = true;
        for (int i = 0; i < n; i++) {
            if (board.get(i, n - 1 - i) != symbol) { okDiag2 = false; break; }
        }
        return okDiag2;
    }
}
