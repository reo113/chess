package application;

import javafx.scene.shape.Rectangle;

public class OccupiedSpot extends Spot{

	private Piece piece;
	
	OccupiedSpot(Piece piece, Rectangle tile) {
		super(tile);
		this.piece = piece;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Piece getPiece() {
		// TODO Auto-generated method stub
		return piece;
	}

	@Override
	public Boolean isSpotOccupied() {
		// TODO Auto-generated method stub
		return true;
	}

}
