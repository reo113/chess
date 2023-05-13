package com.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.example.Player.PieceColor;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
// import javafx.scene.control.Labeled;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
// import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 * the ChessGame class is the main class of the chess game application.
 * 
 * it extends the Application class and is responsible for creating the user
 * interface
 * 
 * and launching the game with the chosen players.
 */
public class ChessGame extends Application {

    /**
     * 
     * the main method of the ChessGame class. It launches the application.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    final static int BOARDSIZE = 8;
    private Player player1;
    private Player player2;
    private ChessBoard board;
    private static String winningColor;

    /**
     * 
     * The start method of the Application class that creates the user interface.
     * 
     * tt creates the main menu, sets the primary stage's scene to the main menu
     * Scene,
     * 
     * and launches the game with the chosen players when the start button is
     * pressed.
     * 
     * @param primaryStage the primary stage of the application
     */

    public void mainGameDisplay(Stage primaryStage) {
        // Create main menu and add it to a new Scene
        MainMenu mainMenu = new MainMenu();
        Scene menuScene = new Scene(mainMenu);

        // Set the primary stage's scene to the main menu Scene
        primaryStage.setTitle("Chess Game");
        primaryStage.setScene(menuScene);
        primaryStage.show();

        // Launch the game with the chosen players when the start button is pressed
        mainMenu.getStartButton().setOnAction(e -> {
            // Get player names from text fields
            String player1Name = mainMenu.getPlayer1NameField().getText();
            String player2Name = mainMenu.getPlayer2NameField().getText();

            // Assign random colors to the players
            // PieceColor player1Color = PieceColor.WHITE;
            // PieceColor player2Color = PieceColor.BLACK;

            // Create player instances with the chosen names and colors
            player1 = new WhitePlayer(player1Name, true);
            player2 = new BlackPlayer(player2Name, false);

            // Create HBox to hold player labels
            HBox playerLabels = new HBox(20);
            playerLabels.setAlignment(Pos.CENTER);
            playerLabels.getChildren().addAll(new Label(player1.getName() + " (" + "White" + ")",
                    new Label(player2.getName() + " (" + "Black" + ")")));

            // Create chess board
            board = new ChessBoard(BOARDSIZE, player1, player2);

            // Create VBox to hold player labels and chess board
            VBox gameLayout = new VBox(20);
            gameLayout.getChildren().addAll(playerLabels, board);

            // Create MenuBar
            MenuBar menuBar = new MenuBar();
            Menu fileMenu = new Menu("File");
            MenuItem saveItem = new MenuItem("Save");
            fileMenu.getItems().add(saveItem);
            saveItem.setOnAction(evt -> {
               
            });
            menuBar.getMenus().addAll(fileMenu);

            // Create StackPane to hold VBox and MenuBar
            StackPane gameRoot = new StackPane();
            gameRoot.getChildren().addAll(gameLayout, menuBar);
            StackPane.setAlignment(menuBar, Pos.TOP_CENTER);
            StackPane.setMargin(gameLayout, new Insets(25, 0, 0, 0));

            // Launch the game with the chosen players
            Scene gameScene = new Scene(gameRoot);

            primaryStage.setScene(gameScene);

            primaryStage.setMaxWidth(415);
            primaryStage.setMaxHeight(498);
            primaryStage.setMinWidth(415);
            primaryStage.setMinHeight(498);
        });
    }

    public void gameOverDisplay(Stage primaryStage) {
        // creates a game over label with a font style "Arcade Classic" and color red
        Label gameOverLabel = new Label("Game Over!");
        gameOverLabel.setFont(Font.font("Arcade Classic", 48));
        gameOverLabel.setTextFill(Color.RED);

        // creates a label with the winning color of the chess game
        Label winnerLabel = new Label(winningColor + " wins");
        winnerLabel.setFont(Font.font("Verdana", 28));
        winnerLabel.setTextFill(Color.WHITE);

        // create two buttons play again and exit
        Button playAgain = new Button("Play Again");
        Button exit = new Button("Exit");

        // set the width of the two buttons to 75
        playAgain.setPrefWidth(75);
        exit.setPrefWidth(75);

        // create a hbox and add the two buttons too it
        // center the hbox, add spacing in between the two buttons,add padding around
        // the hbox
        HBox button = new HBox(playAgain, exit);
        button.setAlignment(Pos.CENTER);
        button.setSpacing(40);
        button.setPadding(new Insets(10));

        // create a vbox and add the two lables and the buttons so they appear one after
        // another
        // set the backround color to black and center the vbox
        VBox vbox = new VBox(20, gameOverLabel, winnerLabel, button);
        vbox.setStyle("-fx-background-color: black");
        vbox.setAlignment(Pos.CENTER);

        // add mouse events to change the cursor to the hand when it is entered in
        // either of the buttons
        // change it back to the default cursor when it leaves
        playAgain.setOnMouseEntered(e -> {
            playAgain.setCursor(Cursor.HAND);
        });

        playAgain.setOnMouseExited(e -> {
            playAgain.setCursor(Cursor.DEFAULT);
        });

        exit.setOnMouseEntered(e -> {
            exit.setCursor(Cursor.HAND);
        });

        exit.setOnMouseExited(e -> {
            exit.setCursor(Cursor.DEFAULT);
        });

        // if the play again button is hit the game is started up again
        playAgain.setOnAction(e -> {
            mainGameDisplay(primaryStage);
        });

        // if the exit button is clicked the program closes
        exit.setOnAction(e -> {
            System.exit(0);
        });

        // creates the new scene with a width of 350 and height of 200
        Scene scene = new Scene(vbox, 350, 200);

        // displays the scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) {
        mainGameDisplay(primaryStage);
    }

}