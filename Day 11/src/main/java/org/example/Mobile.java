package org.example;

public class Mobile {
    private Sim sim;

//    public Mobile(Sim sim){
//        this.sim = sim;
//    }
    public void setSim(Sim sim){
        this.sim = sim;
    }

    public Sim getSim() {
        return sim;
    }

    public void startCall(){
        sim.call();
    }
}
