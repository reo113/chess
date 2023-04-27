package application;
import java.util.ArrayList;

//Determine whether or not the Piece class should include the position of each Piece or
//The tile class can determine that
public abstract class Piece {
	
	private Boolean isKilled;
	private Boolean whitePiece;
	
	Piece(Boolean isKilled, Boolean whitePiece) {
		this.isKilled = isKilled;
		this.whitePiece = whitePiece;
	}
	
	public abstract ArrayList<Move> legalMoves(ChessBoard board, Spot start);

	//if the piece is White false is returned and true is returned for a Black piece
	public Boolean getwhitePiece() {
		return whitePiece;
	}

	//sets the piece color to either White(false) or Black(true)
	public void setWhitePiece(Boolean isWhite) {
		this.whitePiece = isWhite;
	}

	public Boolean getIsKilled() {
		return isKilled;
	}

	public void setIsKilled(Boolean isKilled) {
		this.isKilled = isKilled;
	}
  
}
