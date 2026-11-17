package za.ac.prog6112.q1;

public class MovieSalesApp {
    public static void main(String[] args) {
        String[] movies = {"Napoleon", "Oppenheimer"};
        String[] months = {"January", "February", "March"};
        int[][] monthlySales = {
            {3000, 1500, 1700},
            {3500, 1200, 1600}
        };

        MovieTickets calculator = new MovieTickets();
        int[] totals = new int[movies.length];

        System.out.println("MOVIE TICKET SALES REPORT — 2024");
        System.out.printf("%-15s %10s %10s %10s %12s%n",
                "Movie", months[0], months[1], months[2], "Total");
        for (int row = 0; row < movies.length; row++) {
            // Copy one row into a single-dimensional array for the interface method.
            int[] movieSales = monthlySales[row];
            totals[row] = calculator.TotalMovieSales(movieSales);
            System.out.printf("%-15s %10d %10d %10d %12d%n",
                    movies[row], movieSales[0], movieSales[1], movieSales[2], totals[row]);
        }
        System.out.println("Top performing movie: " + calculator.TopMovie(movies, totals));
    }
}
