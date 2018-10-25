package com.company;

public class Main {
    public static void printInfo(Person p){
        System.out.println(p.getName());
    }
    public static void main(String[] args) {
        Student studentObject = new Student("daur", 18, 123, 3);
        Employee employeeObject = new Employee("doner", 25, 321);
        Person ref = studentObject;
        String temp = ref.getName();
        System.out.print(temp); // student call
        ref = employeeObject;
        System.out.print(temp); // employee call

        printInfo(studentObject);
        printInfo(employeeObject);
    }
}
