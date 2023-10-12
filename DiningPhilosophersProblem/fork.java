/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiningPhilosophersProblem;

/**
 *
 * @author swani
 */
public class fork {
    private boolean isAvailable = true;

    public synchronized void pickUp() throws InterruptedException {
        while (!isAvailable) {
            wait();
        }
        isAvailable = false;
    }

    public synchronized void putDown() {
        isAvailable = true;
        notify();
    }
}

