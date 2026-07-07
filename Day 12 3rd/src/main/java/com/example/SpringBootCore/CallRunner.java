package com.example.SpringBootCore;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CallRunner implements ApplicationRunner {
    private final Mobile mobile;

    public CallRunner(Mobile mobile) {
        this.mobile = mobile;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        mobile.startCall();
    }
}
