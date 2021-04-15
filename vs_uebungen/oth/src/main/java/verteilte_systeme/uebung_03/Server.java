package verteilte_systeme.uebung_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server(String[] args, String host, int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("Warten auf Verbindungen...");
                Socket s = serverSocket.accept();
                System.out.println("Client hat sich verbunden");

                InputStream in = s.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                OutputStream out = s.getOutputStream();
                PrintWriter writer = new PrintWriter(out);

                writer.println("Willkommen auf dem Server, bitte gib deine Nachricht ein:");
                writer.flush();

                String antwort = reader.readLine();
                System.out.println("Antwort des Clients: " + antwort);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
