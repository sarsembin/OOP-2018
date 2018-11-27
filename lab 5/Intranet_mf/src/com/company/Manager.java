package com.company;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Manager extends Employee implements Serializable {

    public Manager(String name, String surname, String id, String password, AccessRights accessRights, double salary) {
        super(name, surname, id, password, accessRights, salary);
    }

    public void addCourse() {
        String id;
        String name;
        int credits;
        Course course;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write course id: ");
        id = scanner.next();

        while(Storage.courses.containsKey(id)){
            System.out.println("Course is already exist");
            System.out.println("Write course id");
            id = scanner.next();
        }

        System.out.println("Write course name: ");
        name = scanner.next();

        System.out.println("Write course credits: ");
        credits = scanner.nextInt();

        course = new Course(id, name, credits);

        Storage.courses.put(id, course);


        HashMap<String,Teacher> teachersMP = Storage.teachers;
        if(teachersMP.isEmpty())
        {
            System.out.println("There is no teachers\n");
            return;
        }
        Iterator it = teachersMP.entrySet().iterator();
        Teacher user;
        int pos = 1;
        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            id = (String)pair.getKey();
            user = teachersMP.get(id);
            System.out.println(String.format("[%d] - ID: %s; %s: %s %s", pos++, id, user.getAccessRights(), user.getName(), user.getSurname()));
        }

        System.out.println("Please, choose the Teacher");
        int choice = scanner.nextInt();
        while(choice<1 || choice>pos){
            System.out.println("Wrong input format");
            choice = scanner.nextInt();
        }

        Iterator it1 = teachersMP.entrySet().iterator();
        int ps = 0;
        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it1.next();
            id = (String)pair.getKey();
            user = teachersMP.get(id);
            if(ps==choice-1){
                course.addTeacher(user);
            }
            ps++;
        }

    }

    public void removeCourse() {
        viewCourses();

        System.out.println("Enter course id");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        while (!Storage.courses.containsKey(id)){
            System.out.println("Course didn't found, try again");
            System.out.println("Enter courses id");
            id = scanner.next();
        }

        if(Storage.courses.containsKey(id))
        {
            Storage.courses.remove(id);
        }
    }

    public void viewCourses() {
        if(Storage.courses.isEmpty())
        {
            System.out.println("There are no courses\n");
            return;
        }
        HashMap<String,Course> mc = Storage.courses;
        Iterator it = mc.entrySet().iterator();
        Course course;
        String id;
        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            id = (String)pair.getKey();
            course = mc.get(id);
            System.out.println(course);
        }
    }

    public void viewTeachers() {
        HashMap<String,Teacher> mt = Storage.teachers;
        if(mt.isEmpty())
        {
            System.out.println("There are no teachers\n");
            return;
        }
        Iterator it = mt.entrySet().iterator();
        Teacher teacher;
        String id;
        int pos = 1;
        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            id = (String)pair.getKey();
            teacher = mt.get(id);
            System.out.println(String.format("[%d] - ID: %s; %s: %s %s", pos++, id, teacher.getAccessRights(), teacher.getName(), teacher.getSurname()));
        }
    }

    public void viewStudents() {
        HashMap<String,Student> ms = Storage.students;
        if(ms.isEmpty())
        {
            System.out.println("There is no students\n");
            return;
        }
        Iterator it = ms.entrySet().iterator();
        Student student;
        String id;
        int pos = 1;
        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            id = (String)pair.getKey();
            student = ms.get(id);
            System.out.println(String.format("[%d] - ID: %s; %s: %s %s", pos++, id, student.getAccessRights(), student.getName(), student.getSurname()));
        }
    }

    public void addTeacherToCourse() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, Select The course");
        if(Storage.courses.isEmpty())
        {
            System.out.println("There is no any courses\n");
            return;
        }
        HashMap<String,Course> mc = Storage.courses;
        Iterator itt = mc.entrySet().iterator();
        Course course;
        String idd;
        while (itt.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)itt.next();
            idd = (String)pair.getKey();
            course = mc.get(idd);
            System.out.println(course);
        }
        System.out.println("Enter id of the course");
        String s = scanner.next();
        while(!Storage.courses.containsKey(s)){
            System.out.println("Please, enter CORRECT id of the course!");
            s = scanner.next();
        }
        course = Storage.courses.get(s);

        //razdelenie
        System.out.println("Please, Select the Teacher");
        HashMap<String,Teacher> mp = Storage.teachers;
        if(mp.isEmpty()){
            System.out.println("There is no teachers\n");
            return;
        }
        Iterator it = mp.entrySet().iterator();
        Teacher teacher;
        String id;
        int pos = 1;
        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            id = (String)pair.getKey();
            teacher = mp.get(id);
            System.out.println(String.format("[%d] - ID: %s; %s: %s %s", pos++, id, teacher.getAccessRights(), teacher.getName(), teacher.getSurname()));
        }

        int choice = scanner.nextInt();
        while(choice<0 || choice>pos){
            System.out.println("Wrong input format");
            choice = scanner.nextInt();
        }
        Iterator it1 = mp.entrySet().iterator();
        int ps = 1;
        String id1;
        while(it1.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it1.next();
            id1 = (String)pair.getKey();
            if(ps++==choice){
                teacher = mp.get(id1);
                course.addTeacher(teacher);
            }
        }
    }


    public static HashMap<String, Manager> get() throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream OInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Daur\\Desktop\\oop\\lab 5\\Intranet_mf\\src\\com\\company\\Files\\Managers.out"));
            HashMap<String, Manager> managers = (HashMap<String, Manager>) OInputStream.readObject();
            OInputStream.close();
            return managers;
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            return new HashMap<String, Manager>();
        }
    }

    public static void save(HashMap<String, Manager> managers) throws IOException{
        try{
            ObjectOutputStream OOutputStream =  new ObjectOutputStream(new FileOutputStream("C:\\Users\\Daur\\Desktop\\oop\\lab 5\\Intranet_mf\\src\\com\\company\\Files\\Managers.out"));
            OOutputStream.writeObject(managers);
            OOutputStream.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Wrong path");
        }
    }
}
