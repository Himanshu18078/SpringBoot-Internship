package DynamicMethodDispatch.Visibility;

import DynamicMethodDispatch.Visibility.Employee;

public class Manager implements Employee {
    String name;
    int salary;
    public Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    /*
    void getSalary() { // this is giving error because in parent this method is public and here we are
        // defining it default. We can increase the scope but we can't restrict it.

        System.out.println("Salary is: "+salary);
    }
     */
    public void manage(){
        System.out.println("manage");
    }

    @Override
    public void getSalary() {
        System.out.println("Salary is: " + salary);
    }
}
