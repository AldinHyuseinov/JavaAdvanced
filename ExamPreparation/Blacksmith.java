package ExamPreparation;

import java.util.*;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] steelArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();

        for (int steel : steelArr) {
            steelQueue.offer(steel);
        }

        int[] carbonArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();

        for (int carbon : carbonArr) {
            carbonStack.push(carbon);
        }
        Map<String, Integer> swords = new TreeMap<>();

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {

            switch (steelQueue.peek() + carbonStack.peek()) {
                case 70:
                    putSwords(swords, "Gladius: ");
                    steelQueue.poll();
                    carbonStack.pop();
                    break;
                case 80:
                    putSwords(swords, "Shamshir: ");
                    steelQueue.poll();
                    carbonStack.pop();
                    break;
                case 90:
                    putSwords(swords, "Katana: ");
                    steelQueue.poll();
                    carbonStack.pop();
                    break;
                case 110:
                    putSwords(swords, "Sabre: ");
                    steelQueue.poll();
                    carbonStack.pop();
                    break;
                default:
                    steelQueue.poll();
                    carbonStack.push(carbonStack.pop() + 5);
                    break;
            }
        }

        if (swords.isEmpty()) {
            System.out.println("You did not have enough resources to forge a sword.");
        } else {
            int total = 0;

            for (int amount : swords.values()) {
                total += amount;
            }

            System.out.println("You have forged " + total + " swords.");
        }

        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");

            while (!steelQueue.isEmpty()) {
                System.out.print(steelQueue.poll());

                if (steelQueue.size() >= 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");

            while (!carbonStack.isEmpty()) {
                System.out.print(carbonStack.pop());

                if (carbonStack.size() >= 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        for (Map.Entry<String, Integer> entry : swords.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }

    private static void putSwords(Map<String, Integer> swords, String sword) {

        if (!swords.containsKey(sword)) {
            swords.put(sword, 1);
        } else {
            swords.put(sword, swords.get(sword) + 1);
        }
    }
}
