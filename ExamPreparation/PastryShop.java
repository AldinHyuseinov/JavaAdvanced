package ExamPreparation;

import java.util.*;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquidsArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();

        for (int liquid : liquidsArr) {
            liquidsQueue.offer(liquid);
        }

        int[] ingredientsArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        for (int ingredient : ingredientsArr) {
            ingredientsStack.push(ingredient);
        }

        Map<String, Integer> pastries = new TreeMap<>();
        pastries.put("Biscuit: ", 0);
        pastries.put("Cake: ", 0);
        pastries.put("Pastry: ", 0);
        pastries.put("Pie: ", 0);
        boolean cookedAll = false;

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            switch (liquidsQueue.peek() + ingredientsStack.peek()) {
                case 25:
                    pastries.put("Biscuit: ", pastries.get("Biscuit: ") + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 50:
                    pastries.put("Cake: ", pastries.get("Cake: ") + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 75:
                    pastries.put("Pastry: ", pastries.get("Pastry: ") + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 100:
                    pastries.put("Pie: ", pastries.get("Pie: ") + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                default:
                    liquidsQueue.poll();
                    int ingredient = ingredientsStack.pop() + 3;
                    ingredientsStack.push(ingredient);
                    break;
            }

            if (pastries.get("Biscuit: ") >= 1 && pastries.get("Cake: ") >= 1 && pastries.get("Pastry: ") >= 1 && pastries.get("Pie: ") >= 1) {
                cookedAll = true;
            }
        }

        if (cookedAll) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");

            while (!liquidsQueue.isEmpty()) {
                System.out.print(liquidsQueue.poll());

                if (liquidsQueue.size() >= 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");

            while (!ingredientsStack.isEmpty()) {
                System.out.print(ingredientsStack.pop());

                if (ingredientsStack.size() >= 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        pastries.entrySet().stream().filter(p -> !p.getKey().equals("Pastry: ")).forEach(p -> System.out.println(p.getKey() + p.getValue()));
        System.out.println("Pastry: " + pastries.get("Pastry: "));
    }
}