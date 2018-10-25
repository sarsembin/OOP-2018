package com.company;

public class Cube implements Shapes3D {
    protected double dim;
    public Cube(){
        dim = 0;
    }
    public Cube(double dim){
        this.dim = dim;
    }

    @Override
    public double volume() {
        return (dim*dim*dim);
    }

    @Override
    public double surfaceArea() {
        return (dim*dim) * 6;
    }
}
