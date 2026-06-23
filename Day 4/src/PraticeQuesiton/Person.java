package PraticeQuesiton;

public class Person {
    static void main() throws AgeLimitException {
        Voter v1 = new Voter("Himanshu" , 15);
        v1.validateVoter();
//        try{
//        v1.validateVoter();
//        }catch (AgeLimitException e){
//            System.out.println(e.getMessage());
//        }
    }
}
