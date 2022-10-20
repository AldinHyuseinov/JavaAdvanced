package SetsAndMaps;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLines = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < inputLines; i++) {
            String[] line = scanner.nextLine().split(" ");

            Collections.addAll(elements, line);
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
