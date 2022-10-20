package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lastNum = Integer.parseInt(scanner.nextLine());
        List<Integer> numList = new ArrayList<>();

        for (int i = 1; i <= lastNum; i++) {
            numList.add(i);
        }

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> predicateList = new ArrayList<>();

        for (int number : numbers) {
            predicateList = numList.stream().filter(num -> num % number == 0).collect(Collectors.toList());
        }
        predicateList.forEach(e -> System.out.print(e + " "));
    }
}
