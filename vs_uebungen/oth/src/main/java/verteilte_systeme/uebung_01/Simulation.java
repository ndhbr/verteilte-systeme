package verteilte_systeme.uebung_01;

import java.util.Random;

public class Simulation {
    Simulation() throws InterruptedException {
        Parkhaus parkhaus = new Parkhaus(10);
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            new Thread(new Kunde(parkhaus)).start();
        }

        while (true) {
            new Thread(new Auto("MAI-RH " + random.nextInt(10000), parkhaus)).start();
            Thread.sleep(2000);
        }
    }
}
