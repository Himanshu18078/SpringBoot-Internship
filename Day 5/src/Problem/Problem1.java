package Problem;

import java.io.IOException;

public class Problem1 {
        public static void main(String[] args) {
            try {
                int x = 10 + 20;
            }
//            catch(IOException e) {
//                System.out.println(e); This will produce error .We can't ride any exception anywhere
//            }
            catch (Exception e){
                System.out.println(e);
            }
        }
}
