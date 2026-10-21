package com.example.parkinglot.controllers;

import com.example.parkinglot.dtos.CreateTicket;
import com.example.parkinglot.dtos.UserTicket;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.Vehical;
import com.example.parkinglot.service.TicketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("")
    public UserTicket createTicket(@RequestBody CreateTicket createTicket)
    {
        System.out.println("Created ticket EndPoint called.");
        Vehical vehical = new Vehical(createTicket.getVehicleRegNo(),createTicket.getVehicleType());
        Ticket ticket = ticketService.createTicket(vehical,createTicket.getGetId());


        return getUserTicket(ticket);

    }


    private static UserTicket getUserTicket(Ticket ticket)
    {
        return UserTicket.builder()
                .ticketId(ticket.getId())
                .floorNo(ticket.getParkingSlot().getFloorNo())
                .SlotId(ticket.getParkingSlot().getId())
                .time(ticket.getIssueTime())
                .build();

    }
}
