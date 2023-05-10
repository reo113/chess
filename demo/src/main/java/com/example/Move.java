package com.example;

  
    public class Move {

        private Spot start;
        private Spot end;
        private boolean castlingMove = false;
    
        public Move(Spot start, Spot end) {
            this.start = start;
            this.end = end;

        }
    
        public Move(Spot start, Spot end, boolean isCastlingMove) {
            this(start, end);
            this.castlingMove = isCastlingMove;
        }
    
        public Spot getStart() {
            return start;
        }
    
        public Spot getEnd() {
            return end;
        }
  
        public boolean isCastlingMove() {
            return castlingMove;
        }
    }
    

