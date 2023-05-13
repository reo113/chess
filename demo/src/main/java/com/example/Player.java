package com.example;

/**
 * 
 * Player class represents a player in a chess game.
 * 
 * tt is an abstract class that can be extended to create different types of
 * players.
 */
public interface Player {

    /**
     * 
     * gets the name of the player.
     * 
     * @return The name of the player.
     */
    public String getName();

    /**
     * 
     * gets a value indicating whether it's the player's turn or not.
     * 
     * @return true if it's the player's turn, otherwise false.
     */
    public boolean isTurn();

    /**
     * 
     * sets a value indicating whether it's the player's turn or not.
     * 
     * @param isTurn true if it's the player's turn, otherwise false.
     */
    public void setTurn(boolean isTurn);
    /**
     * 
     * changes the turn of the player.
     */
    public void changeTurn();

    /**
     * 
     * an enum representing the color of the player's pieces.
     */
    public enum PieceColor {
        WHITE,
        BLACK
    }

    /**
     * 
     * gets the color of the player's pieces.
     * 
     * @return The color of the player's pieces.
     */
    public PieceColor getPieceColor();
}
