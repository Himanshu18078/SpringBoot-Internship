package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Mobile m1 = new Mobile();
        m1.setSim(new AirtelSim());
        m1.startCall();
    }
}
