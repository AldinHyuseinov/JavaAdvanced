package SetsAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> data = new LinkedHashMap<>();

        for (int i = 0; i < numberOfLines; i++) {
            String[] line = scanner.nextLine().split(" ");

            if (!data.containsKey(line[0])) {
                data.put(line[0], new LinkedHashMap<>());
                data.get(line[0]).put(line[1], new ArrayList<>());
            } else {

                if (!data.get(line[0]).containsKey(line[1])) {
                    data.get(line[0]).put(line[1], new ArrayList<>());
                }
            }
            data.get(line[0]).get(line[1]).add(line[2]);
        }

        for (Map.Entry<String, Map<String, List<String>>> entry : data.entrySet()) {
            System.out.println(entry.getKey() + ":");

            for (Map.Entry<String, List<String>> countries : entry.getValue().entrySet()) {
                System.out.println("  " + countries.getKey() + " -> " + String.join(", ", countries.getValue()));
            }
        }
    }
}
