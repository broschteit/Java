package geekbrains.level_3;

import java.util.concurrent.Semaphore;

public class FuelStation {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(3,true);
        System.out.println("Начало движения!");

        Vehicle[] vehicles = {
                new Car("Car1",sem),
                new Car("Car2",sem),
                new Car("Car3",sem),
                new Car("Car4",sem),
                new Track("Track1",sem),
                new Track("Track2",sem),
                new Track("Track3",sem),
                new Bus("Bus1",sem),
                new Bus("Bus2",sem),
                new Bus("Bus3",sem)
        };

        for (int i = 1; i < 10; i++) {
            final int threadNumber = i - 1;
            new Thread((Runnable) vehicles[threadNumber]).start();
        }

        }

    }


