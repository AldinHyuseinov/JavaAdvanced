package DefiningClasses.SpeedRacing;

public class Car {
    String model;
    double fuelAmount;
    double fuelCostKm;
    int distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCostKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostKm = fuelCostKm;
    }

    public void drive(int kmAmount) {

        if (fuelAmount >= kmAmount * fuelCostKm) {
            fuelAmount -= kmAmount * fuelCostKm;
            distanceTravelled += kmAmount;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distanceTravelled);
    }
}
