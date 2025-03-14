package DesignPatterns.DIY;
interface Shape {
    void draw();
}

interface Circle extends Shape {
    void fill();
}

interface Square extends Shape {
    void fill();
}

interface ShapeFactory {
    Circle createCircle();
    Square createSquare();
}

class SimpleCircle implements Circle {
    @Override
    public void draw() {
        System.out.println("Simple Circle drawn");
    }

    @Override
    public void fill() {
        System.out.println("Simple Circle filled");
    }
}

class SimpleSquare implements Square {
    @Override
    public void draw() {
        System.out.println("Simple Square drawn");
    }

    @Override
    public void fill() {
        System.out.println("Simple Square filled");
    }
}

class SimpleShapeFactory implements ShapeFactory {
    @Override
    public Circle createCircle() {
        return new SimpleCircle();
    }

    @Override
    public Square createSquare() {
        return new SimpleSquare();
    }
}

class FancyCircle implements Circle {
    @Override
    public void draw() {
        System.out.println("Fancy Circle drawn");
    }

    @Override
    public void fill() {
        System.out.println("Fancy Circle filled");
    }
}

class FancySquare implements Square {
    @Override
    public void draw() {
        System.out.println("Fancy Square drawn");
    }

    @Override
    public void fill() {
        System.out.println("Fancy Square filled");
    }
}

class FancyShapeFactory implements ShapeFactory {
    @Override
    public Circle createCircle() {
        return new FancyCircle();
    }

    @Override
    public Square createSquare() {
        return new FancySquare();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        ShapeFactory factory;

        factory = new SimpleShapeFactory();
        Circle simpleCircle = factory.createCircle();
        Square simpleSquare = factory.createSquare();
        simpleCircle.draw();
        simpleCircle.fill();
        simpleSquare.draw();
        simpleSquare.fill();

        factory = new FancyShapeFactory();
        Circle fancyCircle = factory.createCircle();
        Square fancySquare = factory.createSquare();
        fancyCircle.draw();
        fancyCircle.fill();
        fancySquare.draw();
        fancySquare.fill();
    }
}