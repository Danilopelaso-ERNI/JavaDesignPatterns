package DesignPatterns.DIY;

interface Component {
    void render();
    Component clone();
}

class Circle implements Component {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void render() {
        System.out.println("Render a circle with radius: " + radius);
    }

    @Override
    public Component clone() {
        Circle clone = new Circle();
        clone.setRadius(this.radius);
        return clone;
    }



}


class Rectangle implements Component {
    private int width;
    private int height;


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override 
    public void render() {
        System.out.println("Render a rectangle with width: " + width + " and height: " + height);
    }

    @Override
    public Component clone() {
        Rectangle clone = new Rectangle();
        clone.setWidth(this.width);
        clone.setHeight(this.height);
        return clone;
    }

    
}

class ContextMenu {
    public void duplicate(Component component) {
        Component copy = component.clone();
        System.out.println("Duplicating a component");
        copy.render();
    }
}


public class Prototype {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(10);

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(20);
        rectangle.setHeight(30);

        ContextMenu contextMenu = new ContextMenu();
        contextMenu.duplicate(circle);
        contextMenu.duplicate(rectangle);
    }
}
