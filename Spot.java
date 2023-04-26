package com.example;

import javafx.scene.shape.Rectangle;

public class Spot {
    private Piece piece;
    private Rectangle tile;

    Spot(Piece piece, Rectangle tile) {
        this.piece = piece;
        this.tile = tile;

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

    public void setTile(Rectangle tile) {
        this.tile = tile;
    }

    public double getTileX() {
        return tile.getX();
    }

    public double getTileY() {
        return tile.getY();
    }
}
