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
    //private Player player
    //player.getCorrectTurn == true;

    public Spot(Piece piece, Rectangle tile, boolean isSpotOccupied) {
        this.piece = piece;
        this.tile = tile;
        this.isSpotOccupied = isSpotOccupied;
        
        
        setOnMousePressed(e -> {
        	// only if the spot is empty will the mouse press be handled
        	if(isSpotOccupied == false) {
        		// save the current position of the piece in case the move is not valid
        		setCursor(Cursor.CLOSED_HAND);
        	}
        });
        
        setOnMouseDragged(e -> {
        	// only if the spot is empty will the mouse drag be handled
        	if(isSpotOccupied == false) {
        		// update the coordinates to the new coordinates of where the piece was moved with mouse
        	}
        });
        setOnMouseReleased(e -> {
        	// only if the spot is empty and it is the correct player turn will the mouse release be handled 
        	if(isSpotOccupied == false && correctTurn == true) {
        		// remove the piece from the current spot and move it to the new spot
        		// change the isSpotOccupied to false for the old spot and true for the new spot
        		// put the piece at the center of the new spot
        	 	setCursor(Cursor.DEFAULT);
        	}
        });
        
    	// Make sure that the piece can only be moved if it's the correct person's turn
    	// save the current position of the piece in case the move is not valid
        // if the move is not valid move the piece back to the current coordinates
    	// Make sure the spot is empty (same piece color) 
    	// put the piece at the center of the new spot
    	// move the piece to the new coordinates of where the mouse released the piece
        // check to see if the piece is being moved to a spot with a enemy piece
        // if so remove the enemy piece from the spot
        // And if the mouse releases the piece out of bounds return the piece to the current position
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
	} this.piece = piece;
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
