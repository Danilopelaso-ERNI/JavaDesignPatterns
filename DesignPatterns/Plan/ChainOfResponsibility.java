package DesignPatterns.Plan;

abstract class Handler {
    protected Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public abstract void handle(HttpRequest request);
}

class Authenticator extends Handler {
    public Authenticator(Handler next) {
        super(next);
    }

    @Override
    public void handle(HttpRequest request) {
        if (request.getUsername().equals("admin") && request.getPassword().equals("1234")) {
            System.out.println("Authentication successful");
            if (next != null) {
                next.handle(request);
            }
        } else {
            System.out.println("Authentication failed");
        }
    }
}

class Compressor extends Handler {
    public Compressor(Handler next) {
        super(next);
    }

    @Override
    public void handle(HttpRequest request) {
        System.out.println("Compressing request");
        if (next != null) {
            next.handle(request);
        }
    }
}

class Encryptor extends Handler {
    public Encryptor(Handler next) {
        super(next);
    }

    @Override
    public void handle(HttpRequest request) {
        System.out.println("Encrypting request");
        if (next != null) {
            next.handle(request);
        }
    }
}

class Logger extends Handler {
    public Logger(Handler next) {
        super(next);
    }

    @Override
    public void handle(HttpRequest request) {
        System.out.println("Logging request");
        if (next != null) {
            next.handle(request);
        }
    }
}

class HttpRequest {
    private String username;
    private String password;

    public HttpRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class WebServer {
    private Handler handler;

    public WebServer(Handler handler) {
        this.handler = handler;
    }

    public void handle(HttpRequest request) {
        handler.handle(request);
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        var encryptor = new Encryptor(null);
        var compressor = new Compressor(encryptor);
        var authenticator = new Authenticator(compressor);
        var logger = new Logger(authenticator);
        var server = new WebServer(logger);

        server.handle(new HttpRequest("admin", "1234"));
    }
}