package Day2.CopyConstructor.DeepCopy;

public class Student {
    String name;
    int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }
//    Constructor
    public void getDetail(){
        System.out.printf("Name : %s\nRollnumber : %d\n",name,rollNumber);
    }
//    Copy Constructor
//    this is shallow copy : here we pass a reference of the object which we want to copy
    public Student(Student s){
        this.name = s.name;
        this.rollNumber = s.rollNumber;
    }
}
