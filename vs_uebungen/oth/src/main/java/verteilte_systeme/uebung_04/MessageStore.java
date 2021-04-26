package verteilte_systeme.uebung_04;

import java.util.ArrayList;

public class MessageStore {
    private ArrayList<Message> messages;

    public MessageStore() {
        this.messages = new ArrayList<Message>();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public ArrayList<Message> getMessages(User receiver) {
        ArrayList<Message> messages = new ArrayList<Message>();
        
        for (Message message : messages) {
            if (message.getReceiver().equals(receiver)) {
                messages.add(message);
            }
        }

        return messages;
    }
}
