package DefiningClasses.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private List<Pokemon> pokemonCollection;
    private List<Parents> parents;
    private List<Children> children;
    private Car car;

    public void saveInfo(String[] commandArr) {

        if (commandArr[1].equals("company")) {
            company = new Company(commandArr[2], commandArr[3], Double.parseDouble(commandArr[4]));
        } else if (commandArr[1].equals("pokemon")) {

            if (pokemonCollection == null) {
                pokemonCollection = new ArrayList<>();
            }
            pokemonCollection.add(new Pokemon(commandArr[2], commandArr[3]));
        } else if (commandArr[1].equals("parents")) {

            if (parents == null) {
                parents = new ArrayList<>();
            }
            parents.add(new Parents(commandArr[2], commandArr[3]));
        } else if (commandArr[1].equals("children")) {

            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(new Children(commandArr[2], commandArr[3]));
        } else {
            car = new Car(commandArr[2], commandArr[3]);
        }
    }

    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append("Company:\n");

        if (company != null) {
            print.append(company);
        }
        print.append("Car:\n");

        if (car != null) {
            print.append(car);
        }
        print.append("Pokemon:\n");

        if (pokemonCollection != null) {

            for (Pokemon pokemon : pokemonCollection) {
                print.append(pokemon);
            }
        }
        print.append("Parents:\n");

        if (parents != null) {

            for (Parents parent : parents) {
                print.append(parent);
            }
        }
        print.append("Children:\n");

        if (children != null) {

            for (Children child : children) {
                print.append(child);
            }
        }
        return print.toString();
    }
}
