package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLines = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> text = new ArrayDeque<>();

        for (int i = 0; i < inputLines; i++) {
            String[] command = scanner.nextLine().split(" ");

            switch (command[0]) {
                case "1":
                    text.offer(command[1]);
                    break;
                case "2":
                    int count = Integer.parseInt(command[1]);
                    StringBuilder erase = new StringBuilder(text.peek());

                    for (int j = 0; j < count; j++) {
                        erase.deleteCharAt(erase.length() - 1);
                    }
                    text.offer(erase.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(command[1]) - 1;
                    System.out.println(text.peekLast().charAt(index));
                    break;
                case "4":
                    text.pollLast();
                    break;
            }
        }
    }
}
