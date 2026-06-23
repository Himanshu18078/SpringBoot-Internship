package DynamicMethodDispatch.ExceptionHandling.CustomException;

public class MyCheckedException extends Exception {
    /*  To create a checked exception, your custom exception class must
    extend Exception directly (or another checked exception), not RuntimeException.  */
    public MyCheckedException(String message) {
        super(message);
    }
}
