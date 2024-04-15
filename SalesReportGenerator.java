package fundamentos_programacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class generates sales reports based on data stored in sales files.
 */
public class SalesReportGenerator {

    private static final String SALESMEN_REPORT_FILE = "salesmen_report.csv";
    private static final String PRODUCTS_REPORT_FILE = "products_report.csv";

    /**
     * The main method that generates sales reports for salesmen and products.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        generateSalesmenReport();
        generateProductsReport();
        System.out.println("Reports generated successfully!");
    }

    /**
     * Generates a sales report for salesmen, including total sales for each salesman.
     */
    private static void generateSalesmenReport() {
        // Map to store total sales for each salesman
        Map<String, Integer> salesBySalesman = new HashMap<>();
        // Get the list of files in the current directory
        File folder = new File(".");
        File[] files = folder.listFiles();
        if (files != null) {
            // Iterate through each file
            for (File file : files) {
                // Check if the file is a sales file for a salesman
                if (file.isFile() && file.getName().startsWith("salesman_") && file.getName().endsWith("_sales.txt")) {
                    // Extract salesman's name from the file name
                    String salesmanName = file.getName().replace("salesman_", "").replace("_sales.txt", "");
                    // Calculate total sales for the salesman
                    int totalSales = calculateTotalSales(file);
                    // Store the total sales in the map
                    salesBySalesman.put(salesmanName, totalSales);
                }
            }
        }

        // Sort sales by salesman in descending order of total sales
        List<Map.Entry<String, Integer>> sortedSales = new ArrayList<>(salesBySalesman.entrySet());
        Collections.sort(sortedSales, Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));

        // Write the salesmen report to a CSV file
        try (FileWriter writer = new FileWriter(SALESMEN_REPORT_FILE)) {
            // Write header line
            writer.write("Nombre;Ventas\n");
            // Write data for each salesman
            for (Map.Entry<String, Integer> entry : sortedSales) {
                writer.write(entry.getKey() + ";" + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing salesmen report: " + e.getMessage());
        }
    }

    /**
     * Generates a sales report for products, including total sales and average sale value.
     */
    private static void generateProductsReport() {
        // Maps to store total sales and quantities for each product
        Map<String, Double> productSales = new HashMap<>();
        Map<String, Integer> productQuantities = new HashMap<>();
        // Get the list of files in the current directory
        File folder = new File(".");
        File[] files = folder.listFiles();
        if (files != null) {
            // Iterate through each file
            for (File file : files) {
                // Check if the file is a sales file for a salesman
                if (file.isFile() && file.getName().startsWith("salesman_") && file.getName().endsWith("_sales.txt")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        reader.readLine(); // Skip header line
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(", ");
                            String productId = parts[1];
                            double saleValue = Double.parseDouble(parts[2].replace(",", ".")); // Use dot as decimal separator
                            // Update total sales and quantities for the product
                            productSales.put(productId, productSales.getOrDefault(productId, 0.0) + saleValue);
                            productQuantities.put(productId, productQuantities.getOrDefault(productId, 0) + 1);
                        }
                    } catch (IOException | NumberFormatException e) {
                        System.err.println("Error reading or parsing sales file: " + e.getMessage());
                    }
                }
            }
        }

        // Sort products by total sales in descending order
        List<Map.Entry<String, Double>> sortedProductSales = new ArrayList<>(productSales.entrySet());
        sortedProductSales.sort(Map.Entry.<String, Double>comparingByValue().reversed());

        // Write the products report to a CSV file
        try (FileWriter writer = new FileWriter(PRODUCTS_REPORT_FILE)) {
            // Write header line
            writer.write("Producto;Cantidad;Valor;Total\n");
            // Write data for each product
            for (Map.Entry<String, Double> entry : sortedProductSales) {
                String productId = entry.getKey();
                int quantity = productQuantities.getOrDefault(productId, 0);
                double totalSales = entry.getValue();
                double unitValue = quantity != 0 ? totalSales / quantity : 0;
                // Write product data to the file
                writer.write(productId + ";" + quantity + ";" + (int) unitValue + ";" + (int) totalSales + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing products report: " + e.getMessage());
        }
    }

    /**
     * Calculates the total sales from a given sales file.
     *
     * @param file The sales file to calculate total sales from.
     * @return The total sales from the sales file.
     */
    private static int calculateTotalSales(File file) {
        int totalSales = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                totalSales += Integer.parseInt(parts[2]);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading or parsing sales file: " + e.getMessage());
        }
        return totalSales;
    }
}
