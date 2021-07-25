package ru.netology.repository;

import ru.netology.domain.Ticket;

public class Repository {
    private Ticket[] tickets = new Ticket[0];

    public void add(Ticket ticket) {       //добавить
        int length = tickets.length + 1;
        Ticket[] temp = new Ticket[length];
        System.arraycopy(tickets, 0, temp, 0, tickets.length);
        int lastInd = temp.length - 1;
        temp[lastInd] = ticket;
        tickets = temp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket[] findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return tickets;
            }
        }
        return null;
    }

    public Ticket[] removeById(int id) {
        if (findById(id) == null) {
            throw new RuntimeException("Element with id: " + id + " not found");
        }
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
        return tmp;
    }
}