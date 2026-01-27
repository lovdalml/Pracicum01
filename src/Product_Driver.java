import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Product_Driver {

    public static void main(String[] args) {
        ArrayList<Product> product = new ArrayList<>();

        // Read from the file
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\Productdata.txt");

        try {
            InputStream in = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the CSV line
                String[] parts = line.split(",");

                if (parts.length == 4) {
                    String ID = parts[0];
                    String pName = parts[1];
                    String descript = parts[2];
                    int Cost = Integer.parseInt(parts[3]);

                    Product p = new Product(ID, pName, descript, Cost);
                    product.add(p);
                }
            }
            reader.close();

            System.out.println("Successfully read " + product.size() + " products from file!\n");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        // Display the products
        for (Product p : product) {
            System.out.println("=".repeat(50));
            System.out.println(p);
            System.out.println();
            System.out.println("Person Details:");
            System.out.println("ID Number: " + p.getIDNum());
            System.out.println("product name: " + p.getPName());
            System.out.println("Description: " + p.getDescript());
            System.out.println("Cost: " + p.getCost());
            System.out.println();
            System.out.println("CSV: " + p.toCSVDataString());
            System.out.println("JSON: " + p.toJSONDataStringFormatted());
            System.out.println("XML: " + p.toXMLDataString());
            System.out.println();
        }


    }
}
