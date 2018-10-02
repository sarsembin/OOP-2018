package com.company;
abstract class Shapes3D{
    private double length;
    private double width;
    private double heigth;
    public Shapes3D(){
        length = 0;
        width = 0;
        heigth = 0;
    }
    public Shapes3D(double length, double width, double heigth){
        this.length = length;
        this.width = width;
        this.heigth = heigth;
    }
    public double getHeigth() {
        return heigth;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
    public abstract double findVolume();
    public abstract double findSurfaceArea();
}
class Cylinder extends Shapes3D{
    private double radius;
    private double heigth;
    public Cylinder(){
        radius = 0;
    }
    public Cylinder(double radius, double heigth){
        this.radius = radius;
        this.heigth = heigth;
    }
    public double findVolume(){
        return heigth * ( ((radius * radius) * 3.14 ) );
    }
    public double findSurfaceArea(){
        return 2 * 3.14 * (radius) * heigth;
    }
}
class Sphere extends Shapes3D{
    private double radius;
    public Sphere(){
        radius = 0;
    }
    public Sphere(double radius){
        this.radius = radius;
    }
    public double findVolume(){
        return (4/3) * 3.14 * radius*radius*radius;
    }
    public double findSurfaceArea(){
        return 4 * 3.14 * radius * radius;
    }
}
class Cube extends Shapes3D{
    private double length;
    public Cube(){
        this.length = 0;
    }
    public Cube(double length){
        this.length = length;
    }
    public double findVolume(){
        return length*length*length;
    }
    public double findSurfaceArea(){
        return length * length * 6;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
