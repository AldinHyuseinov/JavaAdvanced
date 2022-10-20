package ExamPreparation;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vowels = scanner.nextLine().split(" ");
        ArrayDeque<Character> vowelsQueue = new ArrayDeque<>();

        for (String vowel : vowels) {
            vowelsQueue.offer(vowel.charAt(0));
        }

        String[] consonants = scanner.nextLine().split(" ");
        ArrayDeque<Character> consonantsStack = new ArrayDeque<>();

        for (String consonant : consonants) {
            consonantsStack.push(consonant.charAt(0));
        }

        Set<Character> allChars = new HashSet<>();
        allChars.add('p');
        allChars.add('e');
        allChars.add('a');
        allChars.add('r');
        allChars.add('f');
        allChars.add('l');
        allChars.add('o');
        allChars.add('u');
        allChars.add('k');
        allChars.add('i');
        allChars.add('v');
        List<Character> foundCharacters = new ArrayList<>();

        while (!consonantsStack.isEmpty()) {

            if (allChars.contains(vowelsQueue.peek())) {
                foundCharacters.add(vowelsQueue.peek());
            }

            if (allChars.contains(consonantsStack.peek())) {
                foundCharacters.add(consonantsStack.peek());
            }

            vowelsQueue.offer(vowelsQueue.poll());
            consonantsStack.pop();
        }
        List<String> foundWords = new ArrayList<>();

        if (foundCharacters.containsAll(Arrays.asList('p', 'e', 'a', 'r'))) {
            foundWords.add("pear");
        }

        if (foundCharacters.containsAll(Arrays.asList('f', 'l', 'o', 'u', 'r'))) {
            foundWords.add("flour");
        }

        if (foundCharacters.containsAll(Arrays.asList('p', 'o', 'r', 'k'))) {
            foundWords.add("pork");
        }

        if (foundCharacters.containsAll(Arrays.asList('o', 'l', 'i', 'v', 'e'))) {
            foundWords.add("olive");
        }

        System.out.println("Words found: " + foundWords.size());
        foundWords.forEach(System.out::println);
    }
}
