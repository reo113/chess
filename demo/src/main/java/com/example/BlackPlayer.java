package com.example;

/**
 * 
 * this class represents a player who controls the black pieces in a game of
 * chess.
 */
public class BlackPlayer extends Player {

    private PieceColor pieceColor;

    /**
     * 
     * Creates a new BlackPlayer object with the specified name, pieces color, and
     * turn status.
     * 
     * @param name   the name of the player
     * @param color  the color of the player's pieces
     * @param isTurn true if it's the player's turn, false otherwise
     */
    public BlackPlayer(String name, PieceColor color,
            boolean isTurn) {
        super(name, isTurn);
        pieceColor = color;
    }

    /**
     * 
     * Returns the color of the player's pieces.
     * 
     * @return the color of the player's pieces
     */
    @Override
    public PieceColor getPieceColor() {
        return pieceColor;
    }
}
