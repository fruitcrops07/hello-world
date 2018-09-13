package com.fimc.hello.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse {

    private int status;
    private String message;

    public MessageResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

}
