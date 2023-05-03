package application;

import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Spot extends StackPane {

    private Piece piece;
    private Rectangle tile;
    private boolean isSpotOccupied;
    private ImageView imageView;
    private boolean correctTurn; //change to a player object
	 protected Piece pieceBeingDragged;
    protected ImageView imageViewBeingDragged;
    private double deltaX ;
    private double deltaY ;
    private Spot[][] spots = new Spot[8][8];
    //private Player player
    //player.getCorrectTurn == true;

    public Spot(Piece piece, Rectangle tile, boolean isSpotOccupied) {
       this.piece = piece;
        this.tile = tile;
        this.imageView = null;
        this.isSpotOccupied = isSpotOccupied;
	    
        setOnMousePressed(e -> {
            // only if the spot is empty will the mouse press be handled
            if (isSpotOccupied) {
                // save the current position of the piece in case the move is not valid

                pieceBeingDragged = this.piece;
                imageViewBeingDragged = this.imageView;
                setCursor(Cursor.CLOSED_HAND);
            }
        });

        setOnMouseDragged(e -> {
            if (pieceBeingDragged != null) {
                double mouseX = e.getSceneX();
                double mouseY = e.getSceneY();
                imageViewBeingDragged.setTranslateX(mouseX);
                imageViewBeingDragged.setTranslateY(mouseY);
               
            }
        });

        setOnMouseReleased(e -> {
            if (pieceBeingDragged != null) {
                Spot destinationSpot = null;
                for (int row = 0; row < 8; row++) {
                    for (int col = 0; col < 8; col++) {

                        if (this.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())) {
                            destinationSpot = this;
                            break;
                        }
                    }
                }
                if (destinationSpot != null) {
                    // Move the Piece object to the destination Spot
                    ImageView currentPiece = destinationSpot.getImageView();
                    destinationSpot.setPiece(pieceBeingDragged);
                    destinationSpot.getChildren().add(imageViewBeingDragged); // Add the ImageView to the new Spot
                    pieceBeingDragged = null;
                    if (currentPiece != null) {
                        // capturedPieces.add(currentPiece); // Add the captured piece to a list
                        destinationSpot.getChildren().remove(currentPiece); // Remove the ImageView of the captured Piece from the board
                    }
                } else {
                    double originalX = this.getTileX();
                    double originalY = this.getTileY();
                    imageViewBeingDragged.setTranslateX(originalX);
                    imageViewBeingDragged.setTranslateY(originalY);
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

    public void setTile(Rectangle tile) {
        this.tile = tile;
    }

    public double getTileX() {
        return tile.getX();
    }

    public double getTileY() {
        return tile.getY();
    }

	public boolean getisSpotOccupied() {
		return isSpotOccupied;
	}

	public void setisSpotOccupied(boolean isSpotOccupied) {
		this.isSpotOccupied = isSpotOccupied;
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
    public Paint getColor() {
        return tile.getFill();
    }
    public boolean isSpotOccupied() {
        return isSpotOccupied;
    }
    public void setArr(Spot[][] spots){
        this.spots =spots;
    }
}

	
}
