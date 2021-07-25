package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ManagerTest {
    private final Manager manager = new Manager();
    private final Ticket firstMoscowOmsk = new Ticket(1, 5500.50, "BKA", "OMS", 300);
    private final Ticket secondMoscowOrenburg = new Ticket(2, 6000.50, "VKO", "REN", 200);
    private final Ticket thirdMoscowAdlerSochi = new Ticket(3, 4500.00, "DME", "AER", 250);
    private final Ticket fourthMoscowKursk = new Ticket(4, 3000.00, "SVO", "AER", 350);
    private final Ticket fifthMoscowKursk = new Ticket(5, 3100.00, "VKO", "AER", 350);

    @BeforeEach
    public void setUp() {
        manager.save(firstMoscowOmsk);
        manager.save(secondMoscowOrenburg);
        manager.save(thirdMoscowAdlerSochi);
        manager.save(fourthMoscowKursk);
        manager.save(fifthMoscowKursk);
    }

    @Test
    void searchByDepartureAndArrivalAirportWithMinimumPriceInAscendingOrder() {
        Ticket[] expected = new Ticket[]{fourthMoscowKursk, firstMoscowOmsk};
        Ticket[] actual = manager.searchBy("svo", "OMS");
        assertArrayEquals(expected, actual);

        System.out.println("________________\n# tickets found: " + actual.length + "\n# searchByDepartureAndArrivalAirportWithMinimumPriceInAscendingOrder ____ 'SVO, OMS' \n# Moscow:Kursk_" + actual[0] + "\n# Moscow:Omsk_" + actual[1] + "\n________________");

    }

    @Test
    void searchByArrivalAirport() {
        Ticket[] expected = new Ticket[]{firstMoscowOmsk};
        Ticket[] actual = manager.searchBy("", "OMS");
        assertArrayEquals(expected, actual);

        System.out.println("________________\n# tickets found: " + actual.length + "\n# searchByArrivalAirport ____ ' ', 'OMS' \n# Moscow:Omsk_" + actual[0] + "\n________________");
    }

    @Test
    void searchByDepartureAirport() {
        Ticket[] expected = new Ticket[]{fifthMoscowKursk, secondMoscowOrenburg};
        Ticket[] actual = manager.searchBy("VKO", "");
        assertArrayEquals(expected, actual);

        System.out.println("________________\n# tickets found: " +  actual.length + "\n# searchByDepartureAirport ____ 'VKO', '' \n# Moscow:Kursk_" + actual[0] + "\n# Moscow:Orenburg_" + actual[1] + "\n________________");
    }

    @Test
    void searchByDepartureAndArrivalAirportWithUppercaseAndLowercaseLetters() {

        Ticket[] expected = new Ticket[]{fourthMoscowKursk, fifthMoscowKursk, thirdMoscowAdlerSochi, secondMoscowOrenburg};
        Ticket[] actual = manager.searchBy("VKO", "aer");
        assertArrayEquals(expected, actual);

        System.out.println("________________\n# tickets found: " +  actual.length + "\n# searchByDepartureAndArrivalAirportWithUppercaseAndLowercaseLetters ____ 'VKO', 'aer' \n# Moscow:Kursk_" + actual[0] + "\n# Moscow:Kursk_" + actual[1] + "\n# Moscow:AdlerSochi: " + actual[2] + "\n# Moscow:Orenburg_" + actual[3] + "\n________________");

    }

    @Test
    void searchForTicketsByDepartureAndArrivalAirportThatAreNotAvailable() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchBy("REN", "BKA");
        assertArrayEquals(expected, actual);

        System.out.println("________________\n# tickets found: " +  actual.length + "\n searchForTicketsByDepartureAndArrivalAirportThatAreNotAvailable ____ 'REN', 'BKA' \n________________");
    }

    @Test
    void searchWithoutEnteringTheDataOfTheDepartureAndArrivalAirport() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchBy("", "");
        assertArrayEquals(expected, actual);

        System.out.println("________________\n# tickets found: " +  actual.length + "\n searchWithoutEnteringTheDataOfTheDepartureAndArrivalAirport ____ ' ', ' ' \n________________");
    }

}