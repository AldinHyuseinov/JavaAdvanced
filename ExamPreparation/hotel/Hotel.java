package ExamPreparation.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Person person) {

        if (capacity > roster.size()) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {

        for (int i = 0; i < roster.size(); i++) {

            if (roster.get(i).getName().equals(name)) {
                roster.remove(i);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        return roster.stream().filter(person -> person.getName().equals(name) && person.getHometown().equals(hometown)).findFirst().orElse(null);
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder("The people in the ExamPreparation.hotel " + name + " are:\n");
        roster.forEach(person -> stringBuilder.append(person).append("\n"));
        return stringBuilder.toString().trim();
    }
}
