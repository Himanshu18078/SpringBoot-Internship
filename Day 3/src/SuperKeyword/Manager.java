package SuperKeyword;

public class Manager extends Employee {
//    If the parent class have only argument constructor then we have to explicitly call it.
    Manager(String name, int id) {
        super(name, id); //Here we called parent class constructor and provide its value
    }
}
