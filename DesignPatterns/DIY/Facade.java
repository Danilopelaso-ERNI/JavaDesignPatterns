package DesignPatterns.DIY;

class Light {
    public void turnOn() {
        System.out.println("Lights are ON");
    }

    public void turnOff() {
        System.out.println("Lights are OFF");
    }
}

class AirConditioning {
    public void turnOn() {
        System.out.println("Air Conditioning is ON");
    }

    public void turnOff() {
        System.out.println("Air Conditioning is OFF");
    }
}

class SecuritySystem {
    public void arm() {
        System.out.println("Security System is ARMED");
    }

    public void disarm() {
        System.out.println("Security System is DISARMED");
    }
}

class HomeAutomationFacade {
    private Light light;
    private AirConditioning airConditioning;
    private SecuritySystem securitySystem;

    public HomeAutomationFacade() {
        this.light = new Light();
        this.airConditioning = new AirConditioning();
        this.securitySystem = new SecuritySystem();
    }

    public void leaveHome() {
        light.turnOff();
        airConditioning.turnOff();
        securitySystem.arm();
        System.out.println("You have left the home.");
    }

    public void arriveHome() {
        light.turnOn();
        airConditioning.turnOn();
        securitySystem.disarm();
        System.out.println("Welcome home!");
    }
}

public class Facade {
    public static void main(String[] args) {
        HomeAutomationFacade homeAutomation = new HomeAutomationFacade();
        homeAutomation.arriveHome();
        homeAutomation.leaveHome();
    }
}