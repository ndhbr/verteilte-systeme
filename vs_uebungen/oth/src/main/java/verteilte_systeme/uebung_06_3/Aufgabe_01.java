package verteilte_systeme.uebung_06_3;

import verteilte_systeme.App;

public class Aufgabe_01 {
    public Aufgabe_01(String[] args) {
        final int port = 1337;
        final String hostname = "localhost";

        if (args.length > 0) {
            String type = args[0];
            String[] slicedArgs = App.cutFirstElementOfArray(args);

            // select type
            switch (type) {
                default:
                case "server":
                    new Server(slicedArgs, hostname, port);
                    break;
                case "client":
                    new Client(slicedArgs, hostname, port);
                    break;
            }
        }
    }
}
