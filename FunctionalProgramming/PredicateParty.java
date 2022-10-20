package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("Party!")) {
            String[] commandArr = command.split(" ");

            if (commandArr[0].equals("Remove")) {
                guests.removeIf(guest -> options(commandArr, guest));
            } else {
                List<String> doubleList = guests.stream().filter(guest -> options(commandArr, guest)).collect(Collectors.toList());
                guests.addAll(doubleList);
            }
            command = scanner.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guests);
            System.out.println(String.join(", ", guests) + " are going to the party!");
        }
    }

    private static boolean options(String[] commandArr, String guest) {

        if (commandArr[1].equals("StartsWith")) {
            return guest.startsWith(commandArr[2]);
        } else if (commandArr[1].equals("EndsWith")) {
            return guest.endsWith(commandArr[2]);
        } else {
            return guest.length() == Integer.parseInt(commandArr[2]);
        }
    }
}
