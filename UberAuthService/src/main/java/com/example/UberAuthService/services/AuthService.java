package com.example.UberAuthService.services;

import com.example.UberAuthService.dtos.PassengerResponseDTO;
import com.example.UberAuthService.dtos.passengersignuprequestDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public interface AuthService {
    public PassengerResponseDTO AddPassenger(passengersignuprequestDTO details);
}
