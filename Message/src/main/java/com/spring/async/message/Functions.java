package com.spring.async.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class Functions {
     private static final Logger log= LoggerFactory.getLogger(Functions.class);
    @Bean
    public Function<InputDTO,InputDTO> funcOne(){
        return inputDTO -> {
            log.info("Function One processed");
            return inputDTO;
        };    }
    @Bean
    public Function<InputDTO,String> funcTwo(){
        return inputDTO -> {
            log.info("Function Two processed");
            return inputDTO.message();
        };
    }
}
