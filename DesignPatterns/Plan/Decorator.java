package DesignPatterns.Plan;

interface Stream {
    void write(String data);
}


class CloudStream implements Stream{
    @Override
    public void write(String data) {
        System.out.println("Storing " + data);
    }
}


abstract class StreamDecorator implements Stream {
    private Stream stream;

    public StreamDecorator(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void write(String data) {
        stream.write(data);
    }
}


class EncryptedCloudStream extends StreamDecorator {
    public EncryptedCloudStream(Stream stream) {
        super(stream);
    }

    @Override
    public void write(String data) {
        var encrypted = encrypt(data);
        super.write(encrypted);
    }

    private String encrypt(String data) {
        return "@#$%^&*^%$#";
    }
}

class CompressesCloudStream extends StreamDecorator {
    public CompressesCloudStream(Stream stream) {
        super(stream);
    }


    @Override
    public void write(String data) {
        var compressed = compress(data);
        super.write(compressed);
    }

    private String compress(String data) {
        return data.substring(0, 5);
    }
}



public class Decorator {
    public static void main(String[] args) {
        var cloudStream = new CloudStream();
        Stream encryptedStream = new EncryptedCloudStream(cloudStream);
        Stream compressedStream = new CompressesCloudStream(encryptedStream);


        compressedStream.write("hello danilo");
    }


     
}


