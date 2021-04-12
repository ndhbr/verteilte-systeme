package verteilte_systeme.uebung_02;

import java.util.Random;

public class Student implements Runnable {
    // Theke
    KitchenCounter theke;

    // Name
    String name;

    public Student(KitchenCounter theke, String name) {
        this.theke = theke;
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();

        try {
            while (true) {
                theke.take();
                System.out.println("STUDENT: I hob ma a lebakassemme gnomma (" + theke.leberkasCounter + ")");
                Thread.sleep(random.nextInt(10000));
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
