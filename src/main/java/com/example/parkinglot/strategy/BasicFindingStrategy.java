package com.example.parkinglot.strategy;

import com.example.parkinglot.models.ParkingSlot;
import com.example.parkinglot.models.SlotState;
import com.example.parkinglot.models.Vehical;
import com.example.parkinglot.models.ParkingLot;

import java.util.List;

public class BasicFindingStrategy implements SlotFindingStrategy{

    @Override
    public ParkingSlot findParkingSlot(ParkingLot parkinglot, Vehical vehical) {
        List<ParkingSlot> parkingSlotList = parkinglot.getParkingSlots();

        for(ParkingSlot parkingSlot:parkingSlotList)
        {
            if(parkingSlot.getSlotState().equals(SlotState.FREE) && parkingSlot.getVehicleType().equals(vehical.getVehicleType()))
            {
                return parkingSlot;
            }
        }
        throw new RuntimeException(
                "No parking slot available for vehicle type: "
                        + vehical.getVehicleType()
        );
    }
}
