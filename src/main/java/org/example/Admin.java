package org.example;
import java.util.*;
public class Admin implements Discountable{
    private String username;
    private String password;
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void checkAttractionStatus(int attractionID, Zoo zoo) {
        for (Attraction attraction : zoo.getAttractions()) {
            if (attraction.getAttractionID() == attractionID) {
                if (attraction.getAttractionStatus()) {
                    System.out.println("Attraction is open");
                } else {
                    System.out.println("Attraction is closed");
                }
            }
        }
    }
    public void setAttractionStatus(int attractionID, Zoo zoo, boolean status){
        for (Attraction attraction : zoo.getAttractions()) {
            if (attraction.getAttractionID() == attractionID) {
                attraction.setAttractionStatus(status);
            }
        }
    }
    public void setPriceForAttraction(int attractionID, Zoo zoo, int price) {
        for (Attraction attraction : zoo.getAttractions()) {
            if (attraction.getAttractionID() == attractionID) {
                attraction.setPrice(price);
            }
        }
    }

    public void addAttraction(String name, String description, double price, Zoo zoo) {
        zoo.getAttractions().add(new Attraction(name, description, price));
    }
    public void viewAttraction(int attractionID, Zoo zoo) {
        for (Attraction attraction : zoo.getAttractions()) {
            if (attraction.getAttractionID() == attractionID) {
                System.out.println("Name: " + attraction.getName());
                System.out.println("Attraction ID: " + attraction.getAttractionID());
                System.out.println("Description: " + attraction.getDescription());
                System.out.println("Price: " + attraction.getPrice());
                System.out.println("-----------------------------------------");
            }
        }
    }
    public void removeAttraction(int attractionID, Zoo zoo) {
        zoo.getAttractions().removeIf(attraction -> attraction.getAttractionID() == attractionID);
    }
    public void modifyAttraction(int attractionID, Zoo zoo) {
        for (Attraction attraction : zoo.getAttractions()) {
            if (attraction.getAttractionID() == attractionID) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter new name: ");
                String name = sc.nextLine();
                System.out.println("Enter new description: ");
                String description = sc.nextLine();
                System.out.println("Enter new price: ");
                int price = sc.nextInt();
                attraction.setName(name);
                attraction.setDescription(description);
                attraction.setPrice(price);
            }
        }
    }
    public void addAnimal(String name, String type, Zoo zoo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter animal history: ");
        String history = sc.nextLine();
        if (type.equalsIgnoreCase("Mammal")) {
            zoo.getAnimals().add(new Mammal(name, type, history));
        } else if (type.equalsIgnoreCase("Amphibian")) {
            zoo.getAnimals().add(new Amphibian(name, type, history));
        } else if (type.equalsIgnoreCase("Reptile")) {
            zoo.getAnimals().add(new Reptile(name, type, history));
        }
    }
    public void viewAnimal(String name, Zoo zoo) {
        for (Animal animal : zoo.getAnimals()) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.println("Name: " + animal.getName());
                System.out.println("Type: " + animal.getType());
                animal.getHistory();
                System.out.println("-----------------------------------------");
            }
        }
    }
    public void removeAnimal(String name, Zoo zoo) {
        zoo.getAnimals().removeIf(animal -> animal.getName().equalsIgnoreCase(name));
    }
    public void modifyAnimal(String name, Zoo zoo) {
        for (Animal animal : zoo.getAnimals()) {
            if (animal.getName().equalsIgnoreCase(name)) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter new name: ");
                String newName = sc.nextLine();
                System.out.println("Enter new type: ");
                String newType = sc.nextLine();
                System.out.println("Enter new history: ");
                String newHistory = sc.nextLine();
                animal.setName(newName);
                animal.setType(newType);
                animal.setHistory(newHistory);
            }
        }
    }
    @Override
    public void setDiscount(String type, int discount, String code, Zoo zoo) {
        if (type.equalsIgnoreCase("minor")) {
            zoo.setMinor_discount(true);
            zoo.setMinor_discount_amount(discount);
            zoo.setMinor_discount_code(code);
        } else if (type.equalsIgnoreCase("senior")) {
            zoo.setSenior_discount(true);
            zoo.setSenior_discount_amount(discount);
            zoo.setSenior_discount_code(code); // Corrected the method to set senior discount code
        } else {
            System.out.println("Invalid discount type");
        }
    }

    @Override
    public void removeDiscount(String type, Zoo zoo) {
        if(type.equalsIgnoreCase("minor")){
            zoo.setMinor_discount(false);
            zoo.setMinor_discount_amount(0);
            zoo.setMinor_discount_code("None");
        }
        else if(type.equalsIgnoreCase("senior")){
            zoo.setSenior_discount(false);
            zoo.setSenior_discount_amount(0);
            zoo.setMinor_discount_code("None");
        }
        else{
            System.out.println("Invalid discount type");
        }
    }

    @Override
    public void modifyDiscount(String type, Zoo zoo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new code: ");
        String code = sc.nextLine();
        if(type.equalsIgnoreCase("minor")){
            zoo.setMinor_discount_code(code);
        }
        else if(type.equalsIgnoreCase("senior")){
            zoo.setSenior_discount_code(code);
        }
        else{
            System.out.println("Invalid discount type");
        }
    }
    @Override
    public void viewDiscounts(Zoo zoo) {
        if(zoo.isMinor_discount()){
            System.out.println("Minor discount: " + zoo.getMinor_discount_amount() + "%");
            System.out.println("Code: " + zoo.getMinor_discount_code());
            System.out.println("-----------------------------------------");
        }
        if(zoo.isSenior_discount()){
            System.out.println("Senior discount: " + zoo.getSenior_discount_amount() + "%");
            System.out.println("Code: " + zoo.getSenior_discount_code());
            System.out.println("-----------------------------------------");
        }
        if (!zoo.isMinor_discount() && !zoo.isSenior_discount()) {
            System.out.println("No discounts available");
        }
    }

    public void setDeals(boolean deal1, boolean deal2, Zoo zoo){
        zoo.setDeal1(deal1);
        zoo.setDeal2(deal2);
    }
    public void visitorStats(Zoo zoo){
        System.out.println("Total visitors: " + zoo.getVisitors().size());
        int basic = 0;
        int premium = 0;
        for(Visitor visitor: zoo.getVisitors()){
            if(visitor.getBasic_membership()){
                basic++;
            }
            if(visitor.getPremium_membership()){
                premium++;
            }
        }
        System.out.println("Basic members: " + basic);
        System.out.println("Premium members: " + premium);
        System.out.println("Total revenue: " + zoo.getTotalRevenue());
        System.out.println("Popular attractions: " + zoo.getPopularAttractions());
        System.out.println("-----------------------------------------");
    }
    public void viewFeedbacks(Zoo zoo) {
        for (Visitor visitor : zoo.getVisitors()) {
            System.out.println("Name: " + visitor.getName());
            System.out.println("Email: " + visitor.getEmail());
            visitor.viewFeedback();
        }
    }



}

