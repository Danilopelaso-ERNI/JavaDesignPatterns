package DesignPatterns.Plan;
class Message {
    private String content;

    public Message(String content) {
        this.content = content;
    }
}

class NotificationServer {
    public Connection connect(String ipAddress) {
        return new Connection();
    }

    public AuthToken authenticate(String appId, String key) {
        return new AuthToken();
    }

    public void send(AuthToken token, Message message, String target) {
        System.out.println("Sending a message");
    }
}

class Connection {
    public void disconnect() {
        System.out.println("Disconnected");
    }
}

class AuthToken {
    
}

class NotificationFacade {
    private NotificationServer server;
    private Connection connection;
    private AuthToken authToken;

    public NotificationFacade() {
        this.server = new NotificationServer();
    }

    public void sendNotification(String ipAddress, String appId, String key, String messageContent, String target) {
        this.connection = server.connect(ipAddress);
        this.authToken = server.authenticate(appId, key);
        Message message = new Message(messageContent);
        server.send(authToken, message, target);
        connection.disconnect();
    }
}

public class Facade {
    public static void main(String[] args) {
        NotificationFacade facade = new NotificationFacade();
        facade.sendNotification("ip", "appID", "key", "Hello World", "target");
    }
}