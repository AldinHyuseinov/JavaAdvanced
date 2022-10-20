package DefiningClasses.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Person> people = new HashMap<>();

        while (!command.equals("End")) {
            String[] commandArr = command.split(" ");

            if (!people.containsKey(commandArr[0])) {
                Person person = new Person();
                person.saveInfo(commandArr);
                people.put(commandArr[0], person);
            } else {
                people.get(commandArr[0]).saveInfo(commandArr);
            }
            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        System.out.println(command);
        System.out.println(people.get(command));
    }
}
