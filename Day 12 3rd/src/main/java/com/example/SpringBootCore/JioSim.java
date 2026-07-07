package com.example.SpringBootCore;

import org.springframework.stereotype.Component;

@Component
public class JioSim implements Sim{
    public void call(){
        System.out.println("Calling using jio sim.");
    }
}
