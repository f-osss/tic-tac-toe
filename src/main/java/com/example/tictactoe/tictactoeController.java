package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;

public class tictactoeController {

    @FXML
    Button TL, TM, TR, MR, MM, ML, BR, BM, BL;

    @FXML
    Label userName1;
    @FXML
    Label userName2;

    @FXML
    private ImageView player1Symbol;

    @FXML
    private ImageView player2Symbol;

    private char currentPlayer;
    private char gameBoard[][] = new char[3][3];
    @FXML
    private Label player1Win, player2Win;

    private int player1count;
    private int player2count;

    private char player1Char;
    private char player2Char;


    public void displayName(String name1, String name2) {
        userName1.setText(name1);
        userName2.setText(name2);
    }

    public void initialize(char player1, char player2) {
        Image xImage = new Image(getClass().getResource("/images/x.png").toString());
        Image oImage = new Image(getClass().getResource("/images/o.png").toString());

        currentPlayer = player1;
        if (player1 == 'X') {
            player1Symbol.setImage(xImage);
            player1Char = 'X';
        } else if (player1 == 'O') {
            player1Symbol.setImage(oImage);
            player1Char = 'O';
        }

        if (player2 == 'X') {
            player2Symbol.setImage(xImage);
            player2Char = 'X';
        } else if (player2 == 'O') {
            player2Symbol.setImage(oImage);
            player2Char = 'O';
        }

        player1count = 0;
        player2count = 0;

        // Initially hide both symbols
        player1Symbol.setVisible(false);
        player2Symbol.setVisible(false);


        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = ' ';
            }
        }
    }

    private void switchPlayers() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public void buttonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonId = button.getId();

        int row = -1;
        int col = -1;

        String rowString = buttonId.substring(0, 1);
        String colString = buttonId.substring(1, 2);

        if (rowString.equals("T")) {
            row = 0;
        } else if (rowString.equals("M")) {
            row = 1;
        } else if (rowString.equals("B")) {
            row = 2;
        }

        if (colString.equals("L")) {
            col = 0;

        } else if (colString.equals("M")) {
            col = 1;
        } else if (colString.equals("R")) {
            col = 2;

        }

        gameBoard[row][col] = currentPlayer;

        if (button.getText().isEmpty()) {
            button.setText(String.valueOf(currentPlayer));


            if (currentPlayer == player1Char) {
                player2Symbol.setVisible(false);
                player1Symbol.setVisible(true);
            } else if (currentPlayer == player2Char) {
                player1Symbol.setVisible(false);
                player2Symbol.setVisible(true);
            }

            checkWin(gameBoard);
            switchPlayers();
        }
    }

    public void checkWin(char gameBoard[][]) {
        for (int row = 0; row < 3; row++) {
            if (gameBoard[row][0] == gameBoard[row][1] && gameBoard[row][1] == gameBoard[row][2] && gameBoard[row][0] != ' ' && gameBoard[row][1] != ' ' && gameBoard[row][2] != ' ') {
                win(gameBoard[row][0]);
                return;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (gameBoard[0][col] == gameBoard[1][col] && gameBoard[1][col] == gameBoard[2][col] && gameBoard[0][col] != ' ' && gameBoard[1][col] != ' ' && gameBoard[2][col] != ' ') {
                win(gameBoard[0][col]);
                return;
            }
        }

        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != ' ' && gameBoard[1][1] != ' ' && gameBoard[2][2] != ' ') {
            win(gameBoard[0][0]);
        }

        if (draw(gameBoard)) {
            clearBoard();
        }
    }

    public void win(char winner) {
        if (winner == 'X') {
            if (player1Char == 'X') {
                player1Win.setText(String.valueOf(++player1count));
            } else if (player2Char == 'X') {
                player2Win.setText(String.valueOf(++player2count));
            }
        } else if (winner == 'O') {
            if (player1Char == 'O') {
                player1Win.setText(String.valueOf(++player1count));
            } else if (player2Char == 'O') {
                player2Win.setText(String.valueOf(++player2count));
            }
        }
        clearBoard();
    }

    public boolean draw(char gameBoard[][]) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (gameBoard[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void restart() {
    }

    public void clearBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = ' ';
            }
        }

        TR.setText("");
        TM.setText("");
        TL.setText("");
        ML.setText("");
        MM.setText("");
        MR.setText("");
        BM.setText("");
        BR.setText("");
        BL.setText("");

        TR.setDisable(false);
        TM.setDisable(false);
        TL.setDisable(false);
        ML.setDisable(false);
        MM.setDisable(false);
        MR.setDisable(false);
        BM.setDisable(false);
        BR.setDisable(false);
        BL.setDisable(false);
    }
}

