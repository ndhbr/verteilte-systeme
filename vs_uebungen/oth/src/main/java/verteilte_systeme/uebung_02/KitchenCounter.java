package verteilte_systeme.uebung_02;

import java.util.concurrent.locks.*;

public class KitchenCounter {
    // Kapazität
    int capacity;

    // Anzahl vorrätiger Leberkässemmeln
    int leberkasCounter;

    // Concurrency
    Lock monitor = new ReentrantLock();
    Condition students = monitor.newCondition();
    Condition waiter = monitor.newCondition();

    public KitchenCounter(int capacity) {
        this.capacity = capacity;
    }

    // Lebakasseme eineleng
    void put() {
        monitor.lock();

        try {
            while (leberkasCounter >= capacity) {
                try {
                    waiter.await();
                } catch (InterruptedException e) {
                }
            }

            leberkasCounter++;

            students.signal();
        } finally {
            monitor.unlock();
        }
    }

    // Hui da a lebakassemme
    void take() {
        monitor.lock();

        try {
            while (leberkasCounter == 0) {
                try {
                    students.await();
                } catch (InterruptedException e) {
                }
            }

            leberkasCounter--;

            waiter.signal();
        } finally {
            monitor.unlock();
        }
    }
}
