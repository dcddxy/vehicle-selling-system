import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptApp {
    public static void main(String[] args) {
        ArrayList<Integer> vehicleCodes = new ArrayList();
        Customer C = new Customer();
        int totalCarsBought = vehicleCodes.size();
        SwingUtilities.invokeLater(() -> {
            try
            {
                generateReceipt(C, vehicleCodes, totalCarsBought);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void generateReceipt(Customer customer,ArrayList<Integer> vehicleCodes , int totalCarsBought) throws IOException
    {
        JFrame frame = new JFrame("Receipt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        // Create a JPanel for the receipt content
        JPanel receiptPanel = new JPanel();
        receiptPanel.setLayout(new BoxLayout(receiptPanel, BoxLayout.Y_AXIS));
        receiptPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add customer information
        JLabel customerLabel = new JLabel("Customer Information:");
        customerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        receiptPanel.add(customerLabel);

        // Use the provided customer parameter
        addLabelWithValue(receiptPanel, "Name", customer.getCustName());
        addLabelWithValue(receiptPanel, "IC Number", customer.getCustIC());
        addLabelWithValue(receiptPanel, "Phone Number", customer.getCustNumber());
        addLabelWithValue(receiptPanel, "Email", customer.getCustEmail());
        addLabelWithValue(receiptPanel, "Street Name", customer.getCustStreet());
        addLabelWithValue(receiptPanel, "City", customer.getCustCity());
        addLabelWithValue(receiptPanel, "Zip Code", Integer.toString(customer.getCustZip()));
        addLabelWithValue(receiptPanel, "State", customer.getCustState());

        // Add car details
        JLabel carLabel = new JLabel("Cars Bought:");
        carLabel.setFont(new Font("Arial", Font.BOLD, 16));
        receiptPanel.add(carLabel);

        // Replace the following lines with actual car data
        for (int i = 0; i < totalCarsBought; i++)
        {
            addLabelWithValue(receiptPanel, "Vehicle Code", Integer.toString(vehicleCodes.get(i)));
        }

        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        // Add total cars and time of purchase
        addLabelWithValue(receiptPanel, "Total Cars Bought", Integer.toString(totalCarsBought));
        // Add the current time to the receipt
        JLabel timeLabel = new JLabel("Time of Purchase: " + formattedTime);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        receiptPanel.add(timeLabel);

        frame.add(receiptPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void addLabelWithValue(Container container, String label, String value) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelComponent = new JLabel(label + ":");
        labelComponent.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel valueComponent = new JLabel(value);
        valueComponent.setFont(new Font("Arial", Font.PLAIN, 14));

        panel.add(labelComponent);
        panel.add(valueComponent);
        container.add(panel);
    }
}
