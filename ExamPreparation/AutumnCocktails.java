package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(freshnessStack::push);

        Map<String, Integer> cocktailsAndCount = new TreeMap<>();

        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {

            switch (ingredientsQueue.peek() * freshnessStack.peek()) {
                case 150:
                    makeCocktails(cocktailsAndCount, "Pear Sour");
                    removeItems(ingredientsQueue, freshnessStack);
                    break;
                case 250:
                    makeCocktails(cocktailsAndCount, "The Harvest");
                    removeItems(ingredientsQueue, freshnessStack);
                    break;
                case 300:
                    makeCocktails(cocktailsAndCount, "Apple Hinny");
                    removeItems(ingredientsQueue, freshnessStack);
                    break;
                case 400:
                    makeCocktails(cocktailsAndCount, "High Fashion");
                    removeItems(ingredientsQueue, freshnessStack);
                    break;
                case 0:

                    if (ingredientsQueue.peek() == 0) {
                        ingredientsQueue.poll();
                    } else {
                        freshnessStack.pop();
                    }
                    break;
                default:
                    freshnessStack.pop();
                    ingredientsQueue.offer(ingredientsQueue.poll() + 5);
                    break;
            }
        }

        if (cocktailsAndCount.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int sum = 0;

        if (!ingredientsQueue.isEmpty()) {
            sum += ingredientsQueue.stream().mapToInt(Integer::intValue).sum();
        }

        if (!freshnessStack.isEmpty()) {
            sum += freshnessStack.stream().mapToInt(Integer::intValue).sum();
        }

        if (sum > 0) {
            System.out.println("Ingredients left: " + sum);
        }

        if (!cocktailsAndCount.isEmpty()) {
            cocktailsAndCount.forEach((cocktail, count) -> System.out.println(" # " + cocktail + " --> " + count));
        }
    }

    private static void removeItems(ArrayDeque<Integer> ingredientsQueue, ArrayDeque<Integer> freshnessStack) {
        ingredientsQueue.poll();
        freshnessStack.pop();
    }

    private static void makeCocktails(Map<String, Integer> cocktailsAndCount, String cocktailName) {

        if (cocktailsAndCount.containsKey(cocktailName)) {
            cocktailsAndCount.put(cocktailName, cocktailsAndCount.get(cocktailName) + 1);
        } else {
            cocktailsAndCount.put(cocktailName, 1);
        }
    }
}
