package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Driver  {
    public static Scanner in = new Scanner(System.in);

    public static void login() {
        String username, password;
        while(true)
        {
            System.out.println("Username: ");
            username = in.next();
            System.out.println("Password: ");
            password = in.next();
        //fine too  //System.out.println(Storage.users.containsKey(username)+ " " + Storage.users.get(username).getPassword());
            //System.out.println(Storage.users.get(username) + ""); ///// fine
            if(Storage.users.containsKey(username) && Storage.users.get(username).getPassword().equals(password))
            {
                run(Storage.users.get(username)); ///??????????? null pointer exception ????? why

                /*try
                {
                    Storage.serializeAll();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }*/
            }
            else
            {
                System.out.println("Wrong username or password");
            }
        }
    }

    private static void run(Person user) {
        switch (user.getAccessRights())
        {
            case ADMIN:
                runAdmin(user.getID());
                break;
            case STUDENT:
                runStudent(user.getID());
                break;
            case MANAGER:
                runManager(user.getID());
                break;
            case TEACHER:
                runTeacher(user.getID());
                break;
            case TECHSUPPORT:
                runTechSupport(user.getID());
                break;
        }
    }

    private static void runAdmin(String id) {
        while(true)
        {
            Admin admin = Storage.admins.get(id);

            System.out.println(String.format("Welcome, %s %s\n", admin.getName(), admin.getSurname()));
            System.out.println(" 1  - Add user");
            System.out.println(" 2  - Delete user");
            System.out.println(" 3  - Print users");
            System.out.println(" 4  - Change password");
            System.out.println(" 5  - Log out");

            int choice = in.nextInt();
            while(choice < 1  ||  choice > 5){
                System.out.println("Number too small or too big\n");
                System.out.println(" 1  - Add user");
                System.out.println(" 2  - Delete user");
                System.out.println(" 3  - Print users");
                System.out.println(" 4  - Change password");
                System.out.println(" 5  - Log out");
                choice = in.nextInt();
            }

            switch (choice)
            {
                case 1:
                    admin.addUser();
                    break;
                case 2:
                    admin.removeUser();
                    break;
                case 3:
                    admin.printUsers();
                    break;
                case 4:
                    admin.changePassword();
                    Storage.users.put(admin.getID(), admin);
                    Storage.admins.put(admin.getID(), admin);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Number too small or too big\n");
                    break;
            }
        }
    }

    private static void runManager(String id) {
        while(true)
        {
            Manager manager = Storage.managers.get(id);
            System.out.println(String.format("Welcome, %s %s\n", manager.getName(), manager.getSurname()));

            System.out.println(" 1  - Add course");
            System.out.println(" 2  - Delete course");
            System.out.println(" 3  - View courses");
            System.out.println(" 4  - View teachers");
            System.out.println(" 5  - View students");
            System.out.println(" 6  - Add teacher to the course");
            System.out.println(" 7  - Change password");
            System.out.println(" 8  - Log out");

            int choice = in.nextInt();
            while(choice<1 || choice>8){
                System.out.println("Number too small or too big\n");
                System.out.println(" 1  - Add course");
                System.out.println(" 2  - Delete course");
                System.out.println(" 3  - View courses");
                System.out.println(" 4  - View teachers");
                System.out.println(" 5  - View students");
                System.out.println(" 6  - Add teacher to the course");
                System.out.println(" 7  - Change password");
                System.out.println(" 8  - Log out");
                choice = in.nextInt();
            }

            switch (choice)
            {
                case 1:
                    manager.addCourse();
                    break;
                case 2:
                    manager.removeCourse();
                    break;
                case 3:
                    manager.viewCourses();
                    break;
                case 4:
                    manager.viewTeachers();
                    break;
                case 5:
                    manager.viewStudents();
                    break;
                case 6:
                    manager.addTeacherToCourse();
                    break;
                case 7:
                    manager.changePassword();
                    Storage.users.put(manager.getID(), manager);
                    Storage.managers.put(manager.getID(), manager);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Number too small or too big\n");
                    break;
            }
        }
    }

    private static void runTechSupport(String id) {
        while(true)
        {
            TechSupport curTechSup = Storage.techSupportGuys.get(id);
            System.out.println(String.format("Welcome, %s %s\n", curTechSup.getName(), curTechSup.getSurname()));

            System.out.println(" 1  - View all orders");
            System.out.println(" 2  - View done orders");
            System.out.println(" 3  - View undone orders");
            System.out.println(" 4  - Change password");
            System.out.println(" 5  - Log out");

            int choice = in.nextInt();
            while(choice<1 || choice>5){
                System.out.println("Number too small or too big\n");
                System.out.println(" 1  - View all orders");
                System.out.println(" 2  - View done orders");
                System.out.println(" 3  - View undone orders");
                System.out.println(" 4  - Change password");
                System.out.println(" 5  - Log out");
                choice = in.nextInt();
            }

            switch (choice)
            {
                case 1:
                    if(curTechSup.viewAllOrders())
                    {
                        choice = in.nextInt();
                        curTechSup.viewOrder(choice);
                        in.next(".").charAt(0);
                    }
                    break;
                case 2:
                    if(curTechSup.viewDoneOrders())
                    {
                        choice = in.nextInt();
                        curTechSup.viewOrder(choice);
                        in.next(".").charAt(0);
                    }
                    break;
                case 3:
                    if(curTechSup.viewUndoneOrders())
                    {
                        choice = in.nextInt();
                        curTechSup.viewOrder(choice);
                        in.next(".").charAt(0);
                    }
                    break;
                case 4:
                    curTechSup.changePassword();
                    Storage.users.put(curTechSup.getID(), curTechSup);
                    Storage.techSupportGuys.put(curTechSup.getID(), curTechSup);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Number too small or too big\n");
                    break;
            }
        }
    }


    private static void runStudent(String id) {
        while(true)
        {
            Student student = Storage.students.get(id);
            System.out.println(String.format("Welcome, %s %s\n", student.getName(), student.getSurname()));

            System.out.println(" 1  - Register to course");
            System.out.println(" 2  - Drop course");
            System.out.println(" 3  - View marks by course");
            System.out.println(" 4  - View files");
            System.out.println(" 5  - Change password");
            System.out.println(" 6  - Log out");

            int choice = in.nextInt();
            while(choice<1 || choice>6){
                System.out.println("Number too small or too big\n");
                System.out.println(" 1  - Register to course");
                System.out.println(" 2  - Drop course");
                System.out.println(" 3  - View marks by course");
                System.out.println(" 4  - View files");
                System.out.println(" 5  - Change password");
                System.out.println(" 6  - Log out");
                choice = in.nextInt();
            }



            switch (choice)
            {
                case 1:
                    student.registerCourse();
                    break;
                case 2:
                    student.dropCourse();
                    break;
                case 3:
                    student.viewMarks();
                    break;
                case 4:
                    student.viewFiles();
                    break;
                case 5:
                    student.changePassword();
                    Storage.users.put(student.getID(), student);
                    Storage.students.put(student.getID(), student);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Number too small or too big\n");
                    break;
            }
        }
    }

    private static void runTeacher(String id) {
        while(true)
        {
            Teacher teacher = Storage.teachers.get(id);
            System.out.println(String.format("Welcome, %s %s\n", teacher.getName(), teacher.getSurname()));

            System.out.println(" 1  - Put mark");
            System.out.println(" 2  - Send order");
            System.out.println(" 3  - Add course file");
            System.out.println(" 4  - View courses");
            System.out.println(" 5  - View students");
            System.out.println(" 6  - Change password");
            System.out.println(" 7  - Log out");

            int choice = in.nextInt();
            while(choice<1 || choice>7) {
                System.out.println("Number too small or too big\n");
                System.out.println(" 1  - Put mark");
                System.out.println(" 2  - Send order");
                System.out.println(" 3  - Add course file");
                System.out.println(" 4  - View courses");
                System.out.println(" 5  - View students");
                System.out.println(" 6  - Change password");
                System.out.println(" 7  - Log out");
                choice = in.nextInt();
            }

            switch (choice)
            {
                case 1:
                    teacher.putMark();
                    break;
                case 2:
                    teacher.sendOrder();
                    break;
                case 3:
                    teacher.addCourseFiles();
                    break;
                case 4:
                    teacher.viewCourses();
                    break;
                case 5:
                    teacher.viewStudents();
                    break;
                case 6:
                    teacher.changePassword();
                    Storage.users.put(teacher.getID(), teacher);
                    Storage.teachers.put(teacher.getID(), teacher);
                    break;
                case 7:
                    return;
            }
        }
    }
}
