package org.example;

public class Mammal extends Animal {
    private String history;

    public Mammal(String name, String type, String history) {
        super(name, type);
        this.history = history;
    }
    @Override
    public void getHistory() {
        System.out.println("History: " + history);
    }

    @Override
    public void setHistory(String history) {
        this.history = history;
    }

    @Override
    public void makeSound() {
        System.out.println("Mammal sound");
    }
}
