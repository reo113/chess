package com.example;

/**
 * 
 * this class represents a player who controls the black pieces in a game of
 * chess.
 */
public class BlackPlayer implements Player {
    
    protected String name;
    protected boolean isTurn;
    
    public BlackPlayer(String name, boolean isTurn) {
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
        return PieceColor.BLACK;
    }
}