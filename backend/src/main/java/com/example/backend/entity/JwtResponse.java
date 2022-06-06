package com.example.backend.entity;

import lombok.Data;

@Data
public class JwtResponse {

    private UserR userR;
    private String jwtToken;

    public JwtResponse(UserR userR, String jwtToken) {
        this.userR = userR;
        this.jwtToken = jwtToken;
    }
}
