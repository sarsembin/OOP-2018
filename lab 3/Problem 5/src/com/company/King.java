package com.company;

class King extends Piece {
    public King(String color){
        super(color);
    }

    @Override
    public boolean isLegalMove(Position a, Position b) {
        if (super.getColor().equals("white")){
            // x
            if (a.getX() == b.getX() - 1 && a.getX() == b.getX()) return true;
            else if (a.getX() == b.getX() + 1 && a.getX() == b.getX()) return true;
            // naiskos
            else if (a.getX() == b.getX() - 1 && a.getX() == b.getX() - 1) return true;
            else if (a.getX() == b.getX() - 1 && a.getX() == b.getX() + 1) return true;
            else if (a.getX() == b.getX() + 1 && a.getX() == b.getX() - 1) return true;
            else if (a.getX() == b.getX() + 1 && a.getX() == b.getX() + 1) return true;
            // y
            else if (a.getX() == b.getX() && a.getX() == b.getX() + 1) return true;
            else if (a.getX() == b.getX() && a.getX() == b.getX() - 1) return true;
            else {
                return false;
            }
        }
        else {
            // x
            if (a.getX() == b.getX() - 1 && a.getX() == b.getX()) return true;
            else if (a.getX() == b.getX() + 1 && a.getX() == b.getX()) return true;
                // naiskos
            else if (a.getX() == b.getX() - 1 && a.getX() == b.getX() - 1) return true;
            else if (a.getX() == b.getX() - 1 && a.getX() == b.getX() + 1) return true;
            else if (a.getX() == b.getX() + 1 && a.getX() == b.getX() - 1) return true;
            else if (a.getX() == b.getX() + 1 && a.getX() == b.getX() + 1) return true;
                // y
            else if (a.getX() == b.getX() && a.getX() == b.getX() + 1) return true;
            else if (a.getX() == b.getX() && a.getX() == b.getX() - 1) return true;
            else {
                return false;
            }
        }
    }
}
