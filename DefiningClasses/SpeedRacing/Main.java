package DefiningClasses.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carCollection = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] info = scanner.nextLine().split(" ");
            double fuelAmount = Double.parseDouble(info[1]);
            double fuelCost = Double.parseDouble(info[2]);

            Car car = new Car(info[0], fuelAmount, fuelCost);
            carCollection.putIfAbsent(info[0], car);
        }
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] commandArr = command.split(" ");
            carCollection.get(commandArr[1]).drive(Integer.parseInt(commandArr[2]));
            command = scanner.nextLine();
        }

        for (Map.Entry<String, Car> entry : carCollection.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
