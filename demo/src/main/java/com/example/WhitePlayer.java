package com.example;

public class WhitePlayer extends Player {
    private PieceColor pieceColor;

    public WhitePlayer(String name, PieceColor color,boolean isTurn) {
        super(name, isTurn);
        pieceColor = color;
    }

    @Override
    public PieceColor getPieceColor() {
        return pieceColor;
    }
}