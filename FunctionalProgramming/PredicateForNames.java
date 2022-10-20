package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split(" ");
        Arrays.stream(names).filter(name -> name.length() <= length).forEach(System.out::println);
    }
}
