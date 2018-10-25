package com.company;

import java.util.Date;

class Employee extends Person implements Comparable, Clonable{
    private double salary;
    private Date hireDate;
    private String insuranceNumber;
    public Employee(){
        super();
        salary = 0;
        hireDate = null;
        insuranceNumber = "no_num";
    }
    public Employee(String name, double salary, Date hireDate, String insuranceNumber){
        super(name);
        this.salary = salary;
        this.hireDate = hireDate;
        this.insuranceNumber = insuranceNumber;
    }
    public double getSalary() {
        return salary;
    }
    public Date getHireDate() {
        return hireDate;
    }
    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    @Override
    public boolean compare(Object obj) {
        Employee e = (Employee) obj;
        if (e.getSalary() < this.salary) return true;
        else return false;
    }

    @Override
    public Employee clone_this() {
        return this;
    }

    @Override
    public String toString() {
        return getName() + getSalary() + getHireDate() + getInsuranceNumber();
    }
    public boolean equals(Object employee) {
        Employee e = (Employee) employee;
        if (this == e) {
            return true;
        }
        else return false;
    }
}