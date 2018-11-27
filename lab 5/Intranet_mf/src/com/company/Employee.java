package com.company;

import java.io.Serializable;

public class  Employee extends Person implements Serializable {
    protected double salary;

    public Employee(){

    }

    public Employee(String name, String surname, String id, String password, AccessRights accessRights, double salary){
        super(name, surname, id, password, accessRights);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
