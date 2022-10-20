package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] malesArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();

        for (int male : malesArr) {
            malesStack.push(male);
        }

        int[] femalesArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();

        for (int female : femalesArr) {
            femalesQueue.offer(female);
        }
        int matchesCount = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int maleValue = malesStack.peek();
            int femaleValue = femalesQueue.peek();

            if (maleValue <= 0) {
                malesStack.pop();
                continue;
            } else if (maleValue % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }

            if (femaleValue <= 0) {
                femalesQueue.poll();
                continue;
            } else if (femaleValue % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }

            if (maleValue == femaleValue) {
                malesStack.pop();
                femalesQueue.poll();
                matchesCount++;
            } else {
                femalesQueue.poll();
                malesStack.push(malesStack.pop() - 2);
            }
        }

        System.out.println("Matches: " + matchesCount);

        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");

            while (!malesStack.isEmpty()) {
                System.out.print(malesStack.pop());

                if (malesStack.size() >= 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");

            while (!femalesQueue.isEmpty()) {
                System.out.print(femalesQueue.poll());

                if (femalesQueue.size() >= 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
