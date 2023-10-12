/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sleepingBarber;

/**
 *
 * @author swani
 */
public class sleepingBarberMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numChairs = 4;
        BarberShop barberShop = new BarberShop(numChairs);

        Thread barberThread = new Thread(() -> {
            while (true) {
                try {
                    barberShop.barberCuttingHair(-1); // -1 indicates barber
                    Thread.sleep(1000); // Simulate time between haircuts
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        barberThread.start();

        for (int i = 0; i < 10; i++) {
            Thread customerThread = new Thread(new Customer(i, barberShop));
            customerThread.start();
        }
    }
}
