package verteilte_systeme.uebung_01;

public class Uebung_01 {
    public Uebung_01(String[] args) {
        try {
            new Simulation();            
        } catch (InterruptedException e) {
            System.out.println("InterruptedException " + e);
        }
    }
}
