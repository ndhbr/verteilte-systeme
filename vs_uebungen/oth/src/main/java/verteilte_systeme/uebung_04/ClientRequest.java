package verteilte_systeme.uebung_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientRequest implements Runnable {

    // Client socket
    Socket socket;

    // Messaging service
    MessagingService messagingService;

    public ClientRequest(Socket socket, MessagingService messagingService) {
        this.socket = socket;
        this.messagingService = messagingService;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            while (true) {
                String request = reader.readLine();
                System.out.println("Anfrage erhalten: " + request);
                processMessage(request, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processMessage(String message, PrintWriter writer) {
        String type = message.substring(0, 3);

        switch (type) {
            case "REG":
                // Register
                String username = message.substring(3);
                messagingService.addUser(new User(username));
                writer.println("User registered (" + username + ")");
                writer.flush();
                break;
            case "SND":
                // Send message
                String request[] = message.split("#");
                if (request.length == 3) {
                    String senderUsername = request[0].substring(3);
                    User sender = messagingService.getUser(senderUsername);
                    String receiverUsername = request[1];
                    User receiver = messagingService.getUser(receiverUsername);
    
                    if (sender != null && receiver != null) {
                        messagingService.addMessage(sender, receiver, request[2]);
                    }
                    writer.println("Message sent to " + receiverUsername);
                    writer.flush();
                }
                break;
            case "RCV":
                // Receive all new messages
                String receiver = message.substring(3);
                User user = messagingService.getUser(receiver);
                ArrayList<Message> messages = messagingService.getMessages(user);
                writer.println(messages.toString());
                writer.flush();
                break;
        }
    }
}
