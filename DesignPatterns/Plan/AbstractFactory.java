package DesignPatterns.Plan;

interface Widget {
    void render();
}

interface Button extends Widget {
    void onClick();
}

interface TextBox extends Widget {
    void onInput();
}

interface WidgetFactory {
    Button createButton();
    TextBox createTextBox();
}

class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Windows Button");
    }

    @Override
    public void onClick() {
        System.out.println("Windows Button Clicked");
    }
}

class WindowsTextBox implements TextBox {
    @Override
    public void render() {
        System.out.println("Windows TextBox");
    }

    @Override
    public void onInput() {
        System.out.println("Windows TextBox Input");
    }
}

class WindowsWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextBox createTextBox() {
        return new WindowsTextBox();
    }
}

class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Mac Button");
    }

    @Override
    public void onClick() {
        System.out.println("Mac Button Clicked");
    }
}

class MacTextBox implements TextBox {
    @Override
    public void render() {
        System.out.println("Mac TextBox");
    }

    @Override
    public void onInput() {
        System.out.println("Mac TextBox Input");
    }
}

class MacWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextBox createTextBox() {
        return new MacTextBox();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        WidgetFactory factory;

        factory = new WindowsWidgetFactory();
        Button windowsButton = factory.createButton();
        TextBox windowsTextBox = factory.createTextBox();
        windowsButton.render();
        windowsButton.onClick();
        windowsTextBox.render();
        windowsTextBox.onInput();

        factory = new MacWidgetFactory();
        Button macButton = factory.createButton();
        TextBox macTextBox = factory.createTextBox();
        macButton.render();
        macButton.onClick();
        macTextBox.render();
        macTextBox.onInput();
    }
}