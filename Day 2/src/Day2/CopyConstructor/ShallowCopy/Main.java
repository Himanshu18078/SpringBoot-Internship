package Day2.CopyConstructor.ShallowCopy;

public class Main {
    static void main() {
        Address a1 = new Address("Noida");
        Student S1 = new Student("Himanshu",a1);
        S1.display();
        Student S2 = new Student("Rohit",a1);
        S2.display();
        System.out.println("-------------------------");
        S2.address.city = "Delhi";
        S2.name = "Mohit";
        S1.display();
        S2.display();
    }

}
