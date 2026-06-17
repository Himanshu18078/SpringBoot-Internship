package Day2.CopyConstructor.DeepCopy.DeepCopy2;

public class Main {
    static void main() {
        Address a1 = new Address("Delhi");
        Student S1 = new Student("Himanshu",a1);
        S1.display();
        Student S2 = new Student("Rohit",a1);
        S2.display();
        System.out.println("-------------------------");
        S2.address.city = "Mumbai";
        S1.display();
        S2.display();
    }

}
