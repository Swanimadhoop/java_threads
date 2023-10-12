/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiningPhilosophersProblem;

/**
 *
 * @author swani
 */
public class Philosopher implements Runnable {
    private int id;
    private fork leftFork;
    private fork rightFork;

    public Philosopher(int id, fork leftFork, fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Philosopher " + id + " is thinking.");
                Thread.sleep((int) (Math.random() * 1000));

                System.out.println("Philosopher " + id + " is hungry.");
                leftFork.pickUp();
                System.out.println("Philosopher " + id + " picked up left fork.");
                rightFork.pickUp();
                System.out.println("Philosopher " + id + " picked up right fork.");
                
                System.out.println("Philosopher " + id + " is eating.");
                Thread.sleep((int) (Math.random() * 1000));

                leftFork.putDown();
                System.out.println("Philosopher " + id + " put down left fork.");
                rightFork.putDown();
                System.out.println("Philosopher " + id + " put down right fork.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
