package verteilte_systeme.uebung_02;

// import verteilte_systeme.App;

public class Uebung_02 {
    public Uebung_02(String[] args) {
        if (args.length > 0) {
            int aufgabenNr = Integer.parseInt(args[0]);
            // String[] slicedArgs = App.cutFirstElementOfArray(args);

            // select exercise
            switch (aufgabenNr) {
            default:
            case 1:
                new Aufgabe_01();
                break;
            case 2:
                new Aufgabe_02();
                break;
            }
        }
    }
}
