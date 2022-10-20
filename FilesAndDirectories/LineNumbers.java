package FilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\workspace\\AdvancedStart\\src\\FilesAndDirectories\\inputLineNumbers.txt"));
        PrintWriter writer = new PrintWriter("output.txt");

        String line = reader.readLine();
        int counter = 1;

        while (line != null) {
            writer.println(counter + ". " + line);
            line = reader.readLine();
            counter++;
        }
        reader.close();
        writer.close();
    }
}
