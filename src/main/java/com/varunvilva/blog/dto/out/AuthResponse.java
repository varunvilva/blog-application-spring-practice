package com.varunvilva.blog.dto.out;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthResponse {
    private String token;
    private long expiresIn;
}
