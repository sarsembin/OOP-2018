package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Vector;

public class TechSupport extends Employee implements Serializable {

    private Vector<Order> orders = new Vector<Order>();


    public TechSupport(String name, String surname, String id, String password, AccessRights accessRights, double salary) {
        super(name, surname, id, password, accessRights, salary);
        orders = new Vector<Order>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public boolean viewAllOrders(){
        if(orders.size() == 0)
        {
            System.out.println("No orders");
            return false;
        }
        for(int i=0; i<orders.size(); i++)
        {
            System.out.println(String.format("%d - %s, %s", i+1, orders.elementAt(i).getTitle(), orders.elementAt(i).getDate()));
        }
        System.out.println(String.format("%d - Back", orders.size()));
        return true;
    }

    public boolean viewDoneOrders(){
        if(orders.size() == 0)
        {
            System.out.println("No orders");
            return false;
        }
        int count = 1;
        for(int i=0; i<orders.size(); i++)
        {
            if(!orders.elementAt(i).getisDone()) continue;
            System.out.println(String.format("[%d] - %s, %s", count++, orders.elementAt(i).getTitle(), orders.elementAt(i).getDate()));
        }
        System.out.println(String.format("[%d] - Back", count));
        return true;
    }

    public boolean viewUndoneOrders(){
        if(orders.size() == 0)
        {
            System.out.println("No orders");
            return false;
        }
        int count = 1;
        for(int i=0; i<orders.size(); i++)
        {
            if(orders.elementAt(i).getisDone()) continue;
            System.out.println(String.format("[%d] - %s, %s", count, orders.elementAt(i).getTitle(), orders.elementAt(i).getDate()));
        }
        System.out.println(String.format("[%d] - Back", count));
        return true;
    }

    public void viewOrder(int index)
    {
        System.out.println(String.format("%s", orders.elementAt(index).getText()));
        System.out.println("\nPress any key to continue\n");
    }

    public void DoOrder(int index){
        orders.elementAt(index).setIsDoneTrue();
        System.out.println("Order is successfully done!");
    }

    public static HashMap<String, TechSupport> get() throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream OInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Daur\\Desktop\\oop\\lab 5\\Intranet_mf\\src\\com\\company\\Files\\TechSupportGuys.out"));
            HashMap<String, TechSupport> techSupportGuys = (HashMap<String, TechSupport>) OInputStream.readObject();
            OInputStream.close();
            return techSupportGuys;
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            return new HashMap<String, TechSupport>();
        }
    }

    public static void save(HashMap<String, TechSupport> techSupportGuys) throws IOException{
        try{
            ObjectOutputStream OOutputStream =  new ObjectOutputStream(new FileOutputStream("C:\\Users\\Daur\\Desktop\\oop\\lab 5\\Intranet_mf\\src\\com\\company\\Files\\TechSupportGuys.out"));
            OOutputStream.writeObject(techSupportGuys);
            OOutputStream.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Wrong path");
        }
    }
}
