package com.company;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Cloneable, Comparable, Serializable {
    protected String name;
    protected String surname;
    protected String id;
    protected String password;
    protected AccessRights accessRights;

    public Person(){
        this.name = "no_name";
        this.surname = "no_surname";
    }

    public Person(String name, String surname, String id, String password, AccessRights accessRights){
        this.id = id;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.accessRights = accessRights;
    }

    //getter setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccessRights getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(AccessRights accessRights) {
        this.accessRights = accessRights;
    }
    // getter setter end

    public void changePassword() {
        Scanner in = new Scanner(System.in);
        String oldPassword, newPassword;
        System.out.println("Enter old password:");
        oldPassword = in.next();
        System.out.println("Enter new password:");
        newPassword = in.next();
        if(oldPassword.equals(this.password)) {
            password = newPassword;
            System.out.println("Password is successfully changed!\n");
            //Storage.writeLog(String.format("%s - password is changed", new Date()));

        }
        else {
            System.out.println("Cannot change password, passwords doesn't match");
        }

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = this;
        return p;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        int result = this.name.compareTo(((Person) o).getName());
        if (result == 0) result = this.surname.compareTo(((Person) o).getSurname());
        return result;
    }

    // need serialization
    public String toString(){
        return this.name + " " + this.surname + " " + this.id + " " + this.password + " " + this.accessRights + "";
    }
}