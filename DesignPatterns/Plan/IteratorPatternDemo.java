package DesignPatterns.Plan;

import java.util.List;
import java.util.ArrayList;

interface Iterator {
    boolean hasNext();

    String next();
}

class BrowserHistoryIterator implements Iterator {
    private BrowserHistory history;
    private int index;

    public BrowserHistoryIterator(BrowserHistory history) {
        this.history = history;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < history.getUrls().size();
    }

    @Override
    public String next() {
        return history.getUrls().get(index++);
    }
}

class BrowserHistory {
    private List<String> urls = new ArrayList<>();

    public void push(String url) {
        urls.add(url);
    }

    public List<String> getUrls() {
        return urls;
    }

    public Iterator createIterator() {
        return new BrowserHistoryIterator(this);
    }
}

public class IteratorPatternDemo {
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();
        history.push("https://www.google.com");
        history.push("https://www.youtube.com");
        history.push("https://www.github.com");

        Iterator iterator = history.createIterator();
        while (iterator.hasNext()) {
            String url = iterator.next();
            System.out.println(url);
        }
    }
}