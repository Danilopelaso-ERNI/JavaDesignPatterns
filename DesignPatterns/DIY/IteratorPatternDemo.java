package DesignPatterns.DIY;

import java.util.List;
import java.util.ArrayList;

interface Iterator<T> {
    boolean hasNext();
    T next();
}

class ConcreteIterator<T> implements Iterator<T> {
    private ConcreteAggregate<T> aggregate;
    private int index;

    public ConcreteIterator(ConcreteAggregate<T> aggregate) {
        this.aggregate = aggregate;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < aggregate.getItems().size();
    }

    @Override
    public T next() {
        return aggregate.getItems().get(index++);
    }
}

class ConcreteAggregate<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public Iterator<T> createIterator() {
        return new ConcreteIterator<>(this);
    }
}

public class IteratorPatternDemo {
    public static void main(String[] args) {
        ConcreteAggregate<String> aggregate = new ConcreteAggregate<>();
        aggregate.add("Item 1");
        aggregate.add("Item 2");
        aggregate.add("Item 3");

        Iterator<String> iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
    }
}