package DynamicMethodDispatch.ExceptionHandling.CustomException;

// File: TestUnchecked.java

public class TestUnchecked {

    public static void validate(int age) {
        if (age < 0) {
            throw new MyUncheckedException("Age cannot be negative");
        }
    }

    public static void main(String[] args) {
        validate(-5); // No try-catch required
    }
}
