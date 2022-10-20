package SetsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();
        Map<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < sentence.length(); i++) {

            if (!symbols.containsKey(sentence.charAt(i))) {
                symbols.put(sentence.charAt(i), 1);
            } else {
                symbols.put(sentence.charAt(i), symbols.get(sentence.charAt(i)) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }
    }
}
