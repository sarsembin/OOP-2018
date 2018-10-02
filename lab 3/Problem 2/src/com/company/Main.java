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
    public Cylinder(){
        super();
        radius = 0;
    }
    public Cylinder(double radius, double heigth){
        super(radius*2, radius*2, heigth);
        this.radius = radius;
    }
    public double findVolume(){
        return getHeigth() * ( ((radius * radius) * 3.14 ) );
    }
    public double findSurfaceArea(){
        return 2 * 3.14 * (radius) * getHeigth();
    }
}
class Sphere extends Shapes3D{
    private double radius;
    public Sphere(){
        super();
        radius = 0;
    }
    public Sphere(double radius){
        super(radius*2, radius*2, radius*2);
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
    public Cube(){
        super();
    }
    public Cube(double length){
        super(length, length, length);
    }
    public double findVolume(){
        return getLength()* getLength()* getLength();
    }
    public double findSurfaceArea(){
        return getLength() * getLength() * 6;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
