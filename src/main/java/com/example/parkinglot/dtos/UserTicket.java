package com.example.parkinglot.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class UserTicket {
    int ticketId;
    int SlotId;
    int floorNo;
    LocalDateTime time;
}
