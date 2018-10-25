package com.company;

public class Student extends Person{
    private int id;
    private int GPA;
    public Student(String name, int age, int id, int GPA){
        super(name, age);
        this.id = id;
        this.GPA = GPA;
    }

    @Override
    public String getName() {
        System.out.print("Student name: " + super.getName());
        return super.getName();
    }
}
