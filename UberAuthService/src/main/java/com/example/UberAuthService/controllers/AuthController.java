package com.example.UberAuthService.controllers;

import com.example.UberAuthService.dtos.passengersignuprequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

//  for posting passenger details
    @PostMapping("/passenger")
    public ResponseEntity<?> passengerDetails(@RequestBody passengersignuprequestDTO details){
        return null;
    }
}
