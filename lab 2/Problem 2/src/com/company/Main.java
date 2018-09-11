package com.company;
class StarTriangle{
    private int width;
    public StarTriangle(int width_){
        width = width_;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i =0;i<width;i++){
            for (int j=0;j<=i;j++){
                s = s + "[*]";
            }
            s = s + "\n";
        }
        return s;
    }
}
public class Main {

    public static void main(String[] args) {
        StarTriangle small = new StarTriangle(3);
        System.out.print(small.toString());
    }
}
