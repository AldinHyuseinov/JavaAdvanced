package FilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\workspace\\AdvancedStart\\src\\FilesAndDirectories\\input.txt"));
        PrintWriter writer = new PrintWriter("output.txt");
        String line = reader.readLine();

        while (line != null) {
            writer.println(line.toUpperCase());
            line = reader.readLine();
        }
        reader.close();
        writer.close();
    }
}
