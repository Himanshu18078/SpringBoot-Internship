package org.example;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class JioSim implements Sim{
//    @Autowired
    private final Mobile mobile;

    public JioSim(@Lazy Mobile mobile) {
        /*
        A proxy is a fake stand-in object that looks and behaves like the real thing from the
        outside, but doesn't actually do the real work itself —
        it just forwards the work to the real object when needed.
        */
        this.mobile = mobile;
    }

    @Override
    public void call() {
        mobile.getMobileId();
        System.out.println("Calling using jio sim");
    }
}
