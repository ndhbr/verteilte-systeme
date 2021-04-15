package verteilte_systeme.uebung_03;

public class Aufgabe_02 {
    public Aufgabe_02(String[] args) {
        final int port = 80;
        final String hostname = "localhost";

        new Webserver(args, hostname, port);
    }
}
