package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] op = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < op[0]; i++) {
            queue.add(numbers[i]);
        }

        for (int i = 0; i < op[1]; i++) {
            queue.remove();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (queue.contains(op[2])) {
            System.out.println(true);
        } else {
            int minNum = Integer.MAX_VALUE;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int num = queue.remove();

                if (num < minNum) {
                    minNum = num;
                }
            }
            System.out.println(minNum);
        }
    }
}
