package DesignPatterns.DIY;

abstract class DataProcessor {
    public final void process() {
        readData();
        processData();
        saveData();
    }

    protected abstract void readData();

    protected abstract void processData();

    protected abstract void saveData();
}

class CsvDataProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading CSV data...");
    }

    @Override
    protected void processData() {
        System.out.println("Processing CSV data...");
    }

    @Override
    protected void saveData() {
        System.out.println("Saving CSV data...");
    }
}

class XmlDataProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading XML data...");
    }

    @Override
    protected void processData() {
        System.out.println("Processing XML data...");
    }

    @Override
    protected void saveData() {
        System.out.println("Saving XML data...");
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CsvDataProcessor();
        csvProcessor.process();
        DataProcessor xmlProcessor = new XmlDataProcessor();
        xmlProcessor.process();
    }
}