package DesignPatterns.Plan;

interface Component {
    void render();
    Component clone()
    
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
        System.out.println("Render a circle");
    }

    @Override
    public Component clone() {
        Circle clone = new Circle();
        clone.setRadius(this.radius);
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

        ContextMenu contextMenu = new ContextMenu();
        contextMenu.duplicate(circle);
    }
}
