package DesignPatterns.DIY;

class MusicPlayer {
    private PlayerState currentState;

    public void playButton() {
        currentState.play();
    }

    public void pauseButton() {
        currentState.pause();
    }

    public void stopButton() {
        currentState.stop();
    }

    public PlayerState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(PlayerState currentState) {
        this.currentState = currentState;
    }
}

enum PlayerStateType {
    PLAYING,
    PAUSED,
    STOPPED
}

interface PlayerState {
    void play();
    void pause();
    void stop();
}

class PlayingState implements PlayerState {
    @Override
    public void play() {
        System.out.println("Already playing");
    }

    @Override
    public void pause() {
        System.out.println("Pausing the music");
    }

    @Override
    public void stop() {
        System.out.println("Stopping the music");
    }
}

class PausedState implements PlayerState {
    @Override
    public void play() {
        System.out.println("Resuming the music");
    }

    @Override
    public void pause() {
        System.out.println("Already paused");
    }

    @Override
    public void stop() {
        System.out.println("Stopping the music");
    }
}

class StoppedState implements PlayerState {
    @Override
    public void play() {
        System.out.println("Starting the music");
    }

    @Override
    public void pause() {
        System.out.println("Cannot pause. Music is stopped");
    }

    @Override
    public void stop() {
        System.out.println("Already stopped");
    }
}

public class State {
    public static void main(String[] args) {
        var musicPlayer = new MusicPlayer();

        musicPlayer.setCurrentState(new StoppedState());
        musicPlayer.playButton();
        musicPlayer.pauseButton();
        musicPlayer.stopButton();

        musicPlayer.setCurrentState(new PlayingState());
        musicPlayer.playButton();
        musicPlayer.pauseButton();
        musicPlayer.stopButton();

        musicPlayer.setCurrentState(new PausedState());
        musicPlayer.playButton();
        musicPlayer.pauseButton();
        musicPlayer.stopButton();
    }
}