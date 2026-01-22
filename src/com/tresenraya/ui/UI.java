package com.tresenraya.ui;

import com.tresenraya.game.Board;

public interface UI {

    void showBoard(Board board);

    void showMessage(String message);

    int askInt(String prompt, int min, int max);
}
