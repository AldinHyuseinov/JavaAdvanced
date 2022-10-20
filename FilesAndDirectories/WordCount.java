package FilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\workspace\\AdvancedStart\\src\\FilesAndDirectories\\words.txt"));
        String line = reader.readLine();
        List<String> words = new ArrayList<>();

        while (line != null) {
            words = Arrays.stream(line.split(" ")).collect(Collectors.toList());
            line = reader.readLine();
        }

        BufferedReader reader2 = new BufferedReader(new FileReader("D:\\workspace\\AdvancedStart\\src\\FilesAndDirectories\\text.txt"));
        line = reader2.readLine();
        List<String> textWords = new ArrayList<>();

        while (line != null) {
            textWords = Arrays.stream(line.split(" ")).collect(Collectors.toList());
            line = reader2.readLine();
        }

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            int index = textWords.indexOf(word);

            while (index != -1) {

                if (!wordCount.containsKey(word)) {
                    wordCount.put(word, 1);
                } else {
                    wordCount.put(word, wordCount.get(word) + 1);
                }
                textWords.remove(index);
                index = textWords.indexOf(word);
            }
        }

        PrintWriter writer = new PrintWriter("results.txt");
        wordCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
    }
}
