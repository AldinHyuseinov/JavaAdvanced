package ExamPreparation.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String type, int capacity) {
        this.data = new ArrayList<>();
        this.name = type;
        this.capacity = capacity;
    }

    public void add(Car car) {

        if (capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {

        for (int i = 0; i < data.size(); i++) {

            if (data.get(i).getManufacturer().equals(manufacturer) && data.get(i).getModel().equals(model)) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {

        if (data.isEmpty()) {
            return null;
        }

        int latestYear = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < data.size(); i++) {
            int year = data.get(i).getYear();

            if (year > latestYear) {
                latestYear = year;
                index = i;
            }
        }
        return data.get(index);
    }

    public Car getCar(String manufacturer, String model) {

        for (Car car : data) {

            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder stats = new StringBuilder();
        stats.append("The cars are in a car ExamPreparation.dealership ").append(name).append(":\n");

        for (Car car : data) {
            stats.append(car).append("\n");
        }
        return stats.toString();
    }
}
