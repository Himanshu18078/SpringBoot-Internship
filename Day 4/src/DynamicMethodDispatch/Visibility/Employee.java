package DynamicMethodDispatch.Visibility;

public interface Employee {
//    Every method in interface must be final and we must initialize it at the time of declaration
//    String name;
//    int salary;
    /*
     We can not create an object of interface
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    */

    void getSalary();
}
