package DesignPatterns.Plan;


interface TV {
    void on();
    void off();
    void tuneChannel(int channel);
}


class SonyTV implements TV {
    @Override
    public void on() {
        System.out.println("Sony TV: ON");
    }

    @Override
    public void off() {
        System.out.println("Sony TV: OFF");
    }

    @Override
    public void tuneChannel(int channel) {
        System.out.println("Sony TV: Channel " + channel);
    }
}


class SamsungTV implements TV {
    @Override
    public void on() {
        System.out.println("Samsung TV: ON");
    }

    @Override
    public void off() {
        System.out.println("Samsung TV: OFF");
    }

    @Override
    public void tuneChannel(int channel) {
        System.out.println("Samsung TV: Channel " + channel);
    }
}

abstract class RemoteControl {
    protected TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void setChannel(int channel);
}


class BasicRemoteControl extends RemoteControl {
    public BasicRemoteControl(TV tv) {
        super(tv);
    }

    @Override
    public void turnOn() {
        tv.on();
    }

    @Override
    public void turnOff() {
        tv.off();
    }

    @Override
    public void setChannel(int channel) {
        tv.tuneChannel(channel);
    }
}


class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(TV tv) {
        super(tv);
    }

    @Override
    public void turnOn() {
        tv.on();
    }

    @Override
    public void turnOff() {
        tv.off();
    }

    @Override
    public void setChannel(int channel) {
        tv.tuneChannel(channel);
    }

    public void setVolume(int volume) {
        System.out.println("Setting volume to " + volume);
    }
}


public class Bridge {
    public static void main(String[] args) {
        TV sonyTV = new SonyTV();
        RemoteControl sonyRemote = new BasicRemoteControl(sonyTV);
        sonyRemote.turnOn();
        sonyRemote.setChannel(5);
        sonyRemote.turnOff();

        TV samsungTV = new SamsungTV();
        RemoteControl samsungRemote = new AdvancedRemoteControl(samsungTV);
        samsungRemote.turnOn();
        samsungRemote.setChannel(10);
        ((AdvancedRemoteControl) samsungRemote).setVolume(15);
        samsungRemote.turnOff();
    }
}