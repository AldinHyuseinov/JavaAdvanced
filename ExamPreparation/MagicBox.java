package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> secBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(secBoxStack::push);
        List<Integer> claimedItems = new ArrayList<>();

        while (!firstBoxQueue.isEmpty() && !secBoxStack.isEmpty()) {
            int sum = firstBoxQueue.peek() + secBoxStack.peek();

            if (sum % 2 == 0) {
                claimedItems.add(sum);
                firstBoxQueue.poll();
                secBoxStack.pop();
            } else {
                firstBoxQueue.offer(secBoxStack.pop());
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        int claimedItemsSum = claimedItems.stream().mapToInt(Integer::intValue).sum();

        if (claimedItemsSum >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + claimedItemsSum);
        } else {
            System.out.println("Poor prey... Value: " + claimedItemsSum);
        }
    }
}
