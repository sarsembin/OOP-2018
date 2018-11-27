package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Admin extends Person implements Serializable {

    public Admin(String name, String surname, String id, String password, AccessRights accessRights) {
        super(name, surname, id, password, accessRights);
    }

    public void addUser() {
        Person user;
        double salary;
        int choice = 0;

        String name;
        String surname;
        String id;
        String password;

        AccessRights userAccess = AccessRights.STUDENT;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write down user's name: ");
        name = scanner.next();

        System.out.println("Write down user's surname: ");
        surname = scanner.next();

        System.out.println("Write down user's id: ");
        id = scanner.next();

        System.out.println("Write down user's password: ");
        password = scanner.next();


        System.out.println("Please, choose user's Access Rights:");
        System.out.println(" 1 - Student");
        System.out.println(" 2 - Teacher");
        System.out.println(" 3 - Manager");
        System.out.println(" 4 - Tech Support");
        System.out.println(" 5 - Admin");

        choice = scanner.nextInt();
        while (choice < 1 || choice > 5){
            choice = scanner.nextInt();
            System.out.println("Number too small or too big");
        }

        switch (choice)
        {
            case 1:
                userAccess = AccessRights.STUDENT;
                System.out.println("Choose student's year of study:");
                System.out.println(" 1 ");
                System.out.println(" 2 ");
                System.out.println(" 3 ");
                System.out.println(" 4 ");
                choice = scanner.nextInt();
                while (choice < 1 || choice > 4){
                    choice = scanner.nextInt();
                    System.out.println("Number too small or too big");
                }
                Student student = new Student(name, surname, id, password, userAccess, choice);
                Storage.students.put(id, student);
                user = student;
                break;

            case 2:
                userAccess = AccessRights.TEACHER;
                System.out.println("Enter teacher's salary");
                salary = scanner.nextDouble();
                while (salary <= 0){
                    System.out.println("Salary too small");
                    salary = scanner.nextDouble();
                }
                Teacher teacher = new Teacher(name, surname, id, password, userAccess, salary);
                Storage.teachers.put(id, teacher);
                user = teacher;
                break;

            case 3:
                userAccess = AccessRights.MANAGER;
                System.out.println("Enter manager's salary");
                salary = scanner.nextDouble();
                while (salary <= 0){
                    System.out.println("Salary too small");
                    salary = scanner.nextDouble();
                }
                Manager manager = new Manager(name, surname, id, password, userAccess, salary);
                Storage.managers.put(id, manager);
                user = manager;
                break;
            case 4:
                userAccess = AccessRights.TECHSUPPORT;
                System.out.println("Enter tech support's salary");
                salary = scanner.nextDouble();
                while (salary <= 0){
                    System.out.println("Salary too small");
                    salary = scanner.nextDouble();
                }
                TechSupport techSupport = new TechSupport(name, surname, id, password, userAccess, salary);
                Storage.techSupportGuys.put(id, techSupport);
                user = techSupport;
                break;
            case 5:
                userAccess = AccessRights.ADMIN;
                Admin admin = new Admin(name, surname, id, password, userAccess);
                Storage.admins.put(id, admin);
                user = admin;
                break;
            default:
                user = new Person("name", "surname", "id", "password", userAccess);

        }

        Storage.users.put(id, user);

        System.out.println(user + " is added to the system");
        //Storage.writeLog(String.format("%s - new user %s is added", new Date(), user.toString()));
    }

    public void removeUser(){

        HashMap<String, Person> userMP = Storage.users;
        Iterator it = userMP.entrySet().iterator();
        while (it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)it.next();
            System.out.println(pair.getKey() + " " + pair.getValue().toString());
        }

        System.out.println("Enter user's id");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        while (!Storage.users.containsKey(id)){
            System.out.println("Didn't found user, try again");
            System.out.println("Enter user's id");
            id = scanner.next();
        }

        if(Storage.users.containsKey(id))
        {
            switch (Storage.users.get(id).getAccessRights())
            {
                case TECHSUPPORT:
                    Storage.techSupportGuys.remove(id);
                    break;
                case TEACHER:
                    Storage.teachers.remove(id);
                    break;
                case MANAGER:
                    Storage.managers.remove(id);
                    break;
                case STUDENT:
                    Storage.students.remove(id);
                    break;
                case ADMIN:
                    Storage.admins.remove(id);
                    break;
                default:
                    break;

            }
            Person u = Storage.users.get(id);
            Storage.users.remove(id);
            System.out.println(u.toString() + " is removed from the system");
            //Storage.writeLog(String.format("%s - %s is removed from the system", new Date(), u.toString()));
        }
        else
        {
            System.out.println("ID don't match!\nPlease, try again");
        }
    }


    public void printUsers(){
        System.out.println("Choose type: ");
        System.out.println(" 1 - Admins");
        System.out.println(" 2 - Students");
        System.out.println(" 3 - Managers");
        System.out.println(" 4 - Teachers");
        System.out.println(" 5 - Tech Support");
        System.out.println(" 6 - All users");
        System.out.println(" 7 - Back");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if(choice<1 || choice>7){
            System.out.println("Number too small or too big\n");
            printUsers();
            return;
        }

        int pos = 1;
        String id = null;
        switch (choice){
            case 1:
                HashMap<String, Admin> adminMP = Storage.admins;
                if(adminMP.isEmpty())
                {
                    System.out.println("There is no admins\n");
                    return;
                }
                Iterator it1 = adminMP.entrySet().iterator();
                Admin user1;
                while (it1.hasNext()){
                    HashMap.Entry pair = (HashMap.Entry)it1.next();
                    id = (String)pair.getKey();
                    user1 = adminMP.get(id);
                    System.out.println(String.format("[%d] - ID: %s; %s: %s %s", pos++, id, user1.getAccessRights(), user1.getName(), user1.getSurname()));
                }
                break;
            case 2:
                HashMap<String, Student> studentMP = Storage.students;
                if(studentMP.isEmpty())
                {
                    System.out.println("There is no students");
                    System.out.println();
                    return;
                }
                Iterator it2 = studentMP.entrySet().iterator();
                Student user2;
                while (it2.hasNext()){
                    HashMap.Entry pair = (HashMap.Entry)it2.next();
                    id = (String)pair.getKey();
                    user2 = studentMP.get(id);
                    System.out.println(String.format("[%d] - ID: %s; %s: %s %s", pos++, id, user2.getAccessRights(), user2.getName(), user2.getSurname()));
                }
                break;
            case 3:
                HashMap<String, Manager> managerMP = Storage.managers;
                if(managerMP.isEmpty())
                {
                    System.out.println("There is no managers\n");
                    return;
                }
                Iterator it3 = managerMP.entrySet().iterator();
                Manager user3;
                while (it3.hasNext()){
                    HashMap.Entry pair = (HashMap.Entry)it3.next();
                    id = (String)pair.getKey();
                    user3 = managerMP.get(id);
                    System.out.println(String.format("[%d] - ID: %s; %s: %s %s", pos++, id, user3.getAccessRights(), user3.getName(), user3.getSurname()));
                }
                break;
            case 4:
                HashMap<String, Teacher> teacherMP = Storage.teachers;
                if(teacherMP.isEmpty())
                {
                    System.out.println("There is no teachers\n");
                    return;
                }
                Iterator it4 = teacherMP.entrySet().iterator();
                Teacher user4;
                while (it4.hasNext()){
                    HashMap.Entry pair = (HashMap.Entry)it4.next();
                    id = (String)pair.getKey();
                    user4 = teacherMP.get(id);
                    System.out.println(String.format("[%d] - ID: %s; %s: %s %s", pos++, id, user4.getAccessRights(), user4.getName(), user4.getSurname()));
                }
                break;
            case 5:
                HashMap<String, TechSupport> techSupportMP= Storage.techSupportGuys;
                if(techSupportMP.isEmpty())
                {
                    System.out.println("There is no tech support guys\n");
                    return;
                }
                Iterator it5 = techSupportMP.entrySet().iterator();
                TechSupport user5;
                while (it5.hasNext()){
                    HashMap.Entry pair = (HashMap.Entry)it5.next();
                    id = (String)pair.getKey();
                    user5 = techSupportMP.get(id);
                    System.out.println(String.format("[%d] - ID: %s; %s: %s %s", pos++, id, user5.getAccessRights(), user5.getName(), user5.getSurname()));
                }
                break;
            case 6:
                HashMap<String, Person> userMP= Storage.users;
                if(userMP.isEmpty())
                {
                    System.out.println("There is no any users\n");
                    return;
                }
                Iterator it6 = userMP.entrySet().iterator();
                Person user6;
                while (it6.hasNext()){
                    HashMap.Entry pair = (HashMap.Entry)it6.next();
                    id = (String)pair.getKey();
                    user6 = userMP.get(id);
                    System.out.println(String.format("[%d] - ID: %s; %s: %s %s", pos++, id, user6.getAccessRights(), user6.getName(), user6.getSurname()));
                }
                break;
            case 7:
                return;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static HashMap<String, Admin> get() throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream OInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Daur\\Desktop\\oop\\lab 5\\Intranet_mf\\src\\com\\company\\Files\\Admins.out"));
            HashMap<String, Admin> admins = (HashMap<String, Admin>) OInputStream.readObject();
            OInputStream.close();
            return admins;
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            return new HashMap<String, Admin>();
        }
    }

    public static void save(HashMap<String, Admin> admins) throws IOException{
        try{
            ObjectOutputStream OOutputStream =  new ObjectOutputStream(new FileOutputStream("C:\\Users\\Daur\\Desktop\\oop\\lab 5\\Intranet_mf\\src\\com\\company\\Files\\Admins.out"));
            OOutputStream.writeObject(admins);
            OOutputStream.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Wrong path");
        }
    }

}
