package verteilte_systeme.uebung_01_2;

public class Uebung_01_2 {
    public Uebung_01_2(String[] args) {
        try {
            new Simulation();            
        } catch (InterruptedException e) {
            System.out.println("InterruptedException " + e);
        }
    }
}
