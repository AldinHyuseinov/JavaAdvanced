package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> removeFilterList = new ArrayList<>();
        String command = scanner.nextLine();

        while (!command.equals("Print")) {
            String[] commandArr = command.split(";");
            String filterTypes = commandArr[1];
            String filterParameters = commandArr[2];

            if (commandArr[0].equals("Add filter")) {
                guests.removeIf(guest -> filterTypes(removeFilterList, filterTypes, filterParameters, guest));
            } else {
                List<String> list = removeFilterList.stream().filter(guest -> filterTypes(removeFilterList, filterTypes, filterParameters, guest)).collect(Collectors.toList());
                guests.addAll(list);
            }
            command = scanner.nextLine();
        }
    }

    private static boolean filterTypes(List<String> removeFilterList, String filterTypes, String filterParameters, String guest) {

        switch (filterTypes) {
            case "Starts with":

                if (guest.startsWith(filterParameters)) {
                    removeFilterList.add(guest);
                    return true;
                }
                return false;
            case "Ends with":

                if (guest.endsWith(filterParameters)) {
                    removeFilterList.add(guest);
                    return true;
                }
                return false;
            case "Length":
                removeFilterList.add(guest);

                if (guest.length() == Integer.parseInt(filterParameters)) {
                    removeFilterList.add(guest);
                    return true;
                }
                return false;
            case "Contains":
                removeFilterList.add(guest);

                if (guest.contains(filterParameters)) {
                    removeFilterList.add(guest);
                    return true;
                }
                return false;
        }
        return false;
    }
}
