package DynamicMethodDispatch;

public abstract class Employee {
    String name;
    int salary;
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    public abstract void getSalary();
}
