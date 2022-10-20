package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> bombEffects = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> bombCasing = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs: ", 0);
        bombs.put("Cherry Bombs: ", 0);
        bombs.put("Smoke Decoy Bombs: ", 0);
        boolean pouchNotFilled = true;

        for (int i = 0; i < bombEffects.size(); i++) {

            if (bombs.get("Datura Bombs: ") >= 3 && bombs.get("Cherry Bombs: ") >= 3 && bombs.get("Smoke Decoy Bombs: ") >= 3) {
                System.out.println("Bene! You have successfully filled the bomb pouch!");
                pouchNotFilled = false;
                break;
            }
            casingLoop:
            for (int j = bombCasing.size() - 1; j >= 0; j--) {

                switch (bombEffects.get(i) + bombCasing.get(j)) {
                    case 40:
                        bombs.put("Datura Bombs: ", bombs.get("Datura Bombs: ") + 1);
                        bombEffects.remove(i);
                        i--;
                        bombCasing.remove(j);
                        break casingLoop;
                    case 60:
                        bombs.put("Cherry Bombs: ", bombs.get("Cherry Bombs: ") + 1);
                        bombEffects.remove(i);
                        i--;
                        bombCasing.remove(j);
                        break casingLoop;
                    case 120:
                        bombs.put("Smoke Decoy Bombs: ", bombs.get("Smoke Decoy Bombs: ") + 1);
                        bombEffects.remove(i);
                        i--;
                        bombCasing.remove(j);
                        break casingLoop;
                    default:
                        bombCasing.set(j, bombCasing.get(j) - 5);
                        j++;
                        break;
                }
            }
        }

        if (pouchNotFilled) {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            for (int i = 0; i < bombEffects.size(); i++) {
                System.out.print(bombEffects.get(i));

                if (i < bombEffects.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        if (bombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");

            for (int i = 0; i < bombCasing.size(); i++) {
                System.out.print(bombCasing.get(i));

                if (i < bombCasing.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}
