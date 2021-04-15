package verteilte_systeme.uebung_03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Webserver {
    public Webserver(String[] args, String hostname, int port) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("Warten auf Verbindungen...");
                Socket s = serverSocket.accept();
                executorService.execute(new Webserver_Worker(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
