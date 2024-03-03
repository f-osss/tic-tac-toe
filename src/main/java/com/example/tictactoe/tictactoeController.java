package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class tictactoeController {
    @FXML
    Label userName1;
    @FXML
    Label userName2;

    public void displayName(String name1, String name2) {
        userName1.setText(name1);
        userName2.setText(name2);
    }
}
