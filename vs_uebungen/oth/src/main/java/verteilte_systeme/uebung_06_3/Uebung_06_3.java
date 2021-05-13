package verteilte_systeme.uebung_06_3;

import verteilte_systeme.App;

public class Uebung_06_3 {
    public Uebung_06_3(String[] args) {
        if (args.length > 0) {
            int aufgabenNr = Integer.parseInt(args[0]);
            String[] slicedArgs = App.cutFirstElementOfArray(args);

            // select exercise
            switch (aufgabenNr) {
                default:
                case 1:
                    new Aufgabe_01(slicedArgs);
                    break;
            }
        }
    }
}
