package com.example;

public interface Move {
  
    public boolean isValidMove(Spot currentSpot, Spot destinationSpot);
    public void makeMove(Spot currentSpot, Spot destinationSpot);
    public void undoMove(Spot currentSpot, Spot destinationSpot);
    
}
