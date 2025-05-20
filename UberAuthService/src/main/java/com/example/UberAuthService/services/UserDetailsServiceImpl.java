package com.example.UberAuthService.services;

import com.example.UberAuthService.helper.AuthPassengerDetails;
import com.example.UberAuthService.models.Passenger;
import com.example.UberAuthService.repositories.PassengerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

// This class is responsible for getting passengerDetails and loading user in the form of UserDetails

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private PassengerRepository passengerRepository;
    public UserDetailsServiceImpl(PassengerRepository passengerRepository){
        this.passengerRepository=passengerRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Passenger> passenger= passengerRepository.findPassengerByEmail(username);
        if(passenger.isPresent()){
            return new AuthPassengerDetails(passenger.get());
        }
        else{
            throw new UsernameNotFoundException("Cannot find the passenger by given email");
        }
    }
}
