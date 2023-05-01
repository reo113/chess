package application;

import javafx.scene.shape.Rectangle;

public class EmptySpot extends Spot {

	EmptySpot(Rectangle tile) {
		super(tile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Piece getPiece() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isSpotOccupied() {
		// TODO Auto-generated method stub
		return false;
	}

}
