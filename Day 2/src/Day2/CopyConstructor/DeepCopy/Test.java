package Day2.CopyConstructor.DeepCopy;

public class Test {
    static void main() {
    Student s1 = new Student("Himanshu", 18078);
    Student s2 = new Student(s1);
    s1.getDetail();
    s2.getDetail();
    System.out.println("----------------------");
    s1.name = "Rohit";
    s1.rollNumber = 18080;
    s1.getDetail();
    s2.getDetail();
    }

}
