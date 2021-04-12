package verteilte_systeme.uebung_02;

public class Aufgabe_01 {
    public Aufgabe_01() {
        KitchenCounter theke = new KitchenCounter(4);
        new Thread(new Waiter(theke, "Kellner-1")).start();
        new Thread(new Waiter(theke, "Kellner-1")).start();

        for (int i = 1; i <= 8; i++) {
            new Thread(new Student(theke, "Student-" + i)).start();
        }
    }
}
