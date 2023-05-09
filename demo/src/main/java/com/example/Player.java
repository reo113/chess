package com.example;


public abstract class Player {
    protected String name;
    protected boolean isTurn;

    
    public Player(String name,boolean isTurn)  {
        this.name = name;
        this.isTurn = isTurn;
    }
    public Player(Player player) {
        this.name = player.name;
        this.isTurn = player.isTurn;
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
    public enum PieceColor {
            WHITE,
            BLACK
          }
        
    public abstract PieceColor getPieceColor();
}


// public class Player {
//     private String name;
//     private PieceColor pieceColor;
//     private boolean isTurn;

//     public Player(String name, PieceColor pieceColor, boolean isTurn) {
//         this.name = name;
//         this.pieceColor = pieceColor;
//         this.isTurn = false;
//     }

//     public enum PieceColor {
//         WHITE,
//         BLACK
//     }

//     public String getName() {
//         return name;
//     }

//     public PieceColor getPieceColor() {
//         return pieceColor;
//     }
//     public void settPieceColor(PieceColor pieceColor) {
//         this.pieceColor =pieceColor;
//     }
//     public boolean isWhite() {
//         return pieceColor == PieceColor.WHITE;
//     }

//     public boolean isBlack() {
//         return pieceColor == PieceColor.BLACK;
//     }
//     public boolean isTurn() {
//         return isTurn;
//     }

//     public void setTurn(boolean isTurn) {
//         this.isTurn = isTurn;
//     }

//     public void changeTurn() {
//         isTurn = !isTurn;
//     }
   
// }
