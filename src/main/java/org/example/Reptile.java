package org.example;

public class Reptile extends Animal {
    private String history;

    public Reptile(String name, String type, String history) {
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
        System.out.println("Reptile sound");
    }
}
