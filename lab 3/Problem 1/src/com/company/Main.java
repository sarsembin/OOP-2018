package com.company;
class Animal{
    private double mass;
    private int legs;
    public Animal(){
        mass = 0;
        legs = -1;
    }
    public Animal(double mass, int legs){
        this.mass = mass;
        this.legs = legs;
    }
    public double jump_height(){
        return legs/ mass;
    }
    public int getLegs(){
        return legs;
    }

    public double getMass() {
        return mass;
    }
}
class Cat extends Animal{
    private String fur_color;
    public Cat(){
        super();
        fur_color = "not_defined";
    }
    public Cat(double mass, int legs, String color){
        super(mass, legs);
        fur_color = color;
    }

    @Override
    public double jump_height() {
        return (getLegs()/ getMass()) * 1.5;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
