package com.example;

public class WhitePlayer implements Player {
    protected String name;
    protected boolean isTurn;

    public WhitePlayer(String name, boolean isTurn) {
        this.name = name;
        this.isTurn = isTurn;
    }

    public String getName() {
        return name;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    public void changeTurn() {
        isTurn = !isTurn;
    }

    public PieceColor getPieceColor() {
        return PieceColor.WHITE;
    }
}