package com.tresenraya.ui;

import com.tresenraya.game.Board;

import java.util.Scanner;

public class ConsoleUI implements UI {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showBoard(Board board) {
        System.out.println(board.render());
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public int askInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    System.out.println("Tiene que estar entre " + min + " y " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Eso no es un número. Intenta otra vez.");
            }
        }
    }
}
