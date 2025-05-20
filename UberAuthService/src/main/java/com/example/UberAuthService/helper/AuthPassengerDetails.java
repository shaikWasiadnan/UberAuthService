package com.example.UberAuthService.helper;

import com.example.UberAuthService.models.Passenger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

// Spring Security uses the UserDetails interface to retrieve user-related data during authentication.
// Since our application uses a custom Passenger model, we create this class to adapt Passenger into a UserDetails-compatible format.
// This enables Spring Security to perform authentication and authorization with our custom user model.


public class AuthPassengerDetails extends Passenger implements UserDetails {

    private String username;

    private String password;

    public AuthPassengerDetails(Passenger passenger){
        this.username=passenger.getEmail();
        this.password=passenger.getPassword();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
