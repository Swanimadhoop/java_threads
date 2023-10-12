/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sleepingBarber;

/**
 *
 * @author swani
 */
public class Customer implements Runnable {
    private int customerNum;
    private BarberShop barberShop;

    public Customer(int customerNum, BarberShop barberShop) {
        this.customerNum = customerNum;
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        try {
            barberShop.customerArrives(customerNum);
            Thread.sleep(1000); // Simulate time between customer arrival and getting haircut
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

