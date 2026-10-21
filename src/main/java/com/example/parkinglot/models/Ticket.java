package com.example.parkinglot.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class Ticket {
    int id;
    int operatorId;
    Gate gate;
    Vehical vehical;
    ParkingSlot parkingSlot;
    LocalDateTime issueTime;

}
