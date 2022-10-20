package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] op = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < op[0]; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < op[1]; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (stack.contains(op[2])) {
            System.out.println(true);
        } else {
            int smallNum = Integer.MAX_VALUE;
            int size = stack.size();

            for (int i = 0; i < size; i++) {
                int num = stack.pop();

                if (num < smallNum) {
                    smallNum = num;
                }
            }
            System.out.println(smallNum);
        }
    }
}
