package com.tresenraya.game;

public class Board {

    private final char[][] grid;
    private final int size;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];

        // Inicializamos el tablero vacío
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                grid[r][c] = ' ';
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(int row, int col) {
        return grid[row][col] == ' ';
    }

    public void place(int row, int col, char symbol) {
        grid[row][col] = symbol;
    }

    public char get(int row, int col) {
        return grid[row][col];
    }

    public boolean isFull() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (grid[r][c] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        for (int r = 0; r < size; r++) {
            sb.append(" ");
            for (int c = 0; c < size; c++) {
                sb.append(grid[r][c] == ' ' ? '.' : grid[r][c]);
                if (c < size - 1) {
                    sb.append(" | ");
                }
            }
            sb.append("\n");
            if (r < size - 1) {
                sb.append("---+---+---\n");
            }
        }

        sb.append("\n");
        return sb.toString();
    }
}

