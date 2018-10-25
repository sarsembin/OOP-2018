package com.company;

public class Main {

    public static void main(String[] args) {
        int a[] = {0, 8, -3, 20};
        //int b[] = {-5, 8, -3, 30};
        MinMax m = new MinMax();
        MinMax.Values v = m.minmax(a);
        System.out.println(v.toString());
    }
}
