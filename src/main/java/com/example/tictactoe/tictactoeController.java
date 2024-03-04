package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class tictactoeController {
    @FXML
    Label userName1;
    @FXML
    Label userName2;

    @FXML
    private ImageView player1Symbol;

    @FXML
    private ImageView player2Symbol;


    public void displayName(String name1, String name2) {
        userName1.setText(name1);
        userName2.setText(name2);
    }

    public void initialize(char player1, char player2) {
        Image xImage = new Image(getClass().getResource("/images/x.png").toString());
        Image oImage = new Image(getClass().getResource("/images/o.png").toString());

        if (player1 == 'X') {
            player1Symbol.setImage(xImage);
        } else if (player1 == 'O') {
            player1Symbol.setImage(oImage);
        }

        if (player2 == 'X') {
            player2Symbol.setImage(xImage);
        } else if (player2 == 'O') {
            player2Symbol.setImage(oImage);
        }


//        // Initially hide both symbols
//        player1Symbol.setVisible(false);
//        player2Symbol.setVisible(false);
    }
}
