package Day2.CopyConstructor.ShallowCopy;

public class Student {
    String name;
//    Composition
    Address address;
    //    We have created an address class and now we are using it as dataType
    public Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    Student(Student s){
        this.name = s.name;
        this.address = s.address;
    }
    void display(){
        System.out.printf("Name : %s\nAddress : %s\n",name,address.city);
    }
}
