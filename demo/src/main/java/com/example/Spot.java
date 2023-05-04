package com.example;

import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Spot extends StackPane {

    private Piece piece;
    private Rectangle tile;
    private ImageView imageView;
    private boolean isSpotOccupied;
    protected Piece pieceBeingDragged;
    protected ImageView imageViewBeingDragged;
    double X;
    double Y;

    public Spot(Piece piece, Rectangle tile, boolean isSpotOccupied) {
        this.piece = piece;
        this.tile = tile;
        this.imageView = null;
        this.isSpotOccupied = isSpotOccupied;

        setOnMousePressed(e -> {
            // only if the spot is empty will the mouse press be handled
            if (isSpotOccupied) {
                // save the current position of the piece in case the move is not valid
                pieceBeingDragged = piece;
                imageViewBeingDragged = imageView;
                toFront();
                setCursor(Cursor.CLOSED_HAND);
            }
        });

        setOnMouseDragged(event -> {
            if (pieceBeingDragged != null) {
                X = event.getX() - 18;
                Y = event.getY() - 18;
                imageViewBeingDragged.setTranslateX(X);
                imageViewBeingDragged.setTranslateY(Y);
            }
        });

        setOnMouseReleased(event -> {
            if (pieceBeingDragged != null) {
                Spot destinationSpot = null;
                if (this.contains(X, Y)) {
                    destinationSpot = this;

                }
                if (destinationSpot != null) {
                    // Move the Piece object to the destination Spot
                    ImageView currentPiece = destinationSpot.getImageView();
                    destinationSpot.setPiece(pieceBeingDragged);
                    destinationSpot.getChildren().add(imageViewBeingDragged); // Add the ImageView to the new Spot
                    pieceBeingDragged = null;
                    if (currentPiece != null) {
                        // capturedPieces.add(currentPiece); // Add the captured piece to a list
                        destinationSpot.getChildren().remove(currentPiece); // Remove the ImageView of the captured
                                                                            // Piece from the board
                    }
                } else {

                    imageViewBeingDragged.setTranslateX(X);
                    imageViewBeingDragged.setTranslateY(Y);
                }
                setCursor(Cursor.DEFAULT);
            }

        });

    }

    public Spot(Piece piece, Rectangle tile, ImageView imageView, boolean isSpotOccupied) {
        this.piece = piece;
        this.tile = tile;
        this.imageView = imageView;
        this.isSpotOccupied = isSpotOccupied;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;

    }

    public Rectangle getTile() {
        return tile;
    }

    public void getTileColor() {
        Color color = (Color) tile.getFill();
        System.out.println("Rectangle color: " + color.toString());
    }

    public Paint getColor() {
        return tile.getFill();
    }

    public void setTile(Rectangle tile) {
        this.tile = tile;
    }

    public double getTileX() {
        return tile.getX();
    }

    public double getTileY() {
        return tile.getY();
    }

    public boolean isSpotOccupied() {
        return isSpotOccupied;
    }
}
