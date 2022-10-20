package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(numbers).filter(num -> num % 2 == 0).sorted().forEach(number -> System.out.print(number + " "));
        Arrays.stream(numbers).filter(num -> num % 2 != 0).sorted().forEach(number -> System.out.print(number + " "));
    }
}
