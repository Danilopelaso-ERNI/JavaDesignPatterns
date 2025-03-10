package DesignPatterns.DIY;

import java.util.ArrayList;
import java.util.List;

abstract class Mediator {
    public abstract void notify(User user, String message);
}

// Abstract Colleague
abstract class User {
    protected Mediator mediator;
    protected String name;

    public User(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

class ChatRoom extends Mediator {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void notify(User sender, String message) {
        for (User user : users) {
            if (user != sender) {
                user.receive(message);
            }
        }
    }
}

class ConcreteUser extends User {
    public ConcreteUser(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(name + " sends: " + message);
        mediator.notify(this, message);
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " receives: " + message);
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User user1 = new ConcreteUser(chatRoom, "User1");
        User user2 = new ConcreteUser(chatRoom, "User2");
        User user3 = new ConcreteUser(chatRoom, "User3");

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        user1.send("Hello everyone!");
        user2.send("Hi User1!");
        user3.send("Hey all!");
    }
}