package za.ac.prog6112.q1;

import java.util.Objects;

public class MovieTickets implements IMovieTickets {
    @Override
    public int TotalMovieSales(int[] movieTicketSales) {
        Objects.requireNonNull(movieTicketSales, "Sales array cannot be null");
        int total = 0;
        for (int sale : movieTicketSales) total += sale;
        return total;
    }

    @Override
    public String TopMovie(String[] movies, int[] totalSales) {
        Objects.requireNonNull(movies, "Movies cannot be null");
        Objects.requireNonNull(totalSales, "Totals cannot be null");
        if (movies.length == 0 || movies.length != totalSales.length)
            throw new IllegalArgumentException("Movie and total-sales arrays must have equal non-zero lengths");
        int best = 0;
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > totalSales[best]) best = i;
        }
        return movies[best];
    }
}
