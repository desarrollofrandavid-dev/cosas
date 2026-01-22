package com.barcos.game;

public class Board {
private final int size;
private final CellState[][] grid;


    public Board(int size) {
        this.size = size;
        this.grid = new CellState[size][size];

        for(int r = 0; r<size ;r++){
            for(int c = 0; c<size ;c++){

                grid[r][c]= CellState.EMPTY;
            }

        }


    }

    public String render(){
        StringBuilder sb = new StringBuilder();


        for(int r = 0; r<size ;r++){
            for(int c = 0; c<size ;c++){

                if (grid[r][c] == CellState.EMPTY){
                    sb.append(". ");
                    sb.append("\n");

                }
            }

        }
        return sb.toString();
    }
}

