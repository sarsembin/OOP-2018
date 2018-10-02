package com.company;

import java.util.ArrayList;
import java.util.List;

class Person{
    private String name;
    public Person(){
        name = "no_name";
    }
    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
    public boolean equals(String name) {
        if (name.equals(this.name)) return true;
        else return false;
    }
}
class Employee extends Person{
    private double salary;
    private int year;
    private String insuranceNumber;
    public Employee(){
        super();
        salary = 0;
        year = 0;
        insuranceNumber = "no_num";
    }
    public Employee(String name, double salary, int year, String insuranceNumber){
        super(name);
        this.salary = salary;
        this.year = year;
        this.insuranceNumber = insuranceNumber;
    }
    public double getSalary() {
        return salary;
    }
    public int getYear() {
        return year;
    }
    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    @Override
    public String toString() {
        return getName() + getSalary() + getYear() + getInsuranceNumber();
    }
    public boolean equals(String name, double salary, int year, String insuranceNumber) {
        if (getName().equals(name) && this.salary == salary && this.year == year && this.insuranceNumber.equals(insuranceNumber)) {
            return true;
        }
        else return false;
    }
}
class Manager extends Employee{
    private List<Employee> team;
    private double bonus;
    public Manager(){
        super();
        team = new ArrayList<>();
        bonus = 0;
    }
    public Manager(List<Employee> team){
        super();
        this.team = team;
        bonus = team.size();
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
