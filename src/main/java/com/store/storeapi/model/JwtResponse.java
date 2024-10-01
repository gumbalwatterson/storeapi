package com.store.storeapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private List<String> roles;
    private LocalDateTime loginTime;
    private List<String> links;

    public JwtResponse(String accessToken, List<String> links) {
        this.token = accessToken;
        this.links = links;
    }

    public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.loginTime = LocalDateTime.now();
    }
}
