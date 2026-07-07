package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
//    @Autowired
    private final JioSim jioSim;

    public Mobile(JioSim jioSim) {
        this.jioSim = jioSim;
    }

    public void getMobileId(){
        System.out.println("Mobile Id is : 12345");
    }
    public void StartCall(){
        System.out.println("Call Started...");
        jioSim.call();
    }

}
