package verteilte_systeme.uebung_01;

import java.util.Random;

public class Kunde implements Runnable {

    // Lager Parkhaus
    private Parkhaus parkhaus;

    Kunde(Parkhaus parkhaus) {
        this.parkhaus = parkhaus;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(new Random().nextInt(10000));
                Auto auto = parkhaus.autoVerkaufen();
                if (auto != null) {
                    System.out.println("Auto gekauft");
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
