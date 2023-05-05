package com.example;

import java.util.ArrayList;

public class Pawn extends Piece {

	Pawn(Boolean isKilled, Boolean whitePiece) {
		super(isKilled, whitePiece);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Move> legalMoves(ChessBoard board, Spot start) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getName(Piece piece) {
		String color;
		if(piece.getwhitePiece()){
			color = "white";
		}else{
			color="black";
		}
		return color +"Pawn";
	}
}
