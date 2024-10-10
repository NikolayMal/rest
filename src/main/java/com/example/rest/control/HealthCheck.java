package com.example.rest.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class HealthCheck {

    @GetMapping("/healthCheck")
    private ResponseEntity healthCHeck() {
        return new ResponseEntity<>(Map.of("Status", "Ok"), HttpStatus.OK);
    }
}
