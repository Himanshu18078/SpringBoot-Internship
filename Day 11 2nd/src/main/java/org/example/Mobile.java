package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Mobile {

    private final Sim sim;
    public Mobile(@Qualifier("js") Sim sim){
        this.sim = sim;
    }

/*
    CONSTRUCTOR INJECTION
    @Autowired
    public Mobile(JioSim sim)  {
        this.sim = sim;
    }
 */
    /*
    SETTER INJECTION
    @Autowired
    public void setSim(JioSim sim) {
        this.sim = sim;
    }
     */

    public void startCall(){
        System.out.println("Calling started");
        sim.call();
    }
}
