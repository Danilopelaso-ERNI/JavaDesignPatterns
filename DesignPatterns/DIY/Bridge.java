package DesignPatterns.DIY;

interface Device {
    void on();
    void off();
    void setSetting(int setting);
}

class SonyTV implements Device {
    @Override
    public void on() {
        System.out.println("Sony TV: ON");
    }

    @Override
    public void off() {
        System.out.println("Sony TV: OFF");
    }

    @Override
    public void setSetting(int setting) {
        System.out.println("Sony TV: Channel " + setting);
    }
}

class SamsungTV implements Device {
    @Override
    public void on() {
        System.out.println("Samsung TV: ON");
    }

    @Override
    public void off() {
        System.out.println("Samsung TV: OFF");
    }

    @Override
    public void setSetting(int setting) {
        System.out.println("Samsung TV: Channel " + setting);
    }
}

class PhilipsLight implements Device {
    @Override
    public void on() {
        System.out.println("Philips Light: ON");
    }

    @Override
    public void off() {
        System.out.println("Philips Light: OFF");
    }

    @Override
    public void setSetting(int setting) {
        System.out.println("Philips Light: Brightness " + setting);
    }
}

abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void setSetting(int setting);
}

class BasicRemoteControl extends RemoteControl {
    public BasicRemoteControl(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        device.on();
    }

    @Override
    public void turnOff() {
        device.off();
    }

    @Override
    public void setSetting(int setting) {
        device.setSetting(setting);
    }
}

class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        device.on();
    }

    @Override
    public void turnOff() {
        device.off();
    }

    @Override
    public void setSetting(int setting) {
        device.setSetting(setting);
    }

    public void setVolume(int volume) {
        System.out.println("Setting volume to " + volume);
    }
}

public class Bridge {
    public static void main(String[] args) {
        Device sonyTV = new SonyTV();
        RemoteControl sonyRemote = new BasicRemoteControl(sonyTV);
        sonyRemote.turnOn();
        sonyRemote.setSetting(5);
        sonyRemote.turnOff();

        Device samsungTV = new SamsungTV();
        RemoteControl samsungRemote = new AdvancedRemoteControl(samsungTV);
        samsungRemote.turnOn();
        samsungRemote.setSetting(10);
        ((AdvancedRemoteControl) samsungRemote).setVolume(15);
        samsungRemote.turnOff();

        Device philipsLight = new PhilipsLight();
        RemoteControl philipsRemote = new BasicRemoteControl(philipsLight);
        philipsRemote.turnOn();
        philipsRemote.setSetting(75);
        philipsRemote.turnOff();
    }
}