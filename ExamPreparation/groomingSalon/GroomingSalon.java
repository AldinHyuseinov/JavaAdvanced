package ExamPreparation.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {

        if (capacity > data.size()) {
            data.add(pet);
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

    public Pet getPet(String name, String owner) {

        for (Pet pet : data) {

            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder();
        result.append("The grooming salon has the following clients:\n");

        for (Pet pet : data) {
            result.append(pet.getName()).append(" ").append(pet.getOwner()).append("\n");
        }
        return result.toString();
    }
}
