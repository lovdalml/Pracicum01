import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Person_Driver {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        // Read from the file
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestdata.txt");

        try {
            InputStream in = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the CSV line
                String[] parts = line.split(",");

                if (parts.length == 5) {
                    String id = parts[0];
                    String firstName = parts[1];
                    String lastName = parts[2];
                    String title = parts[3];
                    int yob = Integer.parseInt(parts[4]);

                    Person p = new Person(id, firstName, lastName, title, yob);
                    people.add(p);
                }
            }
            reader.close();

            System.out.println("Successfully read " + people.size() + " people from file!\n");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        for (Person p : people) {
            System.out.println("=".repeat(50));
            System.out.println(p);
            System.out.println();
            System.out.println("Person Details:");
            System.out.println("ID Number: " + p.getIDNum());
            System.out.println("First Name: " + p.getFirstName());
            System.out.println("Last Name: " + p.getLastName());
            System.out.println("Title: " + p.getTitle());
            System.out.println("Year of Birth: " + p.getYob());
            System.out.println();
            System.out.println("Full Name: " + p.getFullName());
            System.out.println("Formal Name: " + p.getFormalName());
            System.out.println();
            System.out.println("CSV Data String:");
            System.out.println(p.toCSVDataString());
            System.out.println();
            System.out.println("JSON Data String:");
            System.out.println(p.toJSONDataString());
            System.out.println();
            System.out.println("XML Data String:");
            System.out.println(p.toXMLDataString());
            System.out.println();
            System.out.println("Formatted JSON Data String:");
            System.out.println(p.toJSONDataStringFormatted());
            System.out.println();
        }
    }








}
