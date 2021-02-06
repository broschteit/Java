package geekbrains.level_3;

import java.util.concurrent.Semaphore;

public class Car extends Vehicle implements Runnable{

    private final double fuelVolume = 20;
    private final double fuelConsumption = 2.5;
    private double fuelLeft;
    Semaphore sem;
    private int num = 0;

    public Car(String name, Semaphore sem) {
        super(name, sem);
        this.sem = sem;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " начал движение");
        try {
            Thread.sleep(3000);
            fuelLeft = fuelVolume - fuelConsumption; //расчет первого расхода топлива
            System.out.println(this.getName() + ": осталось топлива - " + fuelLeft);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //6 секунд машины ездят
        for(int j=1;j<2;j++){
            try {
                Thread.sleep(3000);
                fuelLeft = fuelLeft - fuelConsumption; //расчет расхода топлива
                System.out.println(this.getName() + ": осталось топлива - " + fuelLeft);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //пора заправить машину
        try {
            sem.acquire();
                System.out.println(this.getName() + " начал заправку");
                Thread.sleep(5000);
                fuelLeft=fuelVolume;
                sem.release();
                System.out.println(this.getName() + " заправился, объем топлива: " + fuelLeft);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}

