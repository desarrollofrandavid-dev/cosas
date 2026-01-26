package com.barcos.game;

public class Board {

    private final int size;
    private final CellState[][] grid;


    public Board(int size) {
        this.size = size;
        this.grid = new CellState[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {

                grid[r][c] = CellState.EMPTY;
            }
        }
    }

    public boolean isInside(int row, int col){
        return row >=0 && row< size && col >= 0 && col< size;

    }

    public boolean placeShipCell(int row, int col){

        if (!isInside(row, col)) return false;
        if (grid [row][col] != CellState.EMPTY) return false;
        grid [row][col] = CellState.SHIP;
        return true;

    }

    public boolean placeShip(int row, int col, int length, boolean horizontal){
// 1) Comprobar que el barco cabe (no se sale del tablero)
        if (horizontal) {
            if (col + length > size) return false;
        } else {
            if (row + length > size) return false;
        }

        // 2) Comprobar que todas las casillas están vacías (no pisa otro barco)
        for (int l = 0;l < length; l++ ){
            int r = horizontal ? row : row + l;
            int c = horizontal ? col + l : col;
            if (grid[r][c] != CellState.EMPTY)
            {return false;}

        }
        // 3) Colocar el barco (marcar casillas como SHIP)
        for (int j = 0;j < length; j++ ){
            int r = horizontal ? row : row + j;
            int c = horizontal ? col + j : col;
            grid[r][c] = CellState.SHIP;
        }
        return true;

    }

    public boolean shoot(int row, int col){
        // 1) Dentro del tablero
        if (!isInside(row, col)) return false;

        // 2) No disparar dos veces
        if (grid [row][col] == CellState.HIT || grid [row][col] == CellState.MISS) return false;

        // 3) Aplicar disparo
        if (grid [row][col] == CellState.SHIP){
            grid [row][col] = CellState.HIT;
            return true;
        }  grid[row][col] = CellState.MISS;
        return false;

    }



    private boolean isShipAround(int row, int col) {







    }












    public String render(boolean showShips) {
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                CellState cell = grid[r][c];

                if (cell == CellState.EMPTY) {
                    sb.append(". ");
                } else if (cell == CellState.MISS) {
                    sb.append("~ ");
                } else if (cell == CellState.HIT) {
                    sb.append("X ");
                } else if (cell == CellState.SHIP) {
                    sb.append(showShips ? "S " : ". ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }







}

