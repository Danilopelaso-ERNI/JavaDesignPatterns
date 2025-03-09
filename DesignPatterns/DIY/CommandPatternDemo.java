package DesignPatterns.DIY;

interface Command {
    void execute();
}

class TextEditor {
    public void bold() {
        System.out.println("Text is now bold.");
    }

    public void italicize() {
        System.out.println("Text is now italicized.");
    }
}

class BoldCommand implements Command {
    private TextEditor editor;

    public BoldCommand(TextEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.bold();
    }
}

class ItalicizeCommand implements Command {
    private TextEditor editor;

    public ItalicizeCommand(TextEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.italicize();
    }
}

class Button {
    private Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void click() {
        command.execute();
    }
}

public class CommandPatternDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        Command boldCommand = new BoldCommand(editor);
        Command italicizeCommand = new ItalicizeCommand(editor);

        Button boldButton = new Button(boldCommand);
        Button italicizeButton = new Button(italicizeCommand);

        boldButton.click(); 
        italicizeButton.click(); 
    }
}