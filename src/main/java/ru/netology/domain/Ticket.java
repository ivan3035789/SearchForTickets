package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket implements Comparable<Ticket> {
    private int id;
    private double price;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;


    @Override
    public int compareTo(Ticket o) {
        return (int) (price - o.price);
    }

}

