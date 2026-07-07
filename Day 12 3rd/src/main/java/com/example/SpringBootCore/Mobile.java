package com.example.SpringBootCore;

import org.springframework.stereotype.Component;

@Component
public class Mobile {
    private final Sim sim;

    public Mobile(Sim sim) {
        this.sim = sim;
    }
    public void startCall(){
        sim.call();
        System.out.println("Calling started");
    }
}
