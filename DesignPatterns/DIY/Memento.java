package DesignPatterns.DIY;

import java.util.ArrayList;
import java.util.List;

class Calculator {
    private int value;

    public CalculatorState createState() {
        return new CalculatorState(value);
    }

    public void restore(CalculatorState state) {
        value = state.getValue();
    }

    public int getValue() {
        return value;
    }

    public void add(int number) {
        value += number;
    }

    public void subtract(int number) {
        value -= number;
    }
}

class CalculatorState {
    private final int value;

    public CalculatorState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

class History {
    private List<CalculatorState> states = new ArrayList<>();

    public void push(CalculatorState state) {
        states.add(state);
    }

    public CalculatorState pop() {
        if (states.isEmpty()) {
            return null;
        }
        var lastIndex = states.size() - 1;
        var lastState = states.get(lastIndex);
        states.remove(lastIndex);
        return lastState;
    }
}

public class Memento {
    public static void main(String[] args) {
        var calculator = new Calculator();
        var history = new History();

        calculator.add(10);
        history.push(calculator.createState());

        calculator.add(5);
        history.push(calculator.createState());

        calculator.subtract(3);
        history.push(calculator.createState());

        System.out.println("Current value: " + calculator.getValue()); 

        calculator.restore(history.pop());
        System.out.println("After undo: " + calculator.getValue()); 

        calculator.restore(history.pop());
        System.out.println("After undo: " + calculator.getValue()); 
    }
}