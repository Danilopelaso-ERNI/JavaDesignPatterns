package DesignPatterns.DIY;
import java.util.Map;
import java.util.HashMap;



interface Message {
    void send(String recipient, String content);
}

class EmailMessage implements Message {
    @Override
    public void send(String recipient, String content) {
        System.out.println("Email sent to " + recipient + " with content: " + content);
    }
}

class SMSMessage implements Message {
    @Override
    public void send(String recipient, String content) {
        System.out.println("SMS sent to " + recipient + " with content: " + content);
    }
}

abstract class MessageSender {
    public void sendMessage(String recipient, String content) {
        var message = createMessage();
        message.send(recipient, content);
    }

    protected abstract Message createMessage();
}

class EmailMessageSender extends MessageSender {
    @Override
    protected Message createMessage() {
        return new EmailMessage();
    }
}

class SMSMessageSender extends MessageSender {
    @Override
    protected Message createMessage() {
        return new SMSMessage();
    }
}




public class FactoryMethod {
    public static void main(String[] args) {
         MessageSender emailsender = new EmailMessageSender();
         emailsender.sendMessage("Alice", "Hello Alice!");

         MessageSender smssender = new SMSMessageSender();
            smssender.sendMessage("Bob", "Hello Bob!");
    }
}
