package com.spring.async.applicationa;


import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;

@Component
@AllArgsConstructor
public class Caller {
    private static final Logger log = Logger.getLogger(Caller.class.getName());
    private final StreamBridge streamBridge;

    @Bean
    public Function<InputDTO,InputDTO> send(){
        return inputDTO -> {
            var result = streamBridge.send("sendCommunication-out-0", inputDTO);
            log.info("processed ?"+ result);
            return inputDTO;
        };
    }
}
