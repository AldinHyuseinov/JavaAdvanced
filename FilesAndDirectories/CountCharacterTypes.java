package FilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\workspace\\AdvancedStart\\src\\FilesAndDirectories\\input.txt"));
        String line = reader.readLine();
        Map<String, Integer> characterCount = new LinkedHashMap<>();
        characterCount.put("Vowels: ", 0);
        characterCount.put("Consonants: ", 0);
        characterCount.put("Punctuation: ", 0);

        while (line != null) {

            for (char c : line.toCharArray()) {

                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    characterCount.put("Vowels: ", characterCount.get("Vowels: ") + 1);
                } else if (c == '!' || c == ',' || c == '.' || c == '?') {
                    characterCount.put("Punctuation: ", characterCount.get("Punctuation: ") + 1);
                } else if (c != ' ') {
                    characterCount.put("Consonants: ", characterCount.get("Consonants: ") + 1);
                }
            }
            line = reader.readLine();
        }
        PrintWriter writer = new PrintWriter("output.txt");

        for (Map.Entry<String, Integer> entry : characterCount.entrySet()) {
            writer.println(entry.getKey() + entry.getValue());
        }
        reader.close();
        writer.close();
    }
}
