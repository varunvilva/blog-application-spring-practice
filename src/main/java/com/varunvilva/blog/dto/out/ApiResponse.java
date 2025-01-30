package com.varunvilva.blog.dto.out;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    private T data;
    private String status;
    private LocalDateTime timestamp;

    public ApiResponse(T data, String status) {
        this.data = data;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}
