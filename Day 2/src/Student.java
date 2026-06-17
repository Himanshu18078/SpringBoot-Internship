public class Student {
    int RollNumber;
    int fees;
    String name;

    public Student(int RollNumber, int fees, String name) {
        this.RollNumber = RollNumber;
        this.fees = fees;
        this.name = name;
    }
    public Student(int RollNumber , int fees){
        this.fees = 93800;
    }
    public void printDetails(){
        System.out.println("Name : "+name);
        System.out.println("Roll Number : "+RollNumber);
        System.out.println("Fees : "+fees);
    }
}
