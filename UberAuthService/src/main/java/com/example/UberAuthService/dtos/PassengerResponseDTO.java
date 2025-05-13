package com.example.UberAuthService.dtos;

import com.example.UberAuthService.models.Passenger;
import jakarta.persistence.EntityListeners;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PassengerResponseDTO {


    private Long id;
    private String name;
    private String password;
    private String email;
    private Date created_at;
    private String phoneNumber;

    public static PassengerResponseDTO convertFromPassenger(Passenger p){
        PassengerResponseDTO result=PassengerResponseDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .email(p.getPhoneNumber())
                .phoneNumber(p.getPhoneNumber())
                .password(p.getPassword())
                .created_at(p.getCreatedAt())
                .build();
        return result;
    }

}
