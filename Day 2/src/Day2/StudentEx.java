package Day2;

public class StudentEx {
    static void main() {
        Student s1 = new Student();
        s1.name = "Himanshu";
        s1.rollNumber = 18078;
        Student s2 = new Student("Ram",100);
        s1.getInfo();
        System.out.println("-----------------------------------------");
        s2.getInfo();
        System.out.println("-----------------------------------------");
        Student s3 = new Student(s1);
        s3.getInfo();
    }
}
