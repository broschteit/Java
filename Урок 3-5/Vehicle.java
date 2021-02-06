package geekbrains.level_3;

import java.util.concurrent.Semaphore;

public class Vehicle {
    private String name;
    private double fuelVolume;
    private double fuelConsumption;
    private double fuelLeft;
    Semaphore sem;

    public Vehicle(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
    }

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

