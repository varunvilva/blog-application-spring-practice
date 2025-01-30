package com.varunvilva.blog.dto.out;

import jakarta.persistence.PrePersist;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String message;
    private String errorCode;
    private LocalDateTime timestamp;

    public ErrorResponse(String message, String errorCode){
        this.message = message;
        this.errorCode = errorCode;
        this.timestamp = LocalDateTime.now();
    }
}