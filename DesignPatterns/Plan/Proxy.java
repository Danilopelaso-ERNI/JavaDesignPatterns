import java.util.HashMap;
import java.util.Map;

interface Ebook {
    void show();
    String getFileName();
}

class RealEbook implements Ebook {
    private String fileName;

    public RealEbook(String fileName) {
        this.fileName = fileName;
        load();
    }

    private void load() {
        System.out.println("Loading the ebook " + fileName);
    }

    @Override
    public void show() {
        System.out.println("Showing the ebook " + fileName);
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}

class EbookProxy implements Ebook {
    private String fileName;
    private RealEbook realEbook;

    public EbookProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void show() {
        if (realEbook == null) {
            realEbook = new RealEbook(fileName);
        }
        realEbook.show();
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}

class Library {
    private Map<String, Ebook> ebooks = new HashMap<>();

    public void add(Ebook ebook) {
        ebooks.put(ebook.getFileName(), ebook);
    }

    public void openEbook(String fileName) {
        ebooks.get(fileName).show();
    }
}

public class Proxy {
    public static void main(String[] args) {
        var library = new Library();
        String[] filenameStrings = {"a", "b", "c"};
        for (var filename : filenameStrings) {
            library.add(new EbookProxy(filename));
        }

        library.openEbook("a");
    }
}