package ExamPreparation.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        fishInPool = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {

        if (capacity < fishInPool.size()) {
            return;
        }

        for (Fish f : fishInPool) {

            if (f.getName().equals(fish.getName())) {
                return;
            }
        }
        fishInPool.add(fish);
    }

    public boolean remove(String name) {

        for (int i = 0; i < fishInPool.size(); i++) {

            if (fishInPool.get(i).getName().equals(name)) {
                fishInPool.remove(i);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name) {

        for (Fish fish : fishInPool) {

            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        fishInPool.forEach(fish -> stringBuilder.append(fish).append("\n"));
        return "Aquarium: " + name + " ^ Size: " + size + "\n" + stringBuilder;
    }
}
