package verteilte_systeme.uebung_01;

import java.util.Deque;
import java.util.LinkedList;

public class Parkhaus {
    // Zählt wie viele Autos sich im Parkhaus befinden
    private int zaehler;

    // Hält alle eingeparkten Autos
    private Deque<Auto> autos;

    // Maximale Anzahl an Fahrzeugen im Parkhaus
    private int maximaleAnzahl;

    Parkhaus(int maximaleAnzahl) {
        this.maximaleAnzahl = maximaleAnzahl;
    }

    public synchronized void parkhausBefahren(Auto auto) {
        if (zaehler >= maximaleAnzahl) {
            System.out.println("  Warten an Schranke: " + auto.getKennzeichen());
        } else {
            System.out.println("Einfahrt: " + auto.getKennzeichen());
            if (this.autos == null) {
                this.autos = new LinkedList<Auto>();
            }
            this.autos.add(auto);
        }
    }

    public synchronized Auto autoVerkaufen() {
        Auto auto;

        if (this.autos != null) {
            if (this.autos.size() == 0) {
                System.out.println("Gerade kein Fahrzeug verfügbar");
            } else {
                auto = this.autos.pop();
                System.out.println("Auto verkauft: " + auto.getKennzeichen());
                return auto;
            }
        }

        return null;
    }

    public synchronized void parkhausVerlassen(Auto auto) {
        if (zaehler <= 2) {
            System.out.println("  Warten an Schranke: " + auto.getKennzeichen());
        } else {
            System.out.println("Ausfahrt: " + auto.getKennzeichen());
        }
    }
}