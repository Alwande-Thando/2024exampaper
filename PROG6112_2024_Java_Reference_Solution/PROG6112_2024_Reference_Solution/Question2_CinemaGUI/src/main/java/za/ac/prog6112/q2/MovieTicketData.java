package za.ac.prog6112.q2;

/** Holds the values entered for one movie-ticket purchase. */
public class MovieTicketData {
    private final String movieName;
    private final int numberOfTickets;
    private final double ticketPrice;

    public MovieTicketData(String movieName, int numberOfTickets, double ticketPrice) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
    }
    public String getMovieName() { return movieName; }
    public int getNumberOfTickets() { return numberOfTickets; }
    public double getTicketPrice() { return ticketPrice; }
}
