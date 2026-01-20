import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public  static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> lines = new ArrayList<>();

        final int FIELDS_LENGTH = 4;

        String id, productname, description;
        int cost;

        try {

            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    lines.add(rec);
                    line++;

                    System.out.println("\nReading " + selectedFile.getName() +": line" + line);

                }
                reader.close();
                System.out.println(selectedFile.getName() + " has been read");


                String[] fields;
                for (String l : lines) {
                    fields = l.split(",");
                    if (fields.length == FIELDS_LENGTH) {
                        id = fields[0].trim();
                        productname = fields[1].trim();
                        description = fields[2].trim();
                        cost = Integer.parseInt(fields[3].trim());

                        System.out.printf("\n%-8s%-25s%-25s%-6s%n", id, description, productname, cost);
                    } else {
                        System.out.printf("\nError with record: (expected " + FIELDS_LENGTH + "fields, got" + fields.length + "): " + l);
                    }
                }

            }
            else
            {
                System.out.println("No file selected, or no file found");
                System.out.println("Run the program again!");
                System.exit(0);

            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }





    }





}
