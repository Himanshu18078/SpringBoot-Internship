package DynamicMethodDispatch.ExceptionHandling.Exception;

public class Exception1 {

    /**
     * Displays a message.
     *
     * This method declares that it may throw an IllegalArgumentException.
     * Since IllegalArgumentException is an unchecked exception
     * (a subclass of RuntimeException), callers are not required
     * to catch or handle it.
     *
     * @throws IllegalArgumentException if an invalid argument condition occurs
     */
    public void display() throws IllegalArgumentException {
        System.out.println("Hello World");
    }
}
