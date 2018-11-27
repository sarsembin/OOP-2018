package com.company;

import java.io.*;
import java.util.HashMap;

public class Storage {
    public static HashMap<String, Person> users = new HashMap<>();
    public static HashMap<String, TechSupport> techSupportGuys = new HashMap<>();
    public static HashMap<String, Teacher> teachers = new HashMap<>();
    public static HashMap<String, Student> students = new HashMap<>();
    public static HashMap<String, Manager> managers = new HashMap<>();
    public static HashMap<String, Admin> admins = new HashMap<>();
    public static HashMap<String, Course> courses = new HashMap<>();


    public static void deserializeAll() throws IOException, ClassNotFoundException
    {
        users = getUsers();
        techSupportGuys = TechSupport.get();
        teachers = Teacher.get();
        students = Student.get();
        managers = Manager.get();
        admins = Admin.get();
        courses = Course.get();
    }

    public static void serializeAll() throws IOException
    {
        saveUsers(users);
        TechSupport.save(techSupportGuys);
        Teacher.save(teachers);
        Student.save(students);
        Manager.save(managers);
        Admin.save(admins);
        Course.save(courses);
    }

    private static void saveUsers(HashMap<String, Person> users) throws IOException{
        try{
            ObjectOutputStream OOutputStream =  new ObjectOutputStream(new FileOutputStream("C:\\Users\\Daur\\Desktop\\oop\\lab 5\\Intranet_mf\\src\\com\\company\\Files\\Users.out"));
            OOutputStream.writeObject(users);
            OOutputStream.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static HashMap<String, Person> getUsers() throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream OInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Daur\\Desktop\\oop\\lab 5\\Intranet_mf\\src\\com\\company\\Files\\Users.out"));
            HashMap<String, Person> users = (HashMap<String, Person>) OInputStream.readObject();
            OInputStream.close();
            return users;
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            return new HashMap<String, Person>();
        }
    }
}
