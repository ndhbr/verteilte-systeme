package verteilte_systeme.uebung_01;

import java.util.Random;

public class Auto implements Runnable {

    // Kennzeichen des Autos
    private String kennzeichen;

    // Zu befahrenes Parkhaus
    private Parkhaus parkhaus;

    public Auto(String kennzeichen, Parkhaus parkhaus) {
        this.kennzeichen = kennzeichen;
        this.parkhaus = parkhaus;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10000));
            this.parkhaus.parkhausBefahren(this);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    public String getKennzeichen() {
        return this.kennzeichen;
    }
}
