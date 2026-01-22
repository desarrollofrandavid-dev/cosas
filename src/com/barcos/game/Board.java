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

        if (isInside(row, col)) &&



    }












    public String render(boolean showShips) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (grid[r][c] == CellState.EMPTY) {
                    sb.append(". ");
                } else if (grid[r][c] == CellState.MISS) {
                    sb.append("~ ");
                }else if (grid[r][c] == CellState.HIT) {
                    sb.append("X ");
                }else if (grid[r][c] == CellState.SHIP) {
                    if (showShips) {
                        sb.append("S ");
                    } else {
                        sb.append(". ");
                    }
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }







}

