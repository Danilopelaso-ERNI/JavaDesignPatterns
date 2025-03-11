package DesignPatterns.DIY;

// Abstract Handler
abstract class SupportHandler {
    protected SupportHandler next;

    public SupportHandler(SupportHandler next) {
        this.next = next;
    }

    public abstract void handleRequest(SupportTicket ticket);
}

// Concrete Handler classes
class LevelOneSupport extends SupportHandler {
    public LevelOneSupport(SupportHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getLevel() == 1) {
            System.out.println("Level One Support handling ticket: " + ticket.getDescription());
        } else if (next != null) {
            next.handleRequest(ticket);
        }
    }
}

class LevelTwoSupport extends SupportHandler {
    public LevelTwoSupport(SupportHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getLevel() == 2) {
            System.out.println("Level Two Support handling ticket: " + ticket.getDescription());
        } else if (next != null) {
            next.handleRequest(ticket);
        }
    }
}

class LevelThreeSupport extends SupportHandler {
    public LevelThreeSupport(SupportHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getLevel() == 3) {
            System.out.println("Level Three Support handling ticket: " + ticket.getDescription());
        } else if (next != null) {
            next.handleRequest(ticket);
        }
    }
}

// SupportTicket class
class SupportTicket {
    private int level;
    private String description;

    public SupportTicket(int level, String description) {
        this.level = level;
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }
}


public class ChainOfResponsibility {
    public static void main(String[] args) {
        SupportHandler levelThreeSupport = new LevelThreeSupport(null);
        SupportHandler levelTwoSupport = new LevelTwoSupport(levelThreeSupport);
        SupportHandler levelOneSupport = new LevelOneSupport(levelTwoSupport);

        SupportTicket ticket1 = new SupportTicket(1, "Password reset");
        SupportTicket ticket2 = new SupportTicket(2, "Software installation");
        SupportTicket ticket3 = new SupportTicket(3, "System crash");

        levelOneSupport.handleRequest(ticket1);
        levelOneSupport.handleRequest(ticket2);
        levelOneSupport.handleRequest(ticket3);
    }
}