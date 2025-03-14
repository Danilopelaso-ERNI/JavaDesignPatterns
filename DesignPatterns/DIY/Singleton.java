package DesignPatterns.DIY;

import java.util.Date;

class Logger {
    private static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void log(String message) {
        System.out.println(new Date() + ": " + message);
    }

}


public class Singleton {
    public static void main(String[] args) {
       Logger logger = Logger.getInstance();
         logger.log("Hello");

        Logger anotherLogger = Logger.getInstance();
        anotherLogger.log("World");
}

}
