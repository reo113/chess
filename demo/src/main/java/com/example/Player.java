package com.example;

/**
 * 
 * Player class represents a player in a chess game.
 * 
 * tt is an abstract class that can be extended to create different types of
 * players.
 */
public abstract class Player {
    protected String name;
    protected boolean isTurn;

    /**
     * 
     * creates a new instance of the Player class with the specified name and
     * turn.
     * 
     * @param name   The name of the player.
     * @param isTurn Indicates whether it's the player's turn or not.
     */
    public Player(String name, boolean isTurn) {
        this.name = name;
        this.isTurn = isTurn;
    }

    /**
     * 
     * creates a new instance of the Player class with the same properties as
     * the specified player.
     * 
     * @param player The player to copy.
     */
    public Player(Player player) {
        this.name = player.name;
        this.isTurn = player.isTurn;
    }

    /**
     * 
     * gets the name of the player.
     * 
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * gets a value indicating whether it's the player's turn or not.
     * 
     * @return true if it's the player's turn, otherwise false.
     */
    public boolean isTurn() {
        return isTurn;
    }

    /**
     * 
     * sets a value indicating whether it's the player's turn or not.
     * 
     * @param isTurn true if it's the player's turn, otherwise false.
     */
    public void setTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    /**
     * 
     * changes the turn of the player.
     */
    public void changeTurn() {
        isTurn = !isTurn;
    }

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
    public abstract PieceColor getPieceColor();
}
