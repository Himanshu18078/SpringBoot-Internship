package DynamicMethodDispatch.ExceptionHandling.CustomException;

// File: TestChecked.java

public class TestChecked {

    public static void validate(int age) throws MyCheckedException {
        if (age < 0) {
            throw new MyCheckedException("Age cannot be negative");
        }
    }

    public static void main(String[] args) {
        try {
            validate(-5);
        } catch (MyCheckedException e) {
            System.out.println(e.getMessage());
        }
    }
}
