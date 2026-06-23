package DynamicMethodDispatch;

public class Manager extends Employee {
    public Manager(String name, int salary) {
        super(name, salary);
    }
    @Override
    public void getSalary() {
        System.out.println("Salary is: "+salary);
    }
    public void manage(){
        System.out.println("manage");
    }

}
