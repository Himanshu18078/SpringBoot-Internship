package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
    private final Sim sim;
    @Autowired
    public Mobile(@Qualifier("js") Sim sim) {
        this.sim = sim;
    }
    public void startCall(){
        sim.call();
        System.out.println("Call Started...");
    }
}
