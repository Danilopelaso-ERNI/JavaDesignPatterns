package DesignPatterns.DIY;

interface Formatter {
    String format(String text);
}

class UppercaseFormatter implements Formatter {
    @Override
    public String format(String text) {
        return text.toUpperCase();
    }
}

class LowercaseFormatter implements Formatter {
    @Override
    public String format(String text) {
        return text.toLowerCase();
    }
}

interface Saver {
    void save(String text, String fileName);
}

class PlainTextSaver implements Saver {
    @Override
    public void save(String text, String fileName) {
        System.out.println("Saving " + fileName + " as plain text with content: " + text);
    }
}

class HtmlSaver implements Saver {
    @Override
    public void save(String text, String fileName) {
        System.out.println("Saving " + fileName + " as HTML with content: <html><body>" + text + "</body></html>");
    }
}

class TextEditor {
    private Formatter formatter;
    private Saver saver;

    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    public void setSaver(Saver saver) {
        this.saver = saver;
    }

    public void save(String text, String fileName) {
        String formattedText = formatter.format(text);
        saver.save(formattedText, fileName);
    }
}

public class Strategy {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

        textEditor.setFormatter(new UppercaseFormatter());
        textEditor.setSaver(new PlainTextSaver());
        textEditor.save("Hello, World!", "document1.txt");

        textEditor.setFormatter(new LowercaseFormatter());
        textEditor.setSaver(new HtmlSaver());
        textEditor.save("Hello, World!", "document2.html");
    }
}