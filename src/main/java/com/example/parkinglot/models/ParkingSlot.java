package com.example.parkinglot.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingSlot {
    int id;
    int floorNo;
    VehicleType vehicleType;
    SlotState slotState;
    Vehical vehical;
    SlotType slotType;

}
