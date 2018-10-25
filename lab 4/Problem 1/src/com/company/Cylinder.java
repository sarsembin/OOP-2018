package com.company;

public class Cylinder implements Shapes3D {
    protected double height;
    protected double radius;
    public Cylinder(){
        height = 0;
        radius = 0;
    }
    public Cylinder(double height, double radius){
        this. height = height;
        this.radius = radius;
    }

    @Override
    public double volume() {
        return 3.14 * height * (radius*radius);
    }

    @Override
    public double surfaceArea() {
        return 2 * 3.14 * radius * (radius + height);
    }
}