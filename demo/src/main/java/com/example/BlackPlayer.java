package com.example;

public class BlackPlayer extends Player {

    private PieceColor pieceColor;

    public BlackPlayer(String name,PieceColor color,
    boolean isTurn) {
            super(name,isTurn);
            pieceColor = color;
        }
   
    @Override
    public PieceColor getPieceColor() {
        return pieceColor;
    }
}
