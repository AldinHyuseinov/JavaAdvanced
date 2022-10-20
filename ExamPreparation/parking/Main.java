package ExamPreparation.parking;

import ExamPreparation.dealership.Car;
import ExamPreparation.dealership.Dealership;

public class Main {
    public static void main(String[] args) {
        Dealership parking = new Dealership("Kokoland's ExamPreparation.parking", 10);
        Car kokoCar = new Car("Lamborghini", "Aventador", 2018);
        Car car = new Car("Opel", "Astra", 2010);
        Car car1 = new Car("VW", "Golf 5", 2013);
        Car car2 = new Car("Toyota", "Corolla", 2015);
        Car car3 = new Car("Honda", "Civic", 2009);
        Car car4 = new Car("Peugeot", "206", 2006);

        System.out.println(kokoCar);
        parking.add(kokoCar);
        parking.add(car);
        parking.add(car1);
        parking.add(car2);
        parking.add(car3);
        parking.add(car4);

        System.out.println(parking.buy("Lamborghini", "Aventador"));
        System.out.println(parking.buy("Lamborghini", "Nemam"));
        System.out.println(parking.getLatestCar());
        System.out.println(parking.getCar("Opel", "Astra"));
        System.out.println(parking.getCount());
        System.out.println(parking.getStatistics());
    }
}
