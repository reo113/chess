package com.example;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessBoard extends GridPane {

    private final int size;
    private final Color lightColor = Color.rgb(255, 206, 158);
    private final Color darkColor = Color.rgb(209, 139, 71);
    boolean bool = false;
    private static final Spot[][] spots = new Spot[8][8];
    final String IMAGE_PATH = "demo\\src\\main\\java\\com\\example\\images";

    public ChessBoard(int size) {

        this.size = size;

        // Create the squares on the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // setting placement and size of the tile
                Rectangle tile = new Rectangle(i * 50, j * 50, 50, 50);
                // alternates the color of the tiles
                tile.setFill((i + j) % 2 == 0 ? lightColor : darkColor);
                Piece piece = null;
                boolean isSpotOccupied = false;
                if (i == 0 || i == 7) {
                    switch (j) {
                        case 0:
                        case 7:
                            if (i < 2) {
                                bool = false;
                            } else {
                                bool = true;
                            }
                            piece = new Rook(false, bool);
                            isSpotOccupied = true;
                            break;
                        case 1:
                        case 6:
                            if (i < 2) {
                                bool = false;
                            } else {
                                bool = true;
                            }
                            piece = new Knight(false, bool);
                            isSpotOccupied = true;
                            break;
                        case 2:
                        case 5:
                            if (i < 2) {
                                bool = false;
                            } else {
                                bool = true;
                            }
                            piece = new Bishop(false, bool);
                            isSpotOccupied = true;
                            break;
                        case 3:
                            if (i < 2) {
                                bool = false;
                            } else {
                                bool = true;
                            }
                            piece = new Queen(false, bool);
                            isSpotOccupied = true;
                            break;
                        case 4:
                            if (i < 2) {
                                bool = false;
                            } else {
                                bool = true;
                            }
                            piece = new King(false, bool);
                            isSpotOccupied = true;
                            break;
                    }
                } else if (i == 1 || i == 6) {
                    if (i < 2) {
                        bool = false;
                    } else {
                        bool = true;
                    }
                    piece = new Pawn(false, bool);
                    isSpotOccupied = true;
                }
                this.add(tile, j, i);
                Spot spot = new Spot(piece, tile, isSpotOccupied);

                // Load the chess piece image
                if (piece != null && piece.getName(piece) != null) {
                    String imagePath = IMAGE_PATH + "\\" + piece.getName(piece) + ".png";
                    File imageFile = new File(imagePath);
                    if (imageFile.exists()) {
                        Image image = new Image(imageFile.toURI().toString());
                        ImageView imageView = new ImageView(image);
                        imageView.setFitWidth(40);
                        imageView.setFitHeight(40);
                        spot.getChildren().add(imageView);
                        spot.setImageView(imageView);
                    }
                }

                spots[i][j] = spot;
                this.add(spot, j, i);
            }
        }
    }

    public Spot[][] getBoard() {
        return spots;
    }
}