package Task_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Circle c = new Circle(5);
        Circle c1 = new Circle(4);
        Shape s = c;
        System.out.print(s.getArea()+"\n");
        System.out.print(s.toString()+"\n");
        if (c.equals(c1)) System.out.print("equals" + "\n");
        else System.out.print("not_equals" + "\n");
        Rectangle r = new Rectangle(3, 4);
        s = r;
        System.out.print(s.getArea()+"\n");
        System.out.print(s.toString()+"\n");
    }
}
