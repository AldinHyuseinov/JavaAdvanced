package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    numbers = Arrays.stream(numbers).map(number -> ++number).toArray();
                    break;
                case "multiply":
                    numbers = Arrays.stream(numbers).map(number -> number * 2).toArray();
                    break;
                case "subtract":
                    numbers = Arrays.stream(numbers).map(number -> --number).toArray();
                    break;
                case "print":
                    Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
