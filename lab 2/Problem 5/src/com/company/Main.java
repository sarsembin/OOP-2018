package com.company;

import java.util.Scanner;

class non_static {
    int int1[];
    int q = 0;

    public non_static(int a[], int k) {
        int1 = new int[a.length * 2];
        q = k;
    }

    public int[] conv(int a[]) {
        int int2[] = new int[a.length*2];
        int qa = 0;
        for (int i = 0; i < a.length*2; i += 2) {
            int2[i] = a[qa];
            int2[i + 1] = a[qa];
            qa++;
        }
        return int2;
    }
}
public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        non_static kek = new non_static(a, 0);

        for (int i = 0; i < kek.conv(a).length; i++) {
            System.out.print(kek.conv(a)[i] + " ");
        }
    }
}
