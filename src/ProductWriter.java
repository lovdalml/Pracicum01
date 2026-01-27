import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {
    public static void main(String[] args) {

        String ID = "";
        String pName = "";
        String descript = "";
        int Cost = 0;
        String csvRec = "";
        boolean done = false;

        Scanner in = new Scanner(System.in);
        SafeInputObject sio = new SafeInputObject();

        ArrayList<Product> prods = new ArrayList<>();
        Product prod;

        do {
            ID = sio.getNonZeroLenghtString( "Enter ID");
            pName = sio.getNonZeroLenghtString( "what product");
            descript = sio.getNonZeroLenghtString( "description of product");
            Cost = sio.getRangedInt("Enter cost of product" , 0 , 5);



            prod = new Product(ID ,  pName , descript , Cost);

            //System.out.println(rec);

            prods.add(prod);

            done = sio.getYNConfirm( "Are you done?");

        } while (!done);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\Productdata.txt");

        try {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for ( Product p : prods ) {
                csvRec = p.toCSVDataString();
                writer.write(csvRec, 0, csvRec.length()); // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
