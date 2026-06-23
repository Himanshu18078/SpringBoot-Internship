package DynamicMethodDispatch.ExceptionHandling.CustomException;

public class MyUncheckedException extends RuntimeException {
    /*To throw Unchecked exception we extend RunTimeException*/
  public MyUncheckedException(String message) {
    super(message);
  }
}
