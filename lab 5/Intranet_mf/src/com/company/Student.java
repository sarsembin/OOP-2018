package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
import javafx.util.Pair;

public class Student extends Person implements Serializable {

    private int yearOfStudy;
    private HashMap<Course, Vector<Integer>> marks;
    private HashMap<Course, Teacher> courses;


    public Student(String name, String surname, String id, String password, AccessRights accessRights, int yearOfStudy) {
        super(name, surname, id, password, accessRights);
        this.yearOfStudy = yearOfStudy;
        marks = new HashMap<Course, Vector<Integer>>();
    }

    public void addMark(Course course, int mark) {
        marks.get(course).add(mark);
    }
    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void registerCourse() {
        Course course;
        Teacher teacher;
        int pos = 1;

        HashMap<String,Course> myCourses = Storage.courses;
        if(myCourses.isEmpty())
        {
            System.out.println("There is no available courses\n");
            return;
        }
        Iterator it = myCourses.entrySet().iterator();
        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            String id = (String)pair.getKey();
            course = myCourses.get(id);
            if(course.getYearOfStudy() == this.getYearOfStudy())
            {
                System.out.println(String.format("[%d] - ID: %s; %s, %d credits", pos++, id, course.getName(), course.getCredits()));
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter course's id: ");
        String id = scanner.next();
        while (!myCourses.containsKey(id)){
            System.out.println("Course didn't found, try again");
            System.out.println("Please, enter course's id: ");
            id = scanner.next();
        }

        System.out.println();

        course = myCourses.get(id);
        pos = 1;

        System.out.println("Teachers on course: ");
        for(Teacher t: course.getTeachers()) {
            System.out.println(String.format("[%d] - %s %s", pos++, t.getName(), t.getSurname()));
        }
        System.out.println("Please, enter the number of chosen teacher: ");
        int choice = scanner.nextInt();
        while (!(choice >= 1 && choice < pos)){
            System.out.println("Number is too small, or too big try again\n");
            System.out.println("Please, enter number of chosen teacher: ");
            choice = scanner.nextInt();
        }
        teacher = course.getTeachers().elementAt(choice);

        courses.put(course, teacher);
        marks.put(course, new Vector<>());
    }

    public void dropCourse(){
        if(courses.isEmpty())
        {
            System.out.println("You don't have registered courses!\n");
            return;
        }
        Iterator it = courses.entrySet().iterator();
        int pos = 1;
        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            Course course = (Course)pair.getKey();
            System.out.println(String.format("[%d] - ID: %s; %s, %d credits", pos++, course.getId(), course.getName(), course.getCredits()));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter course's id from the list above: ");
        String id = scanner.next();
        while (!courses.containsKey(id)){
            System.out.println("Course didn't found, try again");
            System.out.println("Please, enter course's id from the list above: ");
            id = scanner.next();
        }

        courses.remove(Storage.courses.get(id));
        marks.remove(Storage.courses.get(id));

        System.out.println(String.format("%s is successfully removed", Storage.courses.get(id).getName()));
        System.out.println();
    }

    public void viewMarks() {
        Course course;
        int pos = 1;

        if(marks.isEmpty())
        {
            System.out.println("There is no available courses\n");
            return;
        }
        Iterator it = marks.entrySet().iterator();
        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            course = (Course) pair.getKey();
            System.out.println(String.format("[%d] - ID: %s; %s, %d credits", pos++, course.getId(), course.getName(), course.getCredits()));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter course's id: ");
        String id = scanner.next();
        course = Storage.courses.get(id);
        while (!marks.containsKey(course)){
            System.out.println("Course didn't found, try again");
            System.out.println("Please, enter course's id: ");
            id = scanner.next();
            course = Storage.courses.get(id);
        }


        System.out.print(String.format("ID: %s - %s: ", course.getId(), course.getName()));
        Vector<Integer> m = marks.get(course);
        for(int i=0; i<m.size(); i++) {
            System.out.print(m.elementAt(i) + ", ");
        }
        System.out.println("\n");
    }

    private Pair<String, Double> getMark(Course course){
        Vector<Integer> vector = marks.get(course);
        int totalPoint = 0;
        for(int i = 0;i<vector.size();++i){
            totalPoint+=vector.elementAt(i);
        }
        String mark = null;
        Double GPA = 0.0;
        if(totalPoint >= 95){
            mark = "A";
            GPA = 4.00;
        }else if(totalPoint >= 90){
            mark = "A-";
            GPA = 3.67;
        }else if(totalPoint >= 85){
            mark = "B+";
            GPA = 3.33;
        }else if(totalPoint >= 80){
            mark = "B";
            GPA = 3.00;
        }else if(totalPoint >= 75){
            mark = "B-";
            GPA = 2.67;
        }else if(totalPoint >= 70){
            mark = "C++";
            GPA = 2.33;
        }else if(totalPoint >= 65){
            mark = "C";
            GPA = 2.00;
        }else if(totalPoint >= 60){
            mark = "C-";
            GPA = 1.67;
        }else if(totalPoint >= 55){
            mark = "D";
            GPA = 1.33;
        }else { mark = "F";
            GPA = 0.0;}

        return new Pair<String, Double>(mark, GPA);
    }


    public void viewFiles() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,Course> mp = Storage.courses;
        if(mp.isEmpty()){
            System.out.println("There is no courses yet\n");
            return;
        }
        Iterator it = mp.entrySet().iterator();
        Course course = null;
        String id;
        int pos = 1;
        int isHere = 1;
        Vector<CourseFile> idOfCourses = new Vector<CourseFile>();

        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            id = (String)pair.getKey();
            course = mp.get(id);
            if(courses.containsKey(id)){
                System.out.println(String.format("[%d] - ID: %s; %s", pos++, id,  course.getName()));
                Vector<CourseFile> courseFiles = course.getCourseFiles();
                for(int i = 0;i<courseFiles.size();++i){
                    System.out.println("[" + (isHere++) + "]" + " - " + courseFiles.elementAt(i).getFileName() );
                    idOfCourses.add(courseFiles.elementAt(i));
                }
            }
        }

        System.out.println("Choose file to read");
        int choice = scanner.nextInt();
        while (choice < 0  ||  choice > idOfCourses.size() + 1){
            System.out.println("Number too big or too small");
            System.out.println("Choose file to read");
            choice = scanner.nextInt();
        }
        System.out.println("Text:");
        System.out.println(idOfCourses.elementAt(choice-1).getText());

    }


    public static HashMap<String, Student> get() throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream OInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Daur\\Desktop\\oop\\lab 5\\Intranet_mf\\src\\com\\company\\Files\\Students.out"));
            HashMap<String, Student> students = (HashMap<String, Student>) OInputStream.readObject();
            OInputStream.close();
            return students;
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            return new HashMap<String, Student>();
        }
    }

    public static void save(HashMap<String, Student> Students) throws IOException{
        try{
            ObjectOutputStream OOutputStream =  new ObjectOutputStream(new FileOutputStream("C:\\Users\\Daur\\Desktop\\oop\\lab 5\\Intranet_mf\\src\\com\\company\\Files\\Students.out"));
            OOutputStream.writeObject(Students);
            OOutputStream.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Wrong path");
        }
    }
}
