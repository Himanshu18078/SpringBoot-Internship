package PraticeQuesiton;

public class Voter {
    String name;
    int age;
    public Voter(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void validateVoter() throws AgeLimitException{
        if(age < 18){
            throw new AgeLimitException("Below age limit...");
        }else{
            System.out.println("You are eligible to vote");
        }
    }
}
