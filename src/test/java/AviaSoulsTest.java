package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void testSortFewTickets() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 5_000, 13, 15);
        Ticket ticket2 = new Ticket("MSK", "SPB", 11_000, 19, 21);
        Ticket ticket3 = new Ticket("MSK", "Sochi", 20_000, 14, 16);
        Ticket ticket4 = new Ticket("SPB", "Sochi", 15_000, 10, 14);
        Ticket ticket5 = new Ticket("MSK", "Istanbul", 25_000, 7, 12);
        Ticket ticket6 = new Ticket("MSK", "Dubai", 17_000, 3, 8);
        Ticket ticket7 = new Ticket("MSK", "SPB", 9_000, 10, 12);
        Ticket ticket8 = new Ticket("MSK", "SPB", 8_000, 13, 15);
        Ticket ticket9 = new Ticket("MSK", "SPB", 22_000, 7, 9);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {ticket1, ticket8, ticket7, ticket2, ticket9};
        Ticket[] actual = manager.search("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

@Test
    public void testSortOneTicket() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 5_000, 13, 15);
        Ticket ticket2 = new Ticket("MSK", "SPB", 11_000, 19, 21);
        Ticket ticket3 = new Ticket("MSK", "Sochi", 20_000, 14, 16);
        Ticket ticket4 = new Ticket("SPB", "Sochi", 15_000, 10, 14);
        Ticket ticket5 = new Ticket("MSK", "Istanbul", 25_000, 7, 12);
        Ticket ticket6 = new Ticket("MSK", "Dubai", 17_000, 3, 8);
        Ticket ticket7 = new Ticket("MSK", "SPB", 9_000, 10, 12);
        Ticket ticket8 = new Ticket("MSK", "SPB", 8_000, 13, 15);
        Ticket ticket9 = new Ticket("MSK", "SPB", 22_000, 7, 9);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.search("MSK", "Sochi");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTicket() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 5_000, 13, 15);
        Ticket ticket2 = new Ticket("MSK", "SPB", 11_000, 19, 21);
        Ticket ticket3 = new Ticket("MSK", "Sochi", 20_000, 14, 16);
        Ticket ticket4 = new Ticket("SPB", "Sochi", 15_000, 10, 14);
        Ticket ticket5 = new Ticket("MSK", "Istanbul", 25_000, 7, 12);
        Ticket ticket6 = new Ticket("MSK", "Dubai", 17_000, 3, 8);
        Ticket ticket7 = new Ticket("MSK", "SPB", 9_000, 10, 12);
        Ticket ticket8 = new Ticket("MSK", "SPB", 8_000, 13, 15);
        Ticket ticket9 = new Ticket("MSK", "SPB", 22_000, 7, 9);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "UFA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortFewTicketsComparator() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 5_000, 9, 10); //1
        Ticket ticket2 = new Ticket("MSK", "SPB", 11_000, 19, 22); //3
        Ticket ticket3 = new Ticket("MSK", "Sochi", 20_000, 14, 16);
        Ticket ticket4 = new Ticket("SPB", "Sochi", 15_000, 10, 14);
        Ticket ticket5 = new Ticket("MSK", "Istanbul", 25_000, 7, 12);
        Ticket ticket6 = new Ticket("MSK", "Dubai", 17_000, 3, 8);
        Ticket ticket7 = new Ticket("MSK", "SPB", 9_000, 10, 13); //3
        Ticket ticket8 = new Ticket("MSK", "SPB", 8_000, 10, 12); //2
        Ticket ticket9 = new Ticket("MSK", "SPB", 22_000, 7, 11); //4

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket8, ticket2, ticket7, ticket9};
        Ticket[] actual = manager.search("MSK", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicketsComparator() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 5_000, 9, 10); //1
        Ticket ticket2 = new Ticket("MSK", "SPB", 11_000, 19, 22); //3
        Ticket ticket3 = new Ticket("MSK", "Sochi", 20_000, 14, 16);
        Ticket ticket4 = new Ticket("SPB", "Sochi", 15_000, 10, 14);
        Ticket ticket5 = new Ticket("MSK", "Istanbul", 25_000, 7, 12);
        Ticket ticket6 = new Ticket("MSK", "Dubai", 17_000, 3, 8);
        Ticket ticket7 = new Ticket("MSK", "SPB", 9_000, 10, 13); //3
        Ticket ticket8 = new Ticket("MSK", "SPB", 8_000, 10, 12); //2
        Ticket ticket9 = new Ticket("MSK", "SPB", 22_000, 7, 11); //4

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.search("MSK", "Istanbul", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortZeroTicketsComparator() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 5_000, 9, 10); //1
        Ticket ticket2 = new Ticket("MSK", "SPB", 11_000, 19, 22); //3
        Ticket ticket3 = new Ticket("MSK", "Sochi", 20_000, 14, 16);
        Ticket ticket4 = new Ticket("SPB", "Sochi", 15_000, 10, 14);
        Ticket ticket5 = new Ticket("MSK", "Istanbul", 25_000, 7, 12);
        Ticket ticket6 = new Ticket("MSK", "Dubai", 17_000, 3, 8);
        Ticket ticket7 = new Ticket("MSK", "SPB", 9_000, 10, 13); //3
        Ticket ticket8 = new Ticket("MSK", "SPB", 8_000, 10, 12); //2
        Ticket ticket9 = new Ticket("MSK", "SPB", 22_000, 7, 11); //4

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "France", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
