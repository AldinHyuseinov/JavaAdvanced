package DefiningClasses.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] info = scanner.nextLine().split(" ");
            int engineSpeed = Integer.parseInt(info[1]);
            int enginePower = Integer.parseInt(info[2]);
            int cargoWeight = Integer.parseInt(info[3]);
            int tire1Age = Integer.parseInt(info[6]);
            int tire2Age = Integer.parseInt(info[8]);
            int tire3Age = Integer.parseInt(info[10]);
            int tire4Age = Integer.parseInt(info[12]);
            double tire1Pressure = Double.parseDouble(info[5]);
            double tire2Pressure = Double.parseDouble(info[7]);
            double tire3Pressure = Double.parseDouble(info[9]);
            double tire4Pressure = Double.parseDouble(info[11]);

            Car car = new Car(info[0], new Engine(engineSpeed, enginePower), new Cargo(cargoWeight, info[4]),
                    new Tire(tire1Pressure, tire2Pressure, tire3Pressure, tire4Pressure, tire1Age, tire2Age, tire3Age, tire4Age));
            carList.add(car);
        }
        String command = scanner.nextLine();

        if (command.equals("fragile")) {

            for (Car car : carList) {

                if (car.fragile()) {

                    if (car.pressureCheck()) {
                        System.out.println(car.getModel());
                    }
                }
            }
        } else {

            for (Car car : carList) {

                if (!car.fragile()) {

                    if (car.enginePower()) {
                        System.out.println(car.getModel());
                    }
                }
            }
        }
    }
}
