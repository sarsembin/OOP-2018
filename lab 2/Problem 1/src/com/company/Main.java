package com.company;
class Student{
    private String name;
    private int id;
    private int year_of_study;
    public Student(int id_, String name_){
        id = id_;
        name = name_;
    }
    public void SetName(String name_){
        name = name_;
    }
    public void SetId(int id_){
        id = id_;
    }
    public void SetYear(int year_){
        year_of_study = year_;
    }
    public void GetName(){
        System.out.print(name + "\n");
    }
    public void GetId(){
        System.out.print(id + "\n");
    }
    public void GetYear(){
        System.out.print(year_of_study + "\n");
    }
    public void incrementYear(){
        year_of_study++;
    }
}
public class Main {

    public static void main(String[] args) {
        Student student = new Student(500, "Dauren");
        student.SetYear(2017);
        student.GetYear();
        student.SetName("Dodo");
        student.GetName();
        student.incrementYear();
        student.incrementYear();
        student.GetYear();
    }
}
