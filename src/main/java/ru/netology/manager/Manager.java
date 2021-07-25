package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class Manager {
    Repository repository = new Repository();
    private String from;

    public void save(Ticket ticket) {
        repository.add(ticket);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            Ticket[] tmp = new Ticket[result.length + 1];
            if (ticket.getDepartureAirport().equals(from.toUpperCase()) || ticket.getArrivalAirport().equals(to.toUpperCase())) {
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
