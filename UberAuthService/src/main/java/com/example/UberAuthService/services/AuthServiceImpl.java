package com.example.UberAuthService.services;

import com.example.UberAuthService.dtos.PassengerResponseDTO;
import com.example.UberAuthService.dtos.passengersignuprequestDTO;
import com.example.UberAuthService.models.Passenger;
import com.example.UberAuthService.repositories.PassengerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthServiceImpl implements AuthService{
    private PassengerRepository passengerRepository;
    private PasswordEncoder passwordEncoder;



    public AuthServiceImpl(PassengerRepository passengerRepository, PasswordEncoder passwordEncoder){
        this.passengerRepository = passengerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public PassengerResponseDTO AddPassenger(passengersignuprequestDTO details) {
        Passenger p = Passenger.builder()
                .email(details.getEmail())
                .name(details.getName())
                .password(passwordEncoder.encode(details.getPassword()))
                .phoneNumber(details.getPhoneNumber())
                .build();

        passengerRepository.save(p);

        return PassengerResponseDTO.convertFromPassenger(p);
    }

}
