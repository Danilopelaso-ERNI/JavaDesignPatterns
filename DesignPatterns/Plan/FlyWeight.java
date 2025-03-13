package DesignPatterns.Plan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Character {
    private char symbol;
    private String font;

    public Character(char symbol, String font) {
        this.symbol = symbol;
        this.font = font;
    }

    public void display(int size, String color) {
        System.out.printf("Character: %c, Font: %s, Size: %d, Color: %s%n", symbol, font, size, color);
    }
}


class CharacterFactory {
    private static Map<String, Character> characters = new HashMap<>();

    public static Character getCharacter(char symbol, String font) {
        String key = symbol + font;
        Character character = characters.get(key);
        if (character == null) {
            character = new Character(symbol, font);
            characters.put(key, character);
        }
        return character;
    }
}

class TextEditor {
    private List<Character> characters = new ArrayList<>();

    public void addCharacter(char symbol, String font, int size, String color) {
        Character character = CharacterFactory.getCharacter(symbol, font);
        character.display(size, color);
        characters.add(character);
    }

    public void displayText() {
        for (Character character : characters) {
           
            character.display(12, "black");
        }
    }
}

public class FlyWeight {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.addCharacter('H', "Arial", 12, "black");
        textEditor.addCharacter('e', "Arial", 12, "black");
        textEditor.addCharacter('l', "Arial", 12, "black");
        textEditor.addCharacter('l', "Arial", 12, "black");
        textEditor.addCharacter('o', "Arial", 12, "black");
        textEditor.addCharacter(' ', "Arial", 12, "black");
        textEditor.addCharacter('W', "Arial", 12, "black");
        textEditor.addCharacter('o', "Arial", 12, "black");
        textEditor.addCharacter('r', "Arial", 12, "black");
        textEditor.addCharacter('l', "Arial", 12, "black");
        textEditor.addCharacter('d', "Arial", 12, "black");

        textEditor.displayText();
    }
}