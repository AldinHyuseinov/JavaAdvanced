package ExamPreparation.easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        data = new ArrayList<>();
        this.material = material;
        this.capacity = capacity;
    }

    public void addEgg(Egg egg) {

        if (capacity > data.size()) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {

        for (int i = 0; i < data.size(); i++) {

            if (data.get(i).getColor().equals(color)) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        int strongestEgg = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < data.size(); i++) {
            int currentStrength = data.get(i).getStrength();

            if (currentStrength > strongestEgg) {
                strongestEgg = currentStrength;
                index = i;
            }
        }
        return data.get(index);
    }

    public Egg getEgg(String color) {

        for (Egg egg : data) {

            if (egg.getColor().equals(color)) {
                return egg;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder(material + " basket contains:\n");

        for (Egg egg : data) {
            sb.append(egg).append("\n");
        }
        return sb.toString();
    }
}
