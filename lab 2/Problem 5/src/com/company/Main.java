package com.company;

import java.util.Scanner;

public class Main {
    public static int[] conv(int a[]){
        int int1[] = new int[a.length*2];
        int q = 0;
        for (int i = 0; i < a.length * 2 ; i += 2){
            int1[i] = a[q];
            int1[i+1] = a[q];
            q++;
        }
        return int1;
    }
    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for (int i=0;i<n;i++){
            a[i] = scan.nextInt();
        }
        for (int i=0;i<conv(a).length;i++){
            System.out.print(conv(a)[i] + " ");
        }
    }
}
