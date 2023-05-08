package com.example;

import java.util.ArrayList;

import com.example.Player.PieceColor;

import javafx.scene.image.ImageView;

public class Knight extends Piece {



	Knight(PieceColor isWhite) {
		super(isWhite);
		
	}
	
	@Override
	public ArrayList<Move> legalMoves(ChessBoard board, Spot start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canMove(ChessBoard board, Spot start, Spot end) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'canMove'");
	}

}
