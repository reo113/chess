package com.example;

import java.util.ArrayList;

import com.example.Player.PieceColor;

public abstract class Piece {

	protected PieceColor color;


	public Piece(PieceColor color) {
		this.color = color;
	}

	public abstract ArrayList<Move> legalMoves(ChessBoard board, Spot start);

	public abstract boolean canMove(ChessBoard board, Spot start, Spot end);


	public PieceColor getColor() {
		return color;
	}

	public void setColor(PieceColor color) {
		this.color = color;
	}

	public String getImageName() {
		String colorString = color == PieceColor.WHITE ? "white" : "black";
		//System.out.println(colorString + getClass().getSimpleName());
		return colorString + getClass().getSimpleName();
	}


	

}
