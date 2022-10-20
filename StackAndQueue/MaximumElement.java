package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLines = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int bigNum = Integer.MIN_VALUE;

        for (int i = 0; i < inputLines; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            switch (input[0]) {
                case "1":
                    stack.push(Integer.parseInt(input[1]));
                    break;
                case "2":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "3":
                    int size = stack.size();

                    for (int j = 0; j < size; j++) {
                        int num = stack.pop();

                        if (num > bigNum) {
                            bigNum = num;
                        }
                    }
                    System.out.println(bigNum);
                    break;
            }
        }
    }
}