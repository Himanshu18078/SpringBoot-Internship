package Day2;
public class Student {
    String name;
    int rollNumber;
    public Student() {
        // Default Constructor
        // A constructor with no parameters is called a default (or no-argument) constructor.
        // It is executed automatically whenever an object is created using:
        // Student student = new Student();

        // Since no values are assigned inside this constructor,
        // Java initializes all instance variables with their default values.

        // Default values for instance variables:
        // byte, short, int, long      -> 0
        // float, double               -> 0.0
        // char                         -> '\u0000' (null character)
        // boolean                      -> false
        // Object references (String, Arrays, Custom Objects, etc.) -> null

        // Example:
        // int age;       // default value = 0
        // String name;   // default value = null
        // boolean active;// default value = false

        // This constructor is useful when an object can be created
        // without requiring initial values, or when values will be
        // assigned later using setters or other methods.
    }

    Student(String name, int rollNumber){
        this.name = name;
//      This keyword is a reference variable used to refer to the current object.
        this.rollNumber = rollNumber;
    }
//    Copy Constructor
    Student(Student s){
        this.name = s.name;
        this.rollNumber = s.rollNumber;
    }

    public void getInfo(){
        System.out.printf("Name : %s\nRoll Number : %d\n",name,rollNumber);
    }

}
