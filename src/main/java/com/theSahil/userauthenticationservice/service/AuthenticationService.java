package com.theSahil.userauthenticationservice.service;

import com.theSahil.userauthenticationservice.model.LoginRequest;
import com.theSahil.userauthenticationservice.model.SignupRequest;
import com.theSahil.userauthenticationservice.model.User;
import com.theSahil.userauthenticationservice.repo.UserRepository;
import com.theSahil.userauthenticationservice.utils.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(AuthenticationManager authenticationManager, UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        log.info("Request: {}", loginRequest);
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.getUsername(), loginRequest.getPassword());
        log.info("authenticationRequest: {}", authenticationRequest);
        Authentication authenticationResponse =
                this.authenticationManager.authenticate(authenticationRequest);
        log.info("authenticationResponse: {}", authenticationResponse);
        return new ResponseEntity<>("<h1>Welcome</h1>", HttpStatus.OK);
    }

    public ResponseEntity<?> signup(SignupRequest signupRequest) {
        log.info("Request: {}", signupRequest);
        User user = userMapper.signupReqToUser(signupRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        log.info("user saved: {}", user);
        return new ResponseEntity<>("<h1>You have been registered</h1>",HttpStatus.OK);
    }
}
