package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("js")
public class JioSim implements Sim{
    public void call(){
        System.out.println("Calling Using Jio SIM");
    }
}
