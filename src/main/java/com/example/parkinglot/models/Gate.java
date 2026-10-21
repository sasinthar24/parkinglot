package com.example.parkinglot.models;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Gate {
    GateType gateType;
    int operatorId;
    int id;
    ParkingLot parkingLot;


}
