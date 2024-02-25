package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class tictactoeController {
    @FXML
    Label userName;

    public void displayName(String name) {
        userName.setText(name);
    }
}
