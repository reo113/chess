package application;

import javafx.scene.shape.Rectangle;

public abstract class Spot {
    private Rectangle tile;
    
    public abstract Piece getPiece();
    public abstract Boolean isSpotOccupied();

    Spot(Rectangle tile) {
        this.tile = tile;
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
