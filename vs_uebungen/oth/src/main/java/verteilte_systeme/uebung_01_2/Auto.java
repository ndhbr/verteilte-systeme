package verteilte_systeme.uebung_01_2;

import java.util.Random;

public class Auto implements Runnable {
    String kennzeichen;
    Parkhaus parkhaus;

    public Auto(String kennzeichen, Parkhaus parkhaus) {
        this.kennzeichen = kennzeichen;
        this.parkhaus = parkhaus;
    }

    @Override
    public void run() {
        try {
            boolean result = this.parkhaus.autoEinfahren(this);

            if (result) {
                Thread.sleep(new Random().nextInt(10000));
                this.parkhaus.autoVerlassen();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
