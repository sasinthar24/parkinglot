package com.example.parkinglot.repository;

import com.example.parkinglot.models.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class GateRepository {

    private final Map<Integer,Gate> gates = fillGates();

    public Gate findById(int id)
    {
        return gates.get(id);
    }


    private static Map<Integer,Gate> fillGates()
    {
        Map<Integer,Gate> gates = new HashMap<>();
        ParkingSlot parkingSlot1 = ParkingSlot.builder()
                .floorNo(1)
                .slotType(SlotType.NORMAL)
                .vehicleType(VehicleType.SUV)
                .id(1)
                .slotState(SlotState.FREE)
                .build();
        ParkingSlot parkingSlot2 = ParkingSlot.builder()
                .floorNo(2)
                .slotType(SlotType.VIP)
                .vehicleType(VehicleType.SEDAN)
                .id(10)
                .slotState(SlotState.FREE)
                .build();
        ParkingLot parkingLot = ParkingLot.builder()
                .name("VR Mall")
                .address("Anna Nagar")
                .parkingSlots(List.of(parkingSlot1,parkingSlot2))
                .build();
        Gate gate1  = Gate.builder()
                .id(1)
                .operatorId(1)
                .gateType(GateType.ENTRY)
                .parkingLot(parkingLot)
                .build();
        gates.put(1,gate1);
        return gates;
    }
}
