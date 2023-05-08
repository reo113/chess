package com.example;

import java.util.ArrayList;

import com.example.Player.PieceColor;

public class Rook extends Piece {

	Rook(PieceColor isWhite) {
		super(isWhite);
	
	}

	@Override
    public ArrayList<Move> legalMoves(ChessBoard board, Spot start) {
        // ArrayList<Move> legalMoves = new ArrayList<>();
        // int x = start.getRow();
        // int y = start.getColumn();

        // // Check horizontally to the right
        // for (int i = x + 1; i < 8; i++) {
        //     Spot end = board.getSpot(i, y);
        //     if (!end.isSpotOccupied()) {
        //         legalMoves.add(new Move(start, end));
        //     } else {
        //         if (end.getPiece().getColor() != this.getColor()) {
        //             legalMoves.add(new Move(start, end));
        //         }
        //         break;
        //     }
        // }

        // // Check horizontally to the left
        // for (int i = x - 1; i >= 0; i--) {
        //     Spot end = board.getSpot(i, y);
        //     if (!end.isSpotOccupied()) {
        //         legalMoves.add(new Move(start, end));
        //     } else {
        //         if (end.getPiece().getColor() != this.getColor()) {
        //             legalMoves.add(new Move(start, end));
        //         }
        //         break;
        //     }
        // }

        // // Check vertically upwards
        // for (int i = y - 1; i >= 0; i--) {
        //     Spot end = board.getSpot(x, i);
        //     if (!end.isSpotOccupied()) {
        //         legalMoves.add(new Move(start, end));
        //     } else {
        //         if (end.getPiece().getColor() != this.getColor()) {
        //             legalMoves.add(new Move(start, end));
        //         }
        //         break;
        //     }
        // }

        // // Check vertically downwards
        // for (int i = y + 1; i < 8; i++) {
        //     Spot end = board.getSpot(x, i);
        //     if (!end.isSpotOccupied()) {
        //         legalMoves.add(new Move(start, end));
        //     } else {
        //         if (end.getPiece().getColor() != this.getColor()) {
        //             legalMoves.add(new Move(start, end));
        //         }
        //         break;
        //     }
        // }

        // return legalMoves;
		ArrayList<Move> moves = new ArrayList<Move>();
        int currentRow = start.getRow();
        int currentCol = start.getColumn();

        // Add all possible moves in the same row
        for (int col = 0; col < 8; col++) {
            if (col != currentCol) {
                Spot end = board.getSpot(currentRow, col);
                Move move = new Move(start, end);
                moves.add(move);
            }
        }

        // Add all possible moves in the same column
        for (int row = 0; row < 8; row++) {
            if (row != currentRow) {
                Spot end = board.getSpot(row, currentCol);
                Move move = new Move(start, end);
                moves.add(move);
            }
        }

        return moves;
    }

    @Override
    public boolean canMove(ChessBoard board, Spot start, Spot end) {
        if (end.isSpotOccupied() && end.getPiece().getColor() == getColor()) {
            return false;
        }
		int startRow = start.getRow();
        int startCol = start.getColumn();
        int endRow = end.getRow();
        int endCol = end.getColumn();

        // Check if the end spot is in the same row or column as the start spot
        if (startRow == endRow) {
            // Check if there are any pieces in the way of the horizontal move
            int minCol = Math.min(startCol, endCol);
            int maxCol = Math.max(startCol, endCol);
            for (int col = minCol + 1; col < maxCol; col++) {
                Spot intermediateSpot = board.getSpot(startRow, col);
                if (intermediateSpot.isSpotOccupied() && intermediateSpot.getPiece().getColor() == getColor()) {
                    return false;
                }
            }
            return true;
        } else if (startCol == endCol) {
            // Check if there are any pieces in the way of the vertical move
            int minRow = Math.min(startRow, endRow);
            int maxRow = Math.max(startRow, endRow);
            for (int row = minRow + 1; row < maxRow; row++) {
                Spot intermediateSpot = board.getSpot(row, startCol);
                if (intermediateSpot.isSpotOccupied()&& intermediateSpot.getPiece().getColor() == getColor()) {
                    return false;
                }
            }
            return true;
        } else {
            // The end spot is neither in the same row nor column as the start spot
            return false;
        }
    }
 
    }
    

