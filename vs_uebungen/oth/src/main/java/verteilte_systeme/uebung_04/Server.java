package verteilte_systeme.uebung_04;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public Server(String[] args, String host, int port) {
        MessagingService messagingService = new MessagingService();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("Warten auf Verbindungen...");
                Socket s = serverSocket.accept();
                executorService.execute(new ClientRequest(s, messagingService));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
