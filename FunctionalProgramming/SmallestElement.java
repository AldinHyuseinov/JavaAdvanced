package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int minNum = numbers.stream().mapToInt(Integer::intValue).min().getAsInt();
        int index = numbers.lastIndexOf(minNum);
        System.out.println(index);
    }
}
