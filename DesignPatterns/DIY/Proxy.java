package DesignPatterns.DIY;
import java.util.HashMap;
import java.util.Map;

interface Video {
    void play();
    String getFileName();
}

class RealVideo implements Video {
    private String fileName;

    public RealVideo(String fileName) {
        this.fileName = fileName;
        load();
    }

    private void load() {
        System.out.println("Loading the video " + fileName);
    }

    @Override
    public void play() {
        System.out.println("Playing the video " + fileName);
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}

class VideoProxy implements Video {
    private String fileName;
    private RealVideo realVideo;

    public VideoProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void play() {
        if (realVideo == null) {
            realVideo = new RealVideo(fileName);
        }
        realVideo.play();
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}

class VideoLibrary {
    private Map<String, Video> videos = new HashMap<>();

    public void add(Video video) {
        videos.put(video.getFileName(), video);
    }

    public void playVideo(String fileName) {
        videos.get(fileName).play();
    }
}

public class Proxy {
    public static void main(String[] args) {
        var library = new VideoLibrary();
        String[] fileNames = {"video1", "video2", "video3"};
        for (var fileName : fileNames) {
            library.add(new VideoProxy(fileName));
        }

        library.playVideo("video1");
        library.playVideo("video2");
        library.playVideo("video1"); 
    }
}