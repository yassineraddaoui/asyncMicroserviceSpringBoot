package com.spring.async.applicationa;

import lombok.AllArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;

import java.util.Collections;
import java.util.logging.Logger;

@SpringBootApplication
@AllArgsConstructor
public class ApplicationAApplication implements CommandLineRunner {
    private static final Logger log = Logger.getLogger(ApplicationAApplication.class.getName());
    private final StreamBridge streamBridge;

    public static void main(String[] args) {
        var app = new SpringApplication(ApplicationAApplication.class);
        app.run(args);

    }

    @Override
    public void run(String... args) throws Exception {
        var in = new InputDTO("yassine","HELLO");
        var result = streamBridge.send("sendCommunication-out-0", in);
        log.info("Processed " + in);

    }
}
