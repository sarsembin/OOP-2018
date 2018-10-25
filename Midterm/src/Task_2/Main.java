package Task_2;

public class Main {
    public static void main(String[] args) {
        Customer daur = new Customer("Daur");
        System.out.print(daur.toString() + "\n");
        daur.setMember(true);
        daur.setMemberType("Silver");
        System.out.print(daur.toString() + "\n");
        Visit first = new Visit("daur", "28.01.15");
        System.out.print(first.toString() + "\n");
    }
}
