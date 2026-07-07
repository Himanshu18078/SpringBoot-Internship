package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
@Qualifier("as")
public class AirtelSim implements Sim{
    @Override
    public void call() {
        System.out.println("Calling using Airtel Sim");
    }
}
