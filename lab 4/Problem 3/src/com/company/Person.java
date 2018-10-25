package com.company;

public class Person {
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
    public boolean equals(Object name) {
        String s = (String) name;
        if (s.equals(this.name)) return true;
        else return false;
    }
}
