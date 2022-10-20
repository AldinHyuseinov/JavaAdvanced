package DefiningClasses.PokemonTrainer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        List<Trainer> trainers = new ArrayList<>();

        while (!command.equals("Tournament")) {
            String[] commandArr = command.split(" ");
            int pokemonHealth = Integer.parseInt(commandArr[3]);
            Trainer trainer;

            if (Trainer.indexOf(trainers, commandArr[0]) == -1) {
                trainer = new Trainer(commandArr[0], new Pokemon(commandArr[1], commandArr[2], pokemonHealth));
                trainers.add(trainer);
            } else {
                trainers.get(Trainer.indexOf(trainers, commandArr[0])).setPokemon(new Pokemon(commandArr[1], commandArr[2], pokemonHealth));
            }
            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        List<String> elements = new ArrayList<>();

        while (!command.equals("End")) {
            elements.add(command);
            command = scanner.nextLine();
        }

        for (String element : elements) {

            for (Trainer trainer : trainers) {
                trainer.elementCheck(element);
            }
        }
        trainers.stream().sorted(Comparator.comparing(Trainer::getNumberOfBadges).reversed()).forEach(System.out::println);
    }
}
