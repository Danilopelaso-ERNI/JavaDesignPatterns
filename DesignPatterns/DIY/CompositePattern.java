package DesignPatterns.DIY;

import java.util.ArrayList;
import java.util.List;

interface Component {
    void render();
    void move();
}


class Circle implements Component {
    @Override
    public void render() {
        System.out.println("Render Circle");
    }

    @Override
    public void move() {
        System.out.println("Move Circle");
    }
}


class Square implements Component {
    @Override
    public void render() {
        System.out.println("Render Square");
    }

    @Override
    public void move() {
        System.out.println("Move Square");
    }
}


class Group implements Component {
    private List<Component> components = new ArrayList<>();

    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void render() {
        for (var component : components)
            component.render();
    }

    @Override
    public void move() {
        for (var component : components)
            component.move();
    }
}


public class CompositePattern { 
    public static void main(String[] args) {
        var group1 = new Group();
        group1.add(new Circle());
        group1.add(new Square());

        var group2 = new Group();
        group2.add(new Circle());
        group2.add(new Square());

        var group = new Group();
        group.add(group1);
        group.add(group2);
        group.render();
        group.move();
    }
}
