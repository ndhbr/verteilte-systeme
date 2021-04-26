package verteilte_systeme.uebung_04;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public Client(String[] args, String host, int port) {
        try {
            Console console = System.console();
            Socket s = new Socket(host, port);
            InputStream in = s.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String response;

            OutputStream out = s.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            String eingang = reader.readLine();

            System.out.println(eingang);

            
            if (console != null) {
                response = console.readLine();
            } else {
                response = "Bruh, ich habe keine Antwortmöglichkeit";
            }

            writer.println(response);
            writer.flush();

            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
