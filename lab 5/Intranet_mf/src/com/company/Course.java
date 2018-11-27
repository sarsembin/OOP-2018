package com.company;

import java.io.*;
import java.util.Vector;
import java.util.HashMap;

public class Course {
    private int credits;
    private String id;
    private String name;
    private int yearOfStudy;
    private Vector<CourseFile> courseFiles;
    private Vector<Teacher> teachers;

    public Course(String id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        courseFiles = new Vector<CourseFile>();
        teachers = new Vector<Teacher>();
    }

    public Vector<CourseFile> getCourseFiles() {
        return courseFiles;
    }

    public void addTeacher(Teacher t)
    {
        teachers.add(t);
    }
    public void addCourseFile(CourseFile courseFile)
    {
        courseFiles.add(courseFile);
    }
    public Vector<Teacher> getTeachers() {
        return teachers;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String toString()
    {
        return "ID: " + id + " ," + name + " ,Credits: " + credits + "";
    }

    // deserialization
    public static HashMap<String, Course> get() throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream OInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Daur\\Desktop\\oop\\lab 5\\Intranet_mf\\src\\com\\company\\Files\\Courses.out"));
            HashMap<String, Course> courses = (HashMap<String, Course>) OInputStream.readObject();
            OInputStream.close();
            return courses;
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            return new HashMap<String, Course>();
        }
    }
    // serialization
    public static void save(HashMap<String, Course> courses) throws IOException{
        try{
            ObjectOutputStream OOutputStream =  new ObjectOutputStream(new FileOutputStream("C:\\Users\\Daur\\Desktop\\oop\\lab 5\\Intranet_mf\\src\\com\\company\\Files\\Courses.out"));
            OOutputStream.writeObject(courses);
            OOutputStream.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Wrong path");
        }
    }

}
