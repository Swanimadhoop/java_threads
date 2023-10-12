/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sleepingBarber;

import java.util.concurrent.Semaphore;

/**
 *
 * @author swani
 */

public class BarberShop {
    private Semaphore chairs;
    private Semaphore barberChair;
    private Semaphore barberReady;

    public BarberShop(int numChairs) {
        chairs = new Semaphore(numChairs, true);
        barberChair = new Semaphore(1, true);
        barberReady = new Semaphore(0, true);
    }

    public void customerArrives(int customerNum) throws InterruptedException {
        if (chairs.tryAcquire()) {
            System.out.println("Customer " + customerNum + " takes a chair.");
            barberChair.release(); // Signal barber that a customer is waiting
            barberReady.acquire(); // Wait for barber to be ready
            System.out.println("Customer " + customerNum + " is getting a haircut.");
        } else {
            System.out.println("Customer " + customerNum + " leaves because no chairs available.");
        }
    }

    public void barberCuttingHair(int customerNum) throws InterruptedException {
        barberChair.acquire(); // Wait for customer
        chairs.release(); // Free up a chair
        System.out.println("Barber is cutting hair for Customer " + customerNum);
        Thread.sleep(1000); // Simulate haircut
        System.out.println("Barber is done cutting hair for Customer " + customerNum);
        barberReady.release(); // Signal customer that barber is ready
    }
}
