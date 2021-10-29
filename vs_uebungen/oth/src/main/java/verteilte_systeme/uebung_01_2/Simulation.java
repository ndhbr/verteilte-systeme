package verteilte_systeme.uebung_01_2;

public class Simulation {
    Simulation() throws InterruptedException {
        // neues Parkhaus mit Kapazitaet fuer 10 Autos
        Parkhaus parkhaus = new Parkhaus(10);

        for (int i = 1; i <= 20; i++) {
            new Thread(new Auto("MAI-RH	" + i, parkhaus)).start();
        }

        Thread.sleep(30000);
        System.out.println("Ende der Simulation!");
    }
}
