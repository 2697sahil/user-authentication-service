package com.theSahil.userauthenticationservice.model;

import lombok.Data;

@Data
public class SignupRequest {

    private String username;
    private String password;
    private String email;
    private String[] roles;
}
