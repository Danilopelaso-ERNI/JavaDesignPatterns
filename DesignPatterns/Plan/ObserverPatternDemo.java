package DesignPatterns.Plan;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

class DataSource {
    private List<Observer> observers = new ArrayList<>();
    private int value;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }

    public int getValue() {
        return value;
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class SpreadSheet implements Observer {
    private DataSource dataSource;

    public SpreadSheet(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("Spreadsheet updated with value: " + dataSource.getValue());
    }
}

class Chart implements Observer {
    private DataSource dataSource;

    public Chart(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("Chart updated with value: " + dataSource.getValue());
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();

        SpreadSheet sheet1 = new SpreadSheet(dataSource);
        SpreadSheet sheet2 = new SpreadSheet(dataSource);
        Chart chart = new Chart(dataSource);

        dataSource.addObserver(sheet1);
        dataSource.addObserver(sheet2);
        dataSource.addObserver(chart);

        dataSource.setValue(1);  
    }
}