# Vehicle.java

/**
 * Abstract base class representing a vehicle.
 */
public abstract class Vehicle {
    private String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;

    /**
     * Constructs a new Vehicle object.
     *
     * @param vehicleId      Unique vehicle ID
     * @param model           Vehicle model
     * @param baseRentalRate Base rental rate
     */
    public Vehicle(String vehicleId, String model, double baseRentalRate) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true; // Default availability
    }

    // Getters and setters with validation
    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Abstract methods
    public abstract double calculateRentalCost(int days);

    public abstract boolean isAvailableForRental();

    @Override
    public String toString() {
        return "Vehicle ID: " + vehicleId + ", Model: " + model + ", Base Rate: " + baseRentalRate + ", Available: " + isAvailable;
    }
}


# Car.java

/**
 * Concrete vehicle class representing a car.
 */
public class Car extends Vehicle {
    private boolean hasSunroof;

    /**
     * Constructs a new Car object.
     *
     * @param vehicleId      Unique vehicle ID
     * @param model           Vehicle model
     * @param baseRentalRate Base rental rate
     * @param hasSunroof     Whether the car has a sunroof
     */
    public Car(String vehicleId, String model, double baseRentalRate, boolean hasSunroof) {
        super(vehicleId, model, baseRentalRate);
        this.hasSunroof = hasSunroof;
    }

    @Override
    public double calculateRentalCost(int days) {
        // Additional charge for sunroof
        return getBaseRentalRate() * days * (hasSunroof ? 1.1 : 1);
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public String toString() {
        return super.toString() + ", Sunroof: " + hasSunroof;
    }
}


# Motorcycle.java

/**
 * Concrete vehicle class representing a motorcycle.
 */
public class Motorcycle extends Vehicle {
    private int engineCapacity;

    /**
     * Constructs a new Motorcycle object.
     *
     * @param vehicleId      Unique vehicle ID
     * @param model           Vehicle model
     * @param baseRentalRate Base rental rate
     * @param engineCapacity  Engine capacity in CC
     */
    public Motorcycle(String vehicleId, String model, double baseRentalRate, int engineCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        // Additional charge for high-capacity engines
        return getBaseRentalRate() * days * (engineCapacity > 650 ? 1.2 : 1);
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public String toString() {
        return super.toString() + ", Engine Capacity: " + engineCapacity + "CC";
    }
}


# Truck.java

/**
 * Concrete vehicle class representing a truck.
 */
public class Truck extends Vehicle {
    private int payloadCapacity;

    /**
     * Constructs a new Truck object.
     *
     * @param vehicleId      Unique vehicle ID
     * @param model           Vehicle model
     * @param baseRentalRate Base rental rate
     * @param payloadCapacity Payload capacity in tons
     */
    public Truck(String vehicleId, String model, double baseRentalRate, int payloadCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        // Additional charge for high-payload trucks
        return getBaseRentalRate() * days * (payloadCapacity > 5 ? 1.3 : 1);
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public String toString() {
        return super.toString() + ", Payload Capacity
