package za.ac.prog6112.q2;

public class MovieTickets implements IMovieTickets {
    public static final double VAT_RATE = 0.14;

    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        if (numberOfTickets <= 0 || ticketPrice <= 0)
            throw new IllegalArgumentException("Ticket count and ticket price must be greater than zero.");
        double subtotal = numberOfTickets * ticketPrice;
        return subtotal + (subtotal * VAT_RATE);
    }

    @Override
    public boolean ValidateData(MovieTicketData data) {
        return data != null
                && data.getMovieName() != null
                && !data.getMovieName().trim().isEmpty()
                && data.getNumberOfTickets() > 0
                && Double.isFinite(data.getTicketPrice())
                && data.getTicketPrice() > 0;
    }
}
