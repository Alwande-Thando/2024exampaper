package za.ac.prog6112.q2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieTicketsTest {
    private final MovieTickets tickets = new MovieTickets();

    @Test
    void calculateTotalTicketPriceCalculatedSuccessfully() {
        // 2 tickets at R100 each = R200 + 14% VAT = R228.
        assertEquals(228.0, tickets.CalculateTotalTicketPrice(2, 100.0), 0.001);
    }

    @Test
    void validationRejectsInvalidTicketCount() {
        assertFalse(tickets.ValidateData(new MovieTicketData("Napoleon", 0, 100.0)));
        assertTrue(tickets.ValidateData(new MovieTicketData("Napoleon", 2, 100.0)));
    }
}
