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
				           // Check if the potential move is legal and does not put the king in check
						   if (end != null && (!end.isSpotOccupied() || end.getPiece().getColor() != color)) {
							// Make the potential move and check if the king is in check
							Spot temp = start;
							canMove(board, start, end);
							if (!isCheck(board, start)) {
								moves.add(new Move(start, end));
							}
							canMove(board, temp, end); // Undo the potential move
						}

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
	public boolean isCheck(ChessBoard board, Spot start) {
	    int kingRow = start.getRow();
	    int kingCol = start.getColumn();

	    // Check if any opposing piece can attack the king
	    for (int row = 0; row < ChessGame.BOARDSIZE ; row++) {
	        for (int col = 0; col <  ChessGame.BOARDSIZE; col++) {
	            Spot spot = board.getSpot(row, col);
	            if (spot.isSpotOccupied() && spot.getPiece().getColor() != getColor()) {
	                //Piece piece = spot.getPiece();
	                ArrayList<Move> legalMoves = legalMoves(board, spot);
	                for (Move move : legalMoves) {
	                    if (move.getEnd().getRow() == kingRow && move.getEnd().getColumn() == kingCol) {
	                        return true; // King is in check
	                    }
	                }
	            }
	        }
	    }

	    return false; // King is not in check
	}
	
	public boolean checkMate(ChessBoard board,Spot start) {
	
		ArrayList<Move> legalMoves = this.legalMoves(board, start);
		
		//returns false if the king is not in check
		if(isCheck(board,start) == false) {
			return  false;
		}
		
		//if the legal moves arrayList is not empty that means the king has a legal move available therefore not in checkMate
		if(!legalMoves.isEmpty()) {
			return false;
		}
		
		//if true it is check mate
		return true;
	}
}
