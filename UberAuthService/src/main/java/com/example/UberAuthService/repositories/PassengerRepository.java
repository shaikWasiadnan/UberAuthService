package com.example.UberAuthService.repositories;

import com.example.UberAuthService.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
