package com.company;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class  {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int a = reader.nextInt();
        //int b = reader.nextInt();
        int q = 0;
        /*if (a==1){
            System.out.print(1);
        }*/
        //else{
        for (int i = 1 ; i * i <= a ; i++){
            if (a % i  == 0){
                if (i * i == a) q++;
                else q += 2;
                //System.out.print(i + " ");
            }
        }
        /*if (abs(sqrt(a))*abs(sqrt(a))==a)
            q++;*/
        System.out.print(q);//}
    }
}
