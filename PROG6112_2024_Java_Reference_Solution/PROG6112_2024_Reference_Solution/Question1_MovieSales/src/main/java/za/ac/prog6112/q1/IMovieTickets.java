package za.ac.prog6112.q1;

/** Operations required for the movie ticket sales report. */
public interface IMovieTickets {
    int TotalMovieSales(int[] movieTicketSales);
    String TopMovie(String[] movies, int[] totalSales);
}
