package FilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\workspace\\AdvancedStart\\src\\FilesAndDirectories\\input.txt"));

        String line = reader.readLine();
        long bytes = 0;

        while (line != null) {

            for (char c : line.toCharArray()) {
                bytes += c;
            }
            line = reader.readLine();
        }
        System.out.println(bytes);
    }
}
