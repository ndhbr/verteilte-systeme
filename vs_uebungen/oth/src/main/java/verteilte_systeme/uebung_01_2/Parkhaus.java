package verteilte_systeme.uebung_01_2;

public class Parkhaus {
    int freieParkplaetze;

    public Parkhaus(int anzahlMaxAutos) {
        freieParkplaetze = anzahlMaxAutos;
    }

    public synchronized boolean autoEinfahren(Auto auto) {
        if (freieParkplaetze > 0) {
            freieParkplaetze--;

            System.out.println("Auto eingefahren (" + auto.kennzeichen + ")");
            return true;
        } else {
            System.out.println("Parkplatz voll");
            return false;
        }
    }

    public synchronized void autoVerlassen() {
        freieParkplaetze++;
        System.out.println("Auto verlassen");
    }
}
