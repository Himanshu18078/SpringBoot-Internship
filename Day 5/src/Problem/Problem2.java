package Problem;
import java.io.IOException;

public class Problem2 {

    class Parent {
        void show() throws IOException {
        }
    }

    class Child extends Parent {
//        void show() throws Exception {
//        }
        /* This fails because an overriding method cannot declare a broader checked exception than the method it overrides. */
    }

}
