package SetsAndMaps;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lengths = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> allNumbers = new LinkedHashSet<>();
        Set<Integer> firstSet = new HashSet<>();

        for (int i = 0; i < lengths[0]; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            firstSet.add(num);
            allNumbers.add(num);
        }

        Set<Integer> secSet = new HashSet<>();

        for (int i = 0; i < lengths[1]; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            secSet.add(num);
            allNumbers.add(num);
        }

        Set<Integer> repeatingNumbers = new LinkedHashSet<>();

        for (Integer number : allNumbers) {

            if (firstSet.contains(number) && secSet.contains(number)) {
                repeatingNumbers.add(number);
            }
        }

        for (Integer repeatingNumber : repeatingNumbers) {
            System.out.print(repeatingNumber + " ");
        }
    }
}
