package MethodHiding;

public class Test {
    static void main() {
        Parent p1 = new Parent();
        Child c1 = new Child();
        p1.display(); // here we are calling static method with the help of the object
        c1.display(); //same for child
        Parent p2 = new Child();
        p2.display(); // since we have the reference of the parent so we can methods or variable of the parent only.
    }
}
//Static method can't be overridden.
