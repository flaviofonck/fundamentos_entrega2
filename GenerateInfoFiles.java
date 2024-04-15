package fundamentos_programacion;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;

/**
 * This class generates information files required for the application.
 */
public class GenerateInfoFiles {

    private static final String SALESMEN_FILE = "salesmen_info.txt";
    private static final String PRODUCTS_FILE = "products_info.txt";

    /**
     * Main method to generate necessary files for the application.
     */
    public static void main(String[] args) {
        // Generate random values for productsCount, salesmanCount, and randomSalesCount
        int productsCount = generateRandomInteger(500, 999);
        int salesmanCount = generateRandomInteger(10, 20);
        int randomSalesCount = generateRandomInteger(30, 60);

        System.out.println("CREATING THE NECESSARY FILES FOR THE APP\n");

        // Delete existing salesman sales files
        deleteSalesFiles();

        // Generate Products file
        System.out.println("Creating Products file...");
        createProductsFile(productsCount);
        System.out.println("Products file created successfully!");

        // Generate Salesmen file
        System.out.println("Creating Salesmen file...");
        createSalesmenInfoFile(salesmanCount, randomSalesCount, productsCount);
        System.out.println("Salesmen file created successfully!");

        System.out.println("\nFiles created successfully!"); // Indicate completion
    }

    /**
     * Deletes all existing sales files in the current directory.
     */
    private static void deleteSalesFiles() {
        File folder = new File(".");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().startsWith("salesman_") && file.getName().endsWith("_sales.txt")) {
                    file.delete();
                }
            }
        }
    }

    /**
     * Generates a file containing product information.
     *
     * @param productsCount The number of products to include in the file.
     */
    private static void createProductsFile(int productsCount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCTS_FILE))) {
            writer.write("ID, NombreProducto, Precio\n");

            Random random = new Random();
            for (int i = 1; i <= productsCount; i++) {
                String productId = String.format("Pdto_%05d", i);
                String productName = "Producto" + i;
                int price = (int) Math.round(random.nextDouble() * 10 + (500 - 10));

                writer.write(productId + ", " + productName + ", " + price + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error creating products file: " + e.getMessage());
        }
    }

    /**
     * Generates a file containing salesman information and individual sales files for each salesman.
     *
     * @param salesmanCount    The number of salesmen to include in the file.
     * @param randomSalesCount The number of random sales records for each salesman.
     * @param productsCount    The total number of products available.
     */
    private static void createSalesmenInfoFile(int salesmanCount, long randomSalesCount, int productsCount) {
        Random random = new Random();
        List<String> firstNames = loadNamesFromFile("firstNames.txt");
        List<String> lastNames = loadNamesFromFile("lastNames.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SALESMEN_FILE))) {
            writer.write("ID, Nombre, Apellido, Ventas\n");

            for (int i = 1; i <= salesmanCount; i++) {
                int firstNameIndex = random.nextInt(firstNames.size());
                int lastNameIndex = random.nextInt(lastNames.size());
                String firstName = firstNames.get(firstNameIndex);
                String lastName = lastNames.get(lastNameIndex);
                int sales = (int) Math.round(random.nextDouble() * 100);

                writer.write(i + ", " + firstName + ", " + lastName + ", " + sales + "\n");

                createSalesFile(randomSalesCount, firstName + "_" + lastName, i, productsCount);
            }
        } catch (IOException e) {
            System.err.println("Error creating salesmen file: " + e.getMessage());
        }
    }

    /**
     * Generates a sales record file for a specific salesman.
     *
     * @param randomSalesCount The number of random sales records to generate.
     * @param salesmanName     The salesman's name.
     * @param salesmanId       The salesman's ID.
     * @param productsCount    The total number of products available.
     */
    private static void createSalesFile(long randomSalesCount, String salesmanName, int salesmanId, int productsCount) {
        // Construct the file name based on the salesman's name
        String fileName = "salesman_" + salesmanName + "_sales.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write header line to the sales file
            writer.write("ID Vendedor, ID Producto, Valor Venta\n");

            // Initialize random number generator
            Random random = new Random();

            // Generate random sales records
            for (int i = 0; i < randomSalesCount; i++) {
                // Generate a random product ID
                String productId = String.format("Pdto_%05d", random.nextInt(productsCount) + 1);
                // Generate a random sale value within the range [10, 500]
                int saleValue = random.nextInt(491) + 10;

                // Write sales record to the file
                writer.write(salesmanId + ", " + productId + ", " + saleValue + "\n");
            }
        } catch (IOException e) {
            // Print error message if there's an exception while creating the file
            System.err.println("Error creating sales file for " + salesmanName + ": " + e.getMessage());
        }
    }

    /**
     * Loads names from a file and returns them as a list of strings.
     *
     * @param fileName The name of the file to read names from.
     * @return A list containing the names read from the file.
     */
    private static List<String> loadNamesFromFile(String fileName) {
        List<String> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String name;
            while ((name = reader.readLine()) != null) {
                names.add(name);
            }
        } catch (IOException e) {
            System.err.println("Error reading names file: " + e.getMessage());
        }
        return names;
    }

    /**
     * Generates a random integer between a minimum and maximum value.
     *
     * @param min The minimum value (inclusive).
     * @param max The maximum value (inclusive).
     * @return A random integer between min and max.
     */
    private static int generateRandomInteger(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}