package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Mobile m1 = context.getBean(Mobile.class);
        m1.startCall();
    }
}
