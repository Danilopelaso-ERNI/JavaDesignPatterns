package DesignPatterns.Plan;

import java.util.ArrayList;
import java.util.List;

interface Component {
    void render();
    void move();
}

class shape implements Component {
    @Override
    public void render() {
        System.out.println("Render shape");
    }

    @Override
    public void move() {
        System.out.println("Move shape");
    }
}

class Group implements Component {
    private List<Component> components = new ArrayList<>();

    public void add(Component shape) {
        components.add(shape);
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
        group1.add(new shape());
        group1.add(new shape());

        var group2 = new Group();
        group2.add(new shape());
        group2.add(new shape());

        var group = new Group();
        group.add(group1);
        group.add(group2);
        group.render();
        group.move();
    }

}
