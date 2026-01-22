package com.tresenraya.player;

public class HumanPlayer implements Player {
    private final String name;
    private final char symbol;

    public HumanPlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String getName() { return name; }

    @Override
    public char getSymbol() { return symbol; }
}
