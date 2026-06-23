package DynamicMethodDispatch.ExceptionHandling;

public class ExceptionEx2 {
    public static void main(String[] args){
        int a = 10;
        int b = 0;
        try{
            int c = a / b;
        } catch (Exception e) {
            System.out.printf("Exception: %s%n", e.getMessage());
//            throw e;
            throw new ArithmeticException("Exception aa gyi hai...");
        }finally { //we can write try with finally without catch
            System.out.println("Problem Solved...");
        }
    }
}
