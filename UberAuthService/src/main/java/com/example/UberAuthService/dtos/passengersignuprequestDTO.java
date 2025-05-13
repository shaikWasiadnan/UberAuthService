package com.example.UberAuthService.dtos;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class passengersignuprequestDTO {
    private String name;
    private String email;
    private  String phoneNumber;
    private String password;
}
