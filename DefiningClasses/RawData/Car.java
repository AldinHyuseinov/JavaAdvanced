package DefiningClasses.RawData;

public class Car {
    private String model;
    public Engine engine;
    public Cargo cargo;
    public Tire tires;

    public Car(String model, Engine engine, Cargo cargo, Tire tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public boolean fragile() {
        return cargo.getCargoType().equals("fragile");
    }

    public boolean pressureCheck() {

        if (tires.getTire1Pressure() < 1) {
            return true;
        }

        if (tires.getTire2Pressure() < 1) {
            return true;
        }

        if (tires.getTire3Pressure() < 1) {
            return true;
        }

        if (tires.getTire4Pressure() < 1) {
            return true;
        }
        return false;
    }

    public boolean enginePower() {
        return engine.getEnginePower() > 250;
    }
}
