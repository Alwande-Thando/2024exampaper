package za.ac.prog6112.q1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieTicketsTest {
    private final MovieTickets tickets = new MovieTickets();

    @Test
    void calculateTotalSalesReturnsExpectedTotalSales() {
        assertEquals(6200, tickets.TotalMovieSales(new int[]{3000, 1500, 1700}));
        assertEquals(6300, tickets.TotalMovieSales(new int[]{3500, 1200, 1600}));
    }

    @Test
    void topMovieSalesReturnsTopMovie() {
        assertEquals("Oppenheimer",
                tickets.TopMovie(new String[]{"Napoleon", "Oppenheimer"}, new int[]{6200, 6300}));
    }
}
