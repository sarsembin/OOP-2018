package com.company;

public class Employee extends Person {
    private int id;
    public Employee(String name, int age, int id){
        super(name, age);
        this.id = id;
    }
    public String getName() {
        System.out.print("Employee name: " + super.getName());
        return super.getName();
    }
}
