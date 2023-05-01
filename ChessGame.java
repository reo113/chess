package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;

public class ChessGame extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    final static int BOARDSIZE = 8;
    
    @Override
    public void start(Stage primaryStage) {
        ChessBoard board = new ChessBoard(BOARDSIZE);
        
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem saveItem = new MenuItem("Save");
        fileMenu.getItems().add(saveItem);
        
        saveItem.setOnAction(event ->
        {
      	  //include code to save the chess board
          //output all information to a output file	
      	  //save who's turn it is
      	  //save the position of the pieces
      	  //And maybe save the time remaining on the timer
        });

        menuBar.getMenus().addAll(fileMenu);
        StackPane root = new StackPane();
        root.getChildren().addAll(board, menuBar);
        StackPane.setAlignment(menuBar, Pos.TOP_CENTER);
        StackPane.setMargin(board, new Insets(25, 0, 0, 0));
        
        Scene scene = new Scene(root);
        primaryStage.setTitle("Chess Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
       
}
