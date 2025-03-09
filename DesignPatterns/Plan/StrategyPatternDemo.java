package DesignPatterns.Plan;

interface Compressor {
    void compress(String fileName);
}

class JpegCompressor implements Compressor {
    @Override
    public void compress(String fileName) {
        System.out.println("Compressing " + fileName + " using JPEG compression");
    }
}

class PngCompressor implements Compressor {
    @Override
    public void compress(String fileName) {
        System.out.println("Compressing " + fileName + " using PNG compression");
    }
}

interface Filter {
    void apply(String fileName);
}

class BlackAndWhiteFilter implements Filter {
    @Override
    public void apply(String fileName) {
        System.out.println("Applying Black & White filter to " + fileName);
    }
}

class SepiaFilter implements Filter {
    @Override
    public void apply(String fileName) {
        System.out.println("Applying Sepia filter to " + fileName);
    }
}

class ImageStorage {
    private Compressor compressor;
    private Filter filter;

    public void setCompressor(Compressor compressor) {
        this.compressor = compressor;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public void store(String fileName) {
        filter.apply(fileName);
        compressor.compress(fileName);
        System.out.println("Storing " + fileName);
    }
}

public class StrategyPatternDemo {
    public static void main(String[] args) {
        ImageStorage imageStorage = new ImageStorage();

        imageStorage.setFilter(new BlackAndWhiteFilter());
        imageStorage.setCompressor(new JpegCompressor());
        imageStorage.store("photo1.jpg");

        imageStorage.setFilter(new SepiaFilter());
        imageStorage.setCompressor(new PngCompressor());
        imageStorage.store("photo2.png");
    }
}