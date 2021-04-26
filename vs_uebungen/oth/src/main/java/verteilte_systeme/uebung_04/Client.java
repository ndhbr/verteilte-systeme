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

            OutputStream out = s.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            while (s != null) {
                if (console != null) {
                    System.out.print("Eingabe: ");
                    String request = console.readLine();

                    if (request == "EXIT") {
                        s.close();
                        s = null;
                        break;
                    }

                    writer.println(request);
                    writer.flush();
                }

                String response = reader.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
