package com.company;

import java.io.*;
import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Teacher extends Employee implements Serializable {
    private HashMap<Course, Vector<Student>> teacherCourses;

    public Teacher(String name, String surname, String id, String password, AccessRights accessRights, double salary) {
        super(name, surname, id, password, accessRights, salary);
        teacherCourses = new HashMap<Course, Vector<Student>>();
    }



    public void addCourseFiles(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the course");
        //HashMap<Course,Vector<Student> > mp = studentsForTeacher;

        Iterator it = teacherCourses.entrySet().iterator();
        if( teacherCourses.isEmpty() ){
            System.out.println("There no courses found\n");
            return;
        }
        Course course = null;
        String id;
        int pos = 1;
        Vector<Course> coursesFromHash = new Vector<Course>();

        while ( it.hasNext() ){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            course = (Course)pair.getKey();
            coursesFromHash.add(course);
            //id = (String)pair.getKey();
            //course = studentsForTeacher.get(id);
            System.out.println(String.format("[%d] - %s", pos++, course.getName()));
        }
        int choice = scanner.nextInt();
        while(choice < 1  ||  choice > coursesFromHash.size()){
            System.out.println("Wrong input format");
            System.out.println("Try again: ");
            choice = scanner.nextInt();
        }
        course = coursesFromHash.elementAt(choice-1);

        String name;
        System.out.println("Enter the name");
        name = scanner.next();
        System.out.println("Enter the data");
        String data = scanner.nextLine();
        CourseFile cs = new CourseFile(name,data);
        course.addCourseFile(cs);
    }


    public void viewCourses() {
        if(teacherCourses.isEmpty())
        {
            System.out.println("You don't have any courses");
            return;
        }

        System.out.println("Your courses: ");
        Iterator it = teacherCourses.entrySet().iterator();
        Course course;
        int pos = 1;
        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            course = (Course)pair.getKey();
            System.out.println(String.format("[%d] - %s", pos++, course.getName()));
        }
        System.out.println();
    }

    public void viewStudents() {
        if(teacherCourses.isEmpty())
        {
            System.out.println("You don't have any courses");
            return;
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Your courses: ");
        Iterator it = teacherCourses.entrySet().iterator();
        Course course;
        int pos = 1;
        Vector<Course> courseArray = new Vector<Course>();

        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            course = (Course)pair.getKey();
            courseArray.add(course);
            System.out.println(String.format("[%d] - %s", pos++, course.getName()));
        }
        System.out.println("Choose course number: ");
        int choice = in.nextInt();
        while( choice < 1  ||  choice >= courseArray.size()){
            System.out.println("Number is too small or too big\n");
            System.out.println("Choose course number: ");
            choice = in.nextInt();
        }
        course = courseArray.elementAt(choice-1);

        if(teacherCourses.get(course).isEmpty())
        {
            System.out.println("You don't have any students on this course");
            return;
        }

        System.out.format("Students for %s course:\n", course.getName());
        for(int i=0; i<teacherCourses.get(course).size(); i++) {
            System.out.format("[%d] - %s\n", i+1, teacherCourses.get(course).elementAt(i));
        }

        System.out.println();

    }

    public void putMark() {
        if(teacherCourses.isEmpty())
        {
            System.out.println("You don't have any courses");
            return;
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Your courses: ");
        Iterator it = teacherCourses.entrySet().iterator();
        Course course;
        int pos = 1;
        Vector<Course> courseArray = new Vector<Course>();

        while ( it.hasNext() ){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            course = (Course)pair.getKey();
            courseArray.add(course);
            System.out.println(String.format("[%d] - %s", pos++, course.getName()));
        }
        System.out.println("Choose course number: ");
        int choice = in.nextInt();
        while(choice < 1  ||  choice >= courseArray.size()){
            System.out.println("Number is too small or too big\n");
            System.out.println("Choose course's number: ");
            choice = in.nextInt();
        }
        course = courseArray.elementAt(choice-1);

        if(teacherCourses.get(course).isEmpty())
        {
            System.out.println("You don't have any students on this course");
            return;
        }

        System.out.format("Your students for %s course:\n", course.getName());
        for(int i=0; i<teacherCourses.get(course).size(); i++) {
            System.out.format("[%d] - %s\n", i+1, teacherCourses.get(course).elementAt(i));
        }

        System.out.println("Choose student number:");
        choice = in.nextInt();
        while(choice < 1  ||  choice >= teacherCourses.get(course).size()){
            System.out.println("Number is too small or too big\n");
            System.out.println("Choose course number: ");
            choice = in.nextInt();
        }
        Student student = teacherCourses.get(course).elementAt(choice-1);
        System.out.println("Put your mark: ");
        choice = in.nextInt();
        student.addMark(course, choice);
    }

    public void sendOrder() {
        Scanner scanner = new Scanner(System.in);
        String title;
        String text;
        String from;
        System.out.println("Write title for your order:");
        title = scanner.nextLine();

        System.out.println("Choose the reciever:");
        HashMap<String,TechSupport> techSupportMP = Storage.techSupportGuys;
        if(techSupportMP.isEmpty()){
            System.out.println("There is no TechSupports");
            return;
        }
        Iterator it = techSupportMP.entrySet().iterator();
        TechSupport techSupport = null;
        String id;
        int pos = 1;
        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            id = (String)pair.getKey();
            techSupport = techSupportMP.get(id);
            System.out.println(String.format("[%d] - ID: %s; %s: %s %s", pos++, id, techSupport.getAccessRights(), techSupport.getName(), techSupport.getSurname()));
        }

        System.out.println("Please,choose TechSupport's");
        int choice = scanner.nextInt();
        while (choice>pos || choice <1){
            System.out.println("Wrong input format,/nChoose another number:");
            choice = scanner.nextInt();
        }

        Iterator myit = techSupportMP.entrySet().iterator();
        String myid;
        int mypos = 1;
        while (myit.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)myit.next();
            if(mypos==choice){
                myid = (String)pair.getKey();
                techSupport = techSupportMP.get(myid);
            }
            mypos++;
        }

        System.out.println("Write the text:\n");
        text = scanner.nextLine();

        Order order = new Order(title,text);
        techSupport.addOrder(order);

    }

    public static HashMap<String, Teacher> get() throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream OInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Daur\\Desktop\\oop\\lab 5\\Intranet_mf\\src\\com\\company\\Files\\Teachers.out"));
            HashMap<String, Teacher> teachers = (HashMap<String, Teacher>) OInputStream.readObject();
            OInputStream.close();
            return teachers;
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            return new HashMap<String, Teacher>();
        }
    }

    public static void save(HashMap<String, Teacher> teachers) throws IOException{
        try{
            ObjectOutputStream OOutputStream =  new ObjectOutputStream(new FileOutputStream("C:\\Users\\Daur\\Desktop\\oop\\lab 5\\Intranet_mf\\src\\com\\company\\Files\\Teachers.out"));
            OOutputStream.writeObject(teachers);
            OOutputStream.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Wrong path");
        }
    }

}
