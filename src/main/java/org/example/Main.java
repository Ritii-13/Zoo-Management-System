package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static boolean containsOnlyAlphabets(String input) {
        // Define a regular expression pattern to match only alphabets
        Pattern pattern = Pattern.compile("^[a-zA-Z ]+$");

        // Create a Matcher to match the input against the pattern
        Matcher matcher = pattern.matcher(input);

        // Check if the input contains only alphabets
        return matcher.matches();
    }

    public static boolean containsExactly10Digits(String input) {
        // Define a regular expression pattern to match exactly 10 digits
        Pattern pattern = Pattern.compile("^\\d{10}$");

        // Create a Matcher to match the input against the pattern
        Matcher matcher = pattern.matcher(input);

        // Check if the input contains exactly 10 digits
        return matcher.matches();
    }
    static Zoo zoo = new Zoo();
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Initializing ZOOtopia Portal...");
            System.out.println("Welcome to ZOOtopia!");
            System.out.println("--------------------------------");
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as a Visitor");
            System.out.println("3. View Special Deals");
            System.out.println("4. Exit");
            System.out.println("--------------------------------");
            System.out.print("Enter your choice: ");
            try {
                int choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        System.out.println("Enter username: ");
                        String admin_username = reader.readLine();
                        System.out.println("Enter password: ");
                        String admin_password = reader.readLine();
                        if (zoo.verifyAdminLogin(admin_username, admin_password)) {
                            System.out.println("You are logged in as admin!");
                            Admin admin = new Admin(admin_username, admin_password);
                            adminMenu(admin, reader);
                        }
                        else {
                            System.out.println("Login Failed!");
                        }
                        break;
                    case 2:
                        boolean run = true;
                        while (run) {
                            System.out.println("1. Register");
                            System.out.println("2. Login");
                            System.out.println("3. Exit");
                            System.out.print("Enter your choice: ");
                            try {
                                int choice2 = Integer.parseInt(reader.readLine());
                                switch (choice2) {
                                    case 1:
                                        System.out.println("Enter your name: ");
                                        String name = reader.readLine();
                                        if (containsOnlyAlphabets(name)) {
                                            System.out.println("Enter your age: ");
                                            int age = Integer.parseInt(reader.readLine());
                                            if (age < 0) {
                                                System.out.println("Invalid age!");
                                                break;
                                            }
                                            System.out.println("Enter your phone number: ");
                                            Integer phone_number = Integer.parseInt(reader.readLine());
                                            if (containsExactly10Digits(phone_number.toString())) {
                                                System.out.println("Enter your balance: ");
                                                double balance = Double.parseDouble(reader.readLine());
                                                System.out.println("Enter your email: ");
                                                String email = reader.readLine();
                                                System.out.println("Enter your password: ");
                                                String password = reader.readLine();
                                                Visitor visitor = new Visitor(name, age, phone_number, balance, email, password);
                                                zoo.updateVisitors(visitor);
                                                System.out.println("You are registered successfully!");
                                            } else {
                                                System.out.println("Invalid phone number!");
                                            }
                                        } else {
                                            System.out.println("Invalid name!");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Enter your email: ");
                                        String email = reader.readLine();
                                        System.out.println("Enter your password: ");
                                        String password = reader.readLine();
                                        zoo.verifyLogin(email, password);
                                        for (Visitor visitor : zoo.getVisitors()) {
                                            if (visitor.getLoggedIn()) {
                                                System.out.println("You are logged in!");
                                                visitorMenu(visitor, reader);
                                                run = false;
                                            } else {
                                                System.out.println("Login Failed!");
                                            }
                                        }
                                        break;
                                    case 3:
                                        run = false;
                                        break;
                                    default:
                                        System.out.println("Invalid choice!");
                                        break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid choice! Please enter a valid number");
                            }
                        }
                        break;
                    case 3:
                        zoo.viewDeals();
                        break;
                    case 4:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid choice! Please enter a valid number");
            }
        }
        reader.close();
        System.out.println("Thank you for coming to ZOOtopia! Hope you had fun :)");
    }
    private static void adminMenu(Admin admin, BufferedReader reader) throws IOException {
        boolean isAdminMenuRunning = true;
        while (isAdminMenuRunning) {
            System.out.println("Initializing Admin Menu...");
            System.out.println("ADMIN MENU");
            System.out.println("--------------------------------");
            System.out.println("1. Manage Attractions");
            System.out.println("2. Manage Animals");
            System.out.println("3. Schedule Events");
            System.out.println("4. Set Discounts");
            System.out.println("5. Set Special Deal");
            System.out.println("6. View Visitor Stats");
            System.out.println("7. View Feedback");
            System.out.println("8. Exit");
            System.out.println("--------------------------------");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(reader.readLine());

                switch(choice) {
                    case 1:
                        boolean attractionsRunning = true;
                        while (attractionsRunning) {
                            System.out.println("Manage Attractions");
                            System.out.println("--------------------------------");
                            System.out.println("1. Add Attraction");
                            System.out.println("2. View Attractions");
                            System.out.println("3. Modify Attraction");
                            System.out.println("4. Remove Attraction");
                            System.out.println("5. Exit");
                            System.out.println("--------------------------------");
                            System.out.print("Enter your choice: ");
                            try {
                                int choice2 = Integer.parseInt(reader.readLine());
                                switch (choice2) {
                                    case 1:
                                        System.out.println("Enter attraction name: ");
                                        String name = reader.readLine();
                                        System.out.println("Enter attraction description: ");
                                        String description = reader.readLine();
                                        System.out.println("Enter attraction price: ");
                                        double price = Double.parseDouble(reader.readLine());
                                        admin.addAttraction(name, description, price, zoo);
                                        System.out.println("Attraction added successfully!");
                                        break;
                                    case 2:
                                        System.out.println("Attractions: ");
                                        for (Attraction attraction1 : zoo.getAttractions()) {
                                            admin.viewAttraction(attraction1.getAttractionID(), zoo);
                                        }
                                        if (zoo.getAttractions().size() == 0) {
                                            System.out.println("No attractions to display!");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Enter attraction ID to be modified: ");
                                        int attractionID = Integer.parseInt(reader.readLine());
                                        admin.modifyAttraction(attractionID, zoo);
                                        System.out.println("Attraction modified successfully!");
                                        break;
                                    case 4:
                                        System.out.println("Enter attraction ID to be removed: ");
                                        int attractionID1 = Integer.parseInt(reader.readLine());
                                        admin.removeAttraction(attractionID1, zoo);
                                        System.out.println("Attraction removed successfully!");
                                        break;
                                    case 5:
                                        attractionsRunning = false;
                                        break;
                                    default:
                                        System.out.println("Invalid choice!");
                                }
                            }catch (NumberFormatException e){
                                System.out.println("Invalid choice! Please enter a valid number");
                            }
                        }
                        break;
                    case 2:
                        boolean animalsRunning = true;
                        while (animalsRunning) {
                            System.out.println("Manage Animals");
                            System.out.println("--------------------------------");
                            System.out.println("1. Add Animal");
                            System.out.println("2. View Animals");
                            System.out.println("3. Modify Animal");
                            System.out.println("4. Remove Animal");
                            System.out.println("5. Exit");
                            System.out.println("--------------------------------");
                            System.out.print("Enter your choice: ");
                            try {
                                int choice2 = Integer.parseInt(reader.readLine());
                                switch (choice2) {
                                    case 1:
                                        System.out.println("Enter animal name: ");
                                        String name = reader.readLine();
                                        System.out.println("Enter animal type: ");
                                        String type = reader.readLine();
                                        admin.addAnimal(name, type, zoo);
                                        System.out.println("Animal added successfully!");
                                        break;
                                    case 2:
                                        System.out.println("Animals: ");
                                        for (Animal animal : zoo.getAnimals()) {
                                            admin.viewAnimal(animal.getName(), zoo);
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Enter animal name to be modified: ");
                                        String animalName = reader.readLine();
                                        admin.modifyAnimal(animalName, zoo);
                                        System.out.println("Animal modified successfully!");
                                        break;
                                    case 4:
                                        System.out.println("Enter animal name to be removed: ");
                                        String animalName1 = reader.readLine();
                                        admin.removeAnimal(animalName1, zoo);
                                        System.out.println("Animal removed successfully!");
                                        break;
                                    case 5:
                                        animalsRunning = false;
                                        break;
                                    default:
                                        System.out.println("Invalid choice!");
                                }
                            }catch (NumberFormatException e){
                                System.out.println("Invalid choice! Please enter a valid number");
                            }
                        }
                        break;
                    case 3:
                        boolean eventsRunning = true;
                        while (eventsRunning) {
                            System.out.println("Schedule Events");
                            System.out.println("--------------------------------");
                            System.out.println("1. Check Event Status");
                            System.out.println("2. Modify Event Status");
                            System.out.println("3. Set Attraction Price");
                            System.out.println("4. Exit");
                            System.out.println("--------------------------------");
                            System.out.print("Enter your choice: ");
                            try {
                                int choice2 = Integer.parseInt(reader.readLine());
                                switch (choice2) {
                                    case 1:
                                        System.out.println("Enter Attraction ID: ");
                                        int attractionID = Integer.parseInt(reader.readLine());
                                        admin.checkAttractionStatus(attractionID, zoo);
                                        break;
                                    case 2:
                                        System.out.println("Enter Attraction ID whose status is to be modified: ");
                                        int eventID = Integer.parseInt(reader.readLine());
                                        System.out.println("Enter new status (true for open and false for close): ");
                                        boolean status = Boolean.parseBoolean(reader.readLine());
                                        admin.setAttractionStatus(eventID, zoo, status);
                                        System.out.println("Status modified successfully!");
                                        break;
                                    case 3:
                                        System.out.println("Enter Attraction ID whose price is to be set: ");
                                        int eventID1 = Integer.parseInt(reader.readLine());
                                        System.out.println("Enter new price: ");
                                        int price = Integer.parseInt(reader.readLine());
                                        admin.setPriceForAttraction(eventID1, zoo, price);
                                        System.out.println("Price set successfully!");
                                        break;
                                    case 4:
                                        eventsRunning = false;
                                        break;
                                    default:
                                        System.out.println("Invalid choice!");
                                }
                            }catch (NumberFormatException e){
                                System.out.println("Invalid choice! Please enter a valid number");
                            }
                        }
                        break;
                    case 4:
                        boolean discountsRunning = true;
                        while (discountsRunning) {
                            System.out.println("Set Discounts");
                            System.out.println("--------------------------------");
                            System.out.println("1. Add Discount");
                            System.out.println("2. View Discounts");
                            System.out.println("3. Modify Discount");
                            System.out.println("4. Remove Discount");
                            System.out.println("5. Exit");
                            System.out.println("--------------------------------");
                            System.out.print("Enter your choice: ");
                            try {
                                int choice2 = Integer.parseInt(reader.readLine());
                                switch (choice2) {
                                    case 1:
                                        System.out.println("Enter discount type: ");
                                        String type = reader.readLine();
                                        System.out.println("Enter discount code: ");
                                        String code = reader.readLine();
                                        System.out.println("Enter discount in numbers (for example 15 for 15%): ");
                                        int amount = Integer.parseInt(reader.readLine());
                                        admin.setDiscount(type, amount, code, zoo);
                                        System.out.println("Discount added successfully!");
                                        break;
                                    case 2:
                                        admin.viewDiscounts(zoo);
                                        break;
                                    case 3:
                                        System.out.println("Enter discount type to be modified: ");
                                        String type1 = reader.readLine();
                                        admin.modifyDiscount(type1, zoo);
                                        System.out.println("Discount modified successfully!");
                                        break;
                                    case 4:
                                        System.out.println("Enter discount type to be removed: ");
                                        String type2 = reader.readLine();
                                        admin.removeDiscount(type2, zoo);
                                        System.out.println("Discount removed successfully!");
                                        break;
                                    case 5:
                                        discountsRunning = false;
                                        break;
                                    default:
                                        System.out.println("Invalid choice!");
                                }
                            }catch (NumberFormatException e){
                                System.out.println("Invalid choice! Please enter a valid number");
                            }

                        }
                        break;
                    case 5:
                        System.out.println("Deal 1: Visit over 2 attractions and get 15% of your money back!");
                        System.out.println("Deal 2: Visit over 3 attractions and get 30% of your money back!");
                        System.out.println("Enter true or false for deal 1 to be set");
                        boolean deal1 = Boolean.parseBoolean(reader.readLine());
                        System.out.println("Enter true or false for deal 2 to be set");
                        boolean deal2 = Boolean.parseBoolean(reader.readLine());
                        admin.setDeals(deal1, deal2, zoo);
                        System.out.println("Deals set successfully!");
                        break;
                    case 6:
                        admin.visitorStats(zoo);
                        break;
                    case 7:
                        admin.viewFeedbacks(zoo);
                        break;
                    case 8:
                        isAdminMenuRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid choice! Please enter a valid number");
            }
        }
    }
    private static void visitorMenu(Visitor visitor, BufferedReader reader) throws IOException {
        boolean isVisitorRunning = true;
        while (isVisitorRunning) {
            System.out.println("Initializing Admin Menu...");
            System.out.println("VISITOR MENU");
            System.out.println("--------------------------------");
            System.out.println("1. Explore the Zoo");
            System.out.println("2. Buy Membership");
            System.out.println("3. Buy Tickets");
            System.out.println("4. View Discounts");
            System.out.println("5. View Special Deals");
            System.out.println("6. Visit Animals");
            System.out.println("7. Visit Attractions");
            System.out.println("8. Leave Feedback");
            System.out.println("9. Log Out");
            System.out.println("--------------------------------");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(reader.readLine());
                switch(choice) {
                    case 1:
                        boolean exploreRunning = true;
                        while (exploreRunning) {
                            System.out.println("Explore the Zoo");
                            System.out.println("--------------------------------");
                            System.out.println("1. View Attractions");
                            System.out.println("2. View Animals");
                            System.out.println("3. Exit");
                            System.out.println("--------------------------------");
                            System.out.print("Enter your choice: ");
                            try {
                                int choice1 = Integer.parseInt(reader.readLine());
                                switch (choice1) {
                                    case 1:
                                        System.out.println("Attractions: ");
                                        visitor.exploreAttractions(zoo);
                                        break;
                                    case 2:
                                        System.out.println("Animals: ");
                                        visitor.exploreAnimals(zoo);
                                        break;
                                    case 3:
                                        exploreRunning = false;
                                        break;
                                    default:
                                        System.out.println("Invalid choice!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid choice! Please enter a valid number");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Enter the membership you wish to purchase (basic or premium): ");
                        String membership = reader.readLine();
                        System.out.println("Enter discount code if applicable else enter None: ");
                        String code = reader.readLine();
                        visitor.buyMembership(membership, code, zoo);
                        System.out.println("Membership purchased successfully!");
                        System.out.println("Your remaining balance is: " + visitor.getBalance());
                        break;
                    case 3:
                        System.out.println("Attractions: ");
                        visitor.exploreAttractions(zoo);
                        System.out.println("Enter ID of the attraction you wish to purchase tickets for: ");
                        int attractionID = Integer.parseInt(reader.readLine());
                        System.out.println("Enter discount code if applicable else enter None: ");
                        String code1 = reader.readLine();
                        visitor.buyTickets(attractionID, code1, zoo);
                        break;
                    case 4:
                        visitor.viewDiscounts(zoo);
                        break;
                    case 5:
                        zoo.viewDeals();
                        break;
                    case 6:
                        System.out.println("Animals: ");
                        visitor.exploreAnimals(zoo);
                        System.out.println("Enter name of animal you wish to visit: ");
                        String animalName = reader.readLine();
                        System.out.println("Enter 'Feed' if you wish to feed the animal or enter 'Read' if you wish to read about the animal: ");
                        String action = reader.readLine();
                        visitor.visitAnimal(animalName, action, zoo);
                        break;
                    case 7:
                        System.out.println("Attractions: ");
                        visitor.exploreAttractions(zoo);
                        System.out.println("Enter ID of the attraction you wish to visit: ");
                        int attractionID1 = Integer.parseInt(reader.readLine());
                        visitor.visitAttractions(attractionID1, zoo);
                        break;
                    case 8:
                        System.out.println("Enter your feedback in not more than 200 words: ");
                        String feedback = reader.readLine();
                        visitor.provideFeedback(feedback);
                        break;
                    case 9:
                        isVisitorRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid choice! Please enter a valid number");
            }
        }
    }
}
