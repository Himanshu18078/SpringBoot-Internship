package Comparator;

public class Employee {
    int empID;
    int salary;
    String name;

    public Employee(int empID, int salary, String name) {
        this.empID = empID;
        this.salary = salary;
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("empID=").append(empID);
        sb.append(", salary=").append(salary);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
