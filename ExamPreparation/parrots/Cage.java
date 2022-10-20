package ExamPreparation.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private List<Parrot> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {

        if (capacity > data.size()) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {

        for (int i = 0; i < data.size(); i++) {

            if (data.get(i).getName().equals(name)) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {

        for (Parrot parrot : data) {

            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> sameSpeciesParrots = new ArrayList<>();

        for (Parrot parrot : data) {

            if (parrot.getSpecies().equals(species)) {
                parrot.setAvailable(false);
                sameSpeciesParrots.add(parrot);
            }
        }
        return sameSpeciesParrots;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder("Parrots available at " + name + ":\n");

        for (Parrot parrot : data) {

            if (parrot.isAvailable()) {
                result.append(parrot).append("\n");
            }
        }
        return result.toString();
    }
}
