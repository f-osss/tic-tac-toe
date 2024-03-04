package com.example.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class tictactoe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader grid = new FXMLLoader(tictactoe.class.getResource("login.fxml"));

        Scene scene = new Scene(grid.load());

        primaryStage.getIcons().add(new Image(getClass().getResource("/images/tic.png").toString()));
        primaryStage.setTitle("Tic-Tac-Toe game");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            logout(primaryStage);
        });
    }

    public void logout(Stage e) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Confirm exit");
        alert.setContentText("Are you sure you want to quit the game");

        if (alert.showAndWait().get() == ButtonType.OK) {
            e.close();
        }

    }
}
