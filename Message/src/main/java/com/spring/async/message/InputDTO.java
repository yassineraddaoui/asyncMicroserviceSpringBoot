package com.spring.async.message;

public record InputDTO(String name, String message) {

    public InputDTO {
        message = "Hey " + name ;
    }
}
