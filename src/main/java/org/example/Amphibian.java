package org.example;

public class Amphibian extends Animal {
    private String history;

    public Amphibian(String name, String type, String history) {
        super(name, type);
        this.history = history;
    }
    @Override
    public void setHistory(String history) {
        this.history = history;
    }
    @Override
    public void getHistory() {
        System.out.println("History: " + history);
    }
    @Override
    public void makeSound() {
        System.out.println("Amphibian sound");
    }
}
