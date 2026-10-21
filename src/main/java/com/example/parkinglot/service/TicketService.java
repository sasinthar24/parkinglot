package com.example.parkinglot.service;

import com.example.parkinglot.models.*;
import com.example.parkinglot.repository.GateRepository;
import com.example.parkinglot.strategy.BasicFindingStrategy;
import com.example.parkinglot.strategy.SlotFindingStrategy;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class TicketService {



    private final GateRepository gateRepository;
    private final SlotFindingStrategy slotFindingStrategy;

    public TicketService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
        this.slotFindingStrategy = new BasicFindingStrategy();
    }


    public Ticket createTicket(Vehical vehical, int gateId)
    {

        /*1.Fetch the gate, and parking lot object from gateId;
         * 2.Find suitable slots
         * 3.Update the Slots
         * 4.return the ticket object;
         */

        Gate gate = gateRepository.findById(1);
        ParkingSlot parkingSlot = slotFindingStrategy.findParkingSlot(gate.getParkingLot(),vehical);
        parkingSlot.setSlotState(SlotState.OCCUPIED);
        parkingSlot.setVehical(vehical);

        return Ticket.builder()
                .id(new Random().nextInt(1,Integer.MAX_VALUE))
                .operatorId(gate.getOperatorId())
                .gate(gate)
                .issueTime(LocalDateTime.now())
                .parkingSlot(parkingSlot)
                .vehical(vehical)
                .build();
    }
}
