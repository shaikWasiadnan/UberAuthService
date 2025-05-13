package com.example.UberAuthService.controllers;

import com.example.UberAuthService.dtos.PassengerResponseDTO;
import com.example.UberAuthService.dtos.passengersignuprequestDTO;
import com.example.UberAuthService.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private AuthService authService;
    public AuthController(AuthService authService){
        this.authService=authService;
    }


    @PostMapping("/passenger/signup")
    public ResponseEntity<?> AddPassengerDetails(@RequestBody passengersignuprequestDTO details){
        try{
            PassengerResponseDTO d=authService.AddPassenger(details);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Some error occured",HttpStatus.BAD_REQUEST);
        }
    }
}
