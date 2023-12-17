package org.example;

public abstract class Animal {
    private String name;
    private String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public abstract void makeSound();
    public abstract void getHistory();
    public abstract void setHistory(String history);
    public void setName(String newName) {
        this.name = newName;
    }

    public void setType(String type) {
        this.type = type;
    }

}

