package com.example.UberAuthService.models;

import jakarta.persistence.*;
import lombok.*;



import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends Base{

//    @OneToOne(cascade = {CascadeType.ALL})
//
//    private Review review;


    @Enumerated(value = EnumType.STRING)
    private BookingStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date totalTime;



    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;
}