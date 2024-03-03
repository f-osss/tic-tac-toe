package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {
    @FXML
    private TextField nameTextField1;
    @FXML
    private TextField nameTextField2;

    @FXML
    RadioButton player1X, player1O, player2X, player2O;
    private char player1Symbol;
    private char player2Symbol;


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void changeScene(ActionEvent event) throws IOException {
        String username1 = nameTextField1.getText();
        String username2 = nameTextField2.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tictactoe-view.fxml"));
        root = loader.load();

        tictactoeController tictac = loader.getController();
        tictac.displayName(username1, username2);
        tictac.initialize(player1Symbol, player2Symbol);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handlePlayer1Selection(ActionEvent event) {
        if (player1X.isSelected()) {
            player1Symbol = 'X';
        } else if (player1O.isSelected()) {
            player1Symbol = 'O';
        }

    }


    public void handlePlayer2Selection(ActionEvent event) {
        if (player2X.isSelected()) {
            player2Symbol = 'X';
        } else if (player2O.isSelected()) {
            player2Symbol = 'O';
        }

    }
}

