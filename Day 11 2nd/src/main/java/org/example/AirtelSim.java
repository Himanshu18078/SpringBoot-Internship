package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("as")
public class AirtelSim implements Sim{
    @Override
    public void call() {
        System.out.println("Calling Using Airtel SIM");
    }
}
