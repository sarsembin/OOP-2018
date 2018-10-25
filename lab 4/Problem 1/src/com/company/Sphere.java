package com.company;

public class Sphere implements Shapes3D {
    protected double radius;
    public Sphere(){
        this.radius = 0;
    }
    public Sphere(double radius){
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    @Override
    public double volume() {
        return (4/3) * 3.14 * (radius*radius*radius);
    }

    @Override
    public double surfaceArea() {
        return 4 * 3.14 * (radius*radius);
    }
}
