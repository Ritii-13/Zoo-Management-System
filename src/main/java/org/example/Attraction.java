package org.example;

public class Attraction {
    private final int attractionID;
    private String name;
    private String description;
    private double price;
    private boolean attractionStatus;
    static int count = 0;
    private int visits = 0;
    public Attraction(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        count ++;
        this.attractionID = count;
        this.attractionStatus = true;
    }
    public int getAttractionID() {
        return attractionID;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean getAttractionStatus() {
        return attractionStatus;
    }

    public void setName(String Name) {
        name = Name;
    }

    public void setDescription(String Description) {
        description = Description;
    }

    public void setPrice(int Price) {
        price = Price;
    }

    public void setAttractionStatus(boolean b) {
        attractionStatus = b;
    }

    public int getVisits() {
        return visits;
    }
    public void setVisits() {
        this.visits = visits + 1;
    }
}
