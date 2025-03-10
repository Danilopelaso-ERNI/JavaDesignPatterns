package DesignPatterns.Plan;

import java.util.ArrayList;
import java.util.List;

abstract class DialogBox {
    public abstract void changed(UIControl control);
}

abstract class UIControl {
    protected DialogBox owner;

    public UIControl(DialogBox owner) {
        this.owner = owner;
    }
}

class ArticlesDialogBox extends DialogBox {
    private ListBox articlesListBox = new ListBox(this);
    private TextBox titleTextBox = new TextBox(this);
    private Button saveButton = new Button(this);

    public void simulateUserInteraction() {
        articlesListBox.setSelection("Article 1");
        titleTextBox.setText("");
        saveButton.click();
        System.out.println("TextBox: " + titleTextBox.getText());
        System.out.println("Button: " + saveButton.isEnabled());
    }

    @Override
    public void changed(UIControl control) {
        if (control == articlesListBox) {
            articleSelected();
        } else if (control == titleTextBox) {
            titleChanged();
        }
    }

    private void articleSelected() {
        titleTextBox.setText(articlesListBox.getSelection());
        saveButton.setEnabled(true);
    }

    private void titleChanged() {
        var content = titleTextBox.getText();
        var isEmpty = (content == null || content.isEmpty());
        saveButton.setEnabled(!isEmpty);
    }
}

class ListBox extends UIControl {
    private String selection;

    public ListBox(DialogBox owner) {
        super(owner);
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
        owner.changed(this);
    }
}

class TextBox extends UIControl {
    private String text;

    public TextBox(DialogBox owner) {
        super(owner);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        owner.changed(this);
    }
}

class Button extends UIControl {
    private boolean isEnabled;

    public Button(DialogBox owner) {
        super(owner);
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
        owner.changed(this);
    }

    public void click() {
        owner.changed(this);
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        ArticlesDialogBox dialog = new ArticlesDialogBox();
        dialog.simulateUserInteraction();
    }
}