package za.ac.prog6112.q2;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.Locale;

public class CinemaApp extends JFrame {
    private final JComboBox<String> movieBox =
            new JComboBox<>(new String[]{"Napoleon", "Oppenheimer", "Damsel"});
    private final JTextField ticketCountField = new JTextField(10);
    private final JTextField ticketPriceField = new JTextField(10);
    private final JTextArea reportArea = new JTextArea(12, 38);
    private final MovieTickets calculator = new MovieTickets();
    private final NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("en", "ZA"));

    public CinemaApp() {
        super("Cinema Movie Ticket Sales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel inputs = new JPanel(new GridLayout(3, 2, 8, 8));
        inputs.setBorder(BorderFactory.createTitledBorder("Ticket details"));
        inputs.add(new JLabel("Movie:")); inputs.add(movieBox);
        inputs.add(new JLabel("Number of tickets:")); inputs.add(ticketCountField);
        inputs.add(new JLabel("Ticket price:")); inputs.add(ticketPriceField);
        add(inputs, BorderLayout.NORTH);

        reportArea.setEditable(false);
        reportArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        file.add(exit);
        JMenu tools = new JMenu("Tools");
        JMenuItem process = new JMenuItem("Process");
        JMenuItem clear = new JMenuItem("Clear");
        process.addActionListener(e -> processSale());
        clear.addActionListener(e -> clearForm());
        tools.add(process); tools.add(clear);
        bar.add(file); bar.add(tools);
        setJMenuBar(bar);

        JPanel actions = new JPanel();
        JButton processButton = new JButton("Process");
        JButton clearButton = new JButton("Clear");
        processButton.addActionListener(e -> processSale());
        clearButton.addActionListener(e -> clearForm());
        actions.add(processButton); actions.add(clearButton);
        add(actions, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void processSale() {
        try {
            String movie = (String) movieBox.getSelectedItem();
            int count = Integer.parseInt(ticketCountField.getText().trim());
            double price = Double.parseDouble(ticketPriceField.getText().trim());
            MovieTicketData data = new MovieTicketData(movie, count, price);
            if (!calculator.ValidateData(data)) {
                JOptionPane.showMessageDialog(this,
                        "Enter a movie name, a ticket count greater than zero, and a ticket price greater than zero.",
                        "Invalid data", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double subtotal = count * price;
            double vat = subtotal * MovieTickets.VAT_RATE;
            double total = calculator.CalculateTotalTicketPrice(count, price);
            String report = "MOVIE TICKET SALES REPORT\n"
                    + "----------------------------------------\n"
                    + "Movie:              " + movie + "\n"
                    + "Number of tickets:  " + count + "\n"
                    + "Ticket price:       " + currency.format(price) + "\n"
                    + "Subtotal:           " + currency.format(subtotal) + "\n"
                    + "VAT (14%):          " + currency.format(vat) + "\n"
                    + "Total incl. VAT:    " + currency.format(total) + "\n";
            reportArea.setText(report);
            Files.writeString(Path.of("report.txt"), report);
            JOptionPane.showMessageDialog(this, "Report saved to report.txt");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ticket count must be a whole number and ticket price must be numeric.",
                    "Invalid input", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save report.txt: " + ex.getMessage(),
                    "File error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        movieBox.setSelectedIndex(0);
        ticketCountField.setText("");
        ticketPriceField.setText("");
        reportArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CinemaApp().setVisible(true));
    }
}
