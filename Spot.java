package com.example;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Spot extends StackPane {

    private Piece piece;
    private Rectangle tile;
    private ImageView imageView;
    private boolean isSpotOccupied = false;

    public Spot(Piece piece, Rectangle tile, boolean isSpotOccupied) {
        this.piece = piece;
        this.tile = tile;
        this.isSpotOccupied = isSpotOccupied;
    }

    public Spot(Piece piece, Rectangle tile, ImageView imageView, boolean isSpotOccupied) {
        this.piece = piece;
        this.tile = tile;
        this.imageView = imageView;
        this.isSpotOccupied = isSpotOccupied;
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

    public void setTile(Rectangle tile) {
        this.tile = tile;
    }

    public double getTileX() {
        return tile.getX();
    }

    public double getTileY() {
        return tile.getY();
    }
    
    public boolean getIsSpotOccupied() {
		return isSpotOccupied;
	}

	public void setIsSpotOccupied(boolean isSpotOccupied) {
		this.isSpotOccupied = isSpotOccupied;
	}
}

