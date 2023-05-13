package com.example;

import java.util.ArrayList;

import com.example.Player.PieceColor;

/**
 * 
 * a class representing a king chess piece.
 */
public class King extends Piece {

	private boolean firstMove;

	/**
	 * 
	 * constructor for the king class.
	 * 
	 * @param color a PieceColor enum representing the color of the king
	 *              (either white or black)
	 *              sets the firstMove to true
	 */
	public King(PieceColor color) {
		super(color);
		this.firstMove = true;
	}

	/**
	 * 
	 * returns whether or not this King piece has made its first move.(needed for
	 * castling)
	 * 
	 * @return true if the King has not moved yet, false otherwise.
	 */
	public boolean isFirstMove() {
		return firstMove;
	}

	/**
	 * 
	 * sets whether or not this King piece has made its first move.(needed for
	 * castling)
	 * 
	 * @param firstMove true if the King has not moved yet, false otherwise.
	 */
	public void setFirstMove(boolean firstMove) {
		this.firstMove = firstMove;
	}

	/**
	 * 
	 * returns a list of all legal moves for this King piece on the given board
	 * 
	 * starting from the given spot.
	 * 
	 * @param board the ChessBoard on which the King is placed.
	 * 
	 * @param start the starting spot of the King.
	 * 
	 * @return a list of all legal moves for the King.
	 */
	@Override
	public ArrayList<Move> legalMoves(ChessBoard board, Spot start) {

		ArrayList<Move> moves = new ArrayList<>();
		int startRow = start.getRow();
		int startCol = start.getColumn();

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0) {
					continue; // Skip the king's current spot
				}

				int newRow = startRow + i;
				int newCol = startCol + j;
				Spot end = board.getSpot(newRow, newCol);

				if (end != null && (!end.isSpotOccupied() || end.getPiece().getColor() != getColor())) {
					moves.add(new Move(start, end));
				}
			}
		}

		return moves;
	}

	/**
	 * 
	 * checks whether or not this King piece can move to the given end spot
	 * 
	 * on the given board starting from the given start spot.
	 * 
	 * @param board the ChessBoard on which the King is placed.
	 * 
	 * @param start the starting spot of the King.
	 * 
	 * @param end   the end spot for the King to move to.
	 * 
	 * @return true if the King can move to the end spot, false otherwise.
	 */
	@Override
	public boolean canMove(ChessBoard board, Spot start, Spot end) {
		if (end.isSpotOccupied() && end.getPiece().getColor() == getColor()) {
			return false;
		}

		int startRow = start.getRow();
		int startCol = start.getColumn();
		int endRow = end.getRow();
		int endCol = end.getColumn();

		int rowDiff = Math.abs(startRow - endRow);
		int colDiff = Math.abs(startCol - endCol);

		// Check if the end spot is adjacent to the start spot
		return rowDiff <= 1 && colDiff <= 1;
	}
}
