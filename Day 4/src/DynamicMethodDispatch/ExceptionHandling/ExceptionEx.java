package DynamicMethodDispatch.ExceptionHandling;

public class ExceptionEx {
    public static void main(String[] args){
        int a = 10;
        int b = 0;
        try{
            int c = a / b;
        }finally { //we can write try with finally without catch
            System.out.println("Problem Solved...");
        }
    }
}
