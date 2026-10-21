package com.example.parkinglot.dtos;

import com.example.parkinglot.models.SlotState;
import com.example.parkinglot.models.SlotType;
import com.example.parkinglot.models.VehicleType;
import lombok.Data;

@Data
public class CreateTicket {
    String vehicleRegNo;
    VehicleType vehicleType;
    int getId;
    SlotType slotType;
}
