package com.company;

import java.io.IOException;

public class InitializationClass {
    static void initialization()
    {
        try
        {
            Storage.deserializeAll();
        }
        catch (ClassNotFoundException clex)
        {
            clex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    static void authorization()
    {
        Driver.login();
    }

    static void exit()
    {
        try
        {
            Storage.serializeAll();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    static void firstRun()
    {
        Admin admin = new Admin("Admin", "Adminovich", "AD001", "123", AccessRights.ADMIN);
        TechSupport techSupport = new TechSupport("TechSupp", "TechSuppovich", "TS001", "123", AccessRights.TECHSUPPORT, 40000);
        Teacher teacher1 = new Teacher("Teacher1", "Teacherov", "TR001", "123", AccessRights.TEACHER, 40000);
        Teacher teacher2 = new Teacher("Techer2", "Teacherovich", "TR002", "123", AccessRights.TEACHER, 40000);


        Storage.users.put("Admin_01", new Person("Admin", "Adminovich", "AD001", "123", AccessRights.ADMIN));
        Storage.admins.put("Admin_01", admin);
        try {
            Storage.serializeAll();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
