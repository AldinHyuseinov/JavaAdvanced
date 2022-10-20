package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        Arrays.stream(names).forEach(System.out::println);
    }
}
