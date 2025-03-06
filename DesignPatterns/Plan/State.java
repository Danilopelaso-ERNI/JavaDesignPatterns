package DesignPatterns.Plan;


class Canvas{
    private Tool currentTool;

    public void mouseDown(){
        currentTool.mouseDown();
        
    }

    public void mouseUp(){
        currentTool.mouseUp();
    }

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }

}

enum ToolType{
    SELECTION,
    BRUSH,
    ERASER
}


interface Tool {

    void mouseDown();
    void mouseUp();
} 


class SelectionTool implements Tool{

    @Override
    public void mouseDown() {
        System.out.println("Selection Icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw dashed rectangle");
    }
}

class BrushTool implements Tool {
    @Override
    public void mouseDown() {
        System.out.println("Brush Icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw a line");
    }
}

public class State {
    public static void main(String[] args) {
        var canvas = new Canvas();
        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();
    }
}