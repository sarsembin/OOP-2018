package com.company;

class Rook extends Piece {
    public Rook(String color){
        super(color);
    }

    @Override
    public boolean isLegalMove(Position a, Position b) {
        if (super.getColor().equals("white")){
            if (a.getX() + 1 == b.getX() && a.getY() == b.getY()) return true;
            else return false;
        }
        else {
            if (a.getX() - 1 == b.getX() && a.getY() == b.getY()) return true;
            else return false;
        }
    }
}
