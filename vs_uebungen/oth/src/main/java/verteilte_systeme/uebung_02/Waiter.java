package verteilte_systeme.uebung_02;

import java.util.Random;

public class Waiter implements Runnable {
    // Theke
    KitchenCounter theke;

    // Name
    String name;

    public Waiter(KitchenCounter theke, String name) {
        this.theke = theke;
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();

        try {
            while (true) {
                theke.put();
                System.out.println("WAITER: I leg etz moi a Lebakassemme eine (" + theke.leberkasCounter + ")");
                Thread.sleep(random.nextInt(5000));
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
