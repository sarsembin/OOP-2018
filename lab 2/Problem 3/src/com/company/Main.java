package com.company;

import java.util.Scanner;

class Data{
    private double max;
    private double sum;
    private int count;
    public Data(){
        sum = 0;
        max = 0;
        count = 0;
    }
    public void Adder(double num){
        sum += num;
        count++;
        if (num > max){
            max = num;
        }
    }
    public double Maxi(){
        return max;
    }
    public double Avg(){
        return sum/count;
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Data data = new Data();
        String s = "";
        while (true){
            System.out.print("Enter number (Q to quit): ");
            s = scan.nextLine();
            //System.out.print(s);
            if (s.equals("Q")){
                System.out.print("Average = " + data.Avg() + "\n");
                System.out.print("Maximum = " + data.Maxi() + "\n");
                break;
            }
            else {
                double n = Double.parseDouble(s);
                data.Adder(n);

            }

        }
    }
}
