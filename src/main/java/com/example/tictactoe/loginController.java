package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {
    @FXML
    private TextField nameTextField1;
    @FXML
    private TextField nameTextField2;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void changeScene(ActionEvent event) throws IOException {
        String username1 = nameTextField1.getText();
        String username2 = nameTextField2.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tictactoe-view.fxml"));
        root = loader.load();

        tictactoeController tictac = loader.getController();
        tictac.displayName(username1,username2);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
