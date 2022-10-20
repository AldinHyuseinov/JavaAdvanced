package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tulipsArr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();

        for (int tulip : tulipsArr) {
            tulipsStack.push(tulip);
        }

        int[] daffodilsArr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();

        for (int daffodil : daffodilsArr) {
            daffodilsQueue.offer(daffodil);
        }

        int bouquetCount = 0;
        int storedFlowersSum = 0;

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int flowersSum = tulipsStack.peek() + daffodilsQueue.peek();

            if (flowersSum == 15) {
                tulipsStack.pop();
                daffodilsQueue.poll();
                bouquetCount++;
            } else if (flowersSum > 15) {
                tulipsStack.push(tulipsStack.pop() - 2);
            } else {
                tulipsStack.pop();
                daffodilsQueue.poll();
                storedFlowersSum += flowersSum;
            }
        }

        while (storedFlowersSum >= 15) {
            bouquetCount++;
            storedFlowersSum -= 15;
        }

        if (bouquetCount >= 5) {
            System.out.println("You made it! You go to the competition with " + bouquetCount + " bouquets!");
        } else {
            System.out.println("You failed... You need more " + (5 - bouquetCount) + " bouquets.");
        }
    }
}