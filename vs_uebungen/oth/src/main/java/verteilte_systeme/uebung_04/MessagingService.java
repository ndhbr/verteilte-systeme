package verteilte_systeme.uebung_04;

import java.util.ArrayList;

public class MessagingService {
    private MessageStore messageStore;
    private ArrayList<User> users;

    public MessagingService() {
        messageStore = new MessageStore();
        users = new ArrayList<User>();
    }

    public void addMessage(User sender, User receiver, String text) {
        Message message = new Message(sender, receiver, text);
        messageStore.addMessage(message);
    }

    public ArrayList<Message> getMessages(User receiver) {
        return messageStore.getMessages(receiver);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }
}
