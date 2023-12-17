package org.example;

import java.util.ArrayList;

public class Zoo{
    private ArrayList<Attraction> attractions;
    private ArrayList<Animal> animals;
    private ArrayList<Visitor> visitors;
    private boolean minor_discount;
    private boolean senior_discount;
    private double minor_discount_amount;
    private double senior_discount_amount;
    private String minor_discount_code;
    private String senior_discount_code;
    private double revenue;
    boolean deal1;
    boolean deal2;
    public Zoo() {
        attractions = new ArrayList<Attraction>();
        animals = new ArrayList<Animal>();
        visitors = new ArrayList<Visitor>();
    }
    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    public void updateAttractions(Attraction attraction) {
        attractions.add(attraction);
    }
    public void updateAnimals(Animal animal) {
        animals.add(animal);
    }
    public void updateVisitors(Visitor visitor) {
        visitors.add(visitor);
    }
    public void verifyLogin(String email, String password) {
        for (Visitor visitor : visitors) {
            if (visitor.getEmail().equals(email) && visitor.getPassword().equals(password)) {
                visitor.setLoggedIn(true);
            }
            else {
                visitor.setLoggedIn(false);
            }
        }

    }
    public boolean verifyAdminLogin(String username, String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            return true;
        }
        else {
            return false;
        }
    }

    public double getMinor_discount_amount() {
        return minor_discount_amount;
    }
    public double getSenior_discount_amount() {
        return senior_discount_amount;
    }
    public void setMinor_discount_amount(double minor_discount_amount) {
        this.minor_discount_amount = minor_discount_amount;
    }
    public void setSenior_discount_amount(double senior_discount_amount) {
        this.senior_discount_amount = senior_discount_amount;
    }
    public String getMinor_discount_code() {
        return minor_discount_code;
    }
    public String getSenior_discount_code() {
        return senior_discount_code;
    }
    public void setMinor_discount_code(String minor_discount_code) {
        this.minor_discount_code = minor_discount_code;
    }
    public void setSenior_discount_code(String senior_discount_code) {
        this.senior_discount_code = senior_discount_code;
    }

    public boolean isMinor_discount() {
        return minor_discount;
    }
    public boolean isSenior_discount() {
        return senior_discount;
    }
    public void setMinor_discount(boolean minor_discount) {
        this.minor_discount = minor_discount;
    }
    public void setSenior_discount(boolean senior_discount) {
        this.senior_discount = senior_discount;
    }

    public void setDeal1(boolean deal1) {
        this.deal1 = deal1;
    }

    public void setDeal2(boolean deal2) {
        this.deal2 = deal2;
    }

    public boolean isDeal1() {
        return deal1;
    }
    public boolean isDeal2() {
        return deal2;
    }
    public double getTotalRevenue(){
        for (Visitor visitor : visitors) {
            revenue += visitor.getMoney_spent();
        }
        return revenue;
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }
    public String getPopularAttractions(){
        Attraction pop_attr = attractions.get(0);
        for (Attraction attraction : attractions) {
            if (attraction.getVisits() > pop_attr.getVisits()) {
                pop_attr = attraction;
            }
        }
        return pop_attr.getName();
    }
    public void viewDeals(){
        if (deal1) {
            System.out.println("Deal 1: Visit over 2 attractions and get 15% of your money back!");
        }
        if (deal2) {
            System.out.println("Deal 2: Visit over 3 attractions and get 30% of your money back!");
        }
        if (!deal1 && !deal2) {
            System.out.println("No deals available");
        }
    }
}
