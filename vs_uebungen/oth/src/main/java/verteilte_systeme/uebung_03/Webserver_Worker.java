package verteilte_systeme.uebung_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Webserver_Worker implements Runnable {
    final String wwwPath = "vs_uebungen/oth/src/main/java/verteilte_systeme/uebung_03/www/";
    Socket s;

    public Webserver_Worker(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            System.out.println("Client Anfrage wird verarbeitet");

            InputStream in = s.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            OutputStream out = s.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            String request = reader.readLine();
            String[] requestParts = request.split(" ");
            String requestedPath = "index.html";

            if (requestParts != null && requestParts.length > 2 && !("/".equals(requestParts[1]))) {
               requestedPath = requestParts[1];
            }

            List<String> zeilen = Files.readAllLines(Paths.get(wwwPath + requestedPath));
            int size = zeilen.size();

            writeHTTPHeader(writer);

            for (int i = 0; i < size; i++) {
                writer.print(zeilen.get(i));
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeHTTPHeader(PrintWriter writer) {
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html");
        writer.println();
    }
}
