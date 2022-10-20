package DefiningClasses.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonCollection;

    public Trainer(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemonCollection = new ArrayList<>();
        pokemonCollection.add(pokemon);
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setPokemon(Pokemon pokemon) {
        pokemonCollection.add(pokemon);
    }

    public static int indexOf(List<Trainer> trainers, String name) {

        for (int i = 0; i < trainers.size(); i++) {

            if (trainers.get(i).name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void elementCheck(String element) {

        for (Pokemon pokemon : pokemonCollection) {

            if (pokemon.getElement().equals(element)) {
                numberOfBadges++;
                return;
            }
        }

        for (int j = 0; j < pokemonCollection.size(); j++) {
            pokemonCollection.get(j).setHealth(pokemonCollection.get(j).getHealth() - 10);

            if (pokemonCollection.get(j).getHealth() <= 0) {
                pokemonCollection.remove(j);
                j--;
            }
        }
    }

    public String toString() {
        return name + " " + numberOfBadges + " " + pokemonCollection.size();
    }
}
