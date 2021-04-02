package verteilte_systeme.uebung_01;

public class Uebung_01 {
    public Uebung_01() {
        try {
            new Simulation();            
        } catch (InterruptedException e) {
            System.out.println("InterruptedException " + e);
        }
    }
}
