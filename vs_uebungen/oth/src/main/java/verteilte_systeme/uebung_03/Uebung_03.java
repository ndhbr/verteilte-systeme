package verteilte_systeme.uebung_03;

import verteilte_systeme.App;

public class Uebung_03 {
    public Uebung_03(String[] args) {
        if (args.length > 0) {
            int aufgabenNr = Integer.parseInt(args[0]);
            String[] slicedArgs = App.cutFirstElementOfArray(args);

            // select exercise
            switch (aufgabenNr) {
                default:
                case 1:
                    new Aufgabe_01(slicedArgs);
                    break;
                case 2:
                    new Aufgabe_02(slicedArgs);
                    break;
            }
        }
    }
}
