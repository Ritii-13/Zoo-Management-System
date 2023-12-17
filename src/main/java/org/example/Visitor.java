package org.example;
import java.util.ArrayList;
import java.util.Iterator;

public class Visitor {
    private String name;
    private int age;
    private int phoneNumber;
    private double balance;
    private String email;
    private String password;
    private boolean loggedIn;
    private boolean basic_membership;
    private boolean premium_membership;
    private double money_spent;
    private ArrayList<Attraction> attractionsToVisit;
    private ArrayList<String> feedbacks;
    static final int OUT = 0;
    static final int IN = 1;


    public Visitor(String name, int age, int phoneNumber, double balance, String email, String password) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        attractionsToVisit = new ArrayList<Attraction>();
        feedbacks = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
    public double getBalance() {
        return balance;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public boolean getLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public boolean getBasic_membership() {
        return basic_membership;
    }
    public void setBasic_membership(boolean basic_membership) {
        this.basic_membership = basic_membership;
    }
    public boolean getPremium_membership() {
        return premium_membership;
    }
    public void setPremium_membership(boolean premium_membership) {
        this.premium_membership = premium_membership;
    }
    public void buyMembership(String membership, String code, Zoo zoo) {
        if (membership.equalsIgnoreCase("basic")) {
            this.setBasic_membership(true);
            this.setPremium_membership(false);
            if (code.equals(zoo.getMinor_discount_code()) && this.getAge() < 18) {
                this.setBalance(this.getBalance() - 20 + 20*zoo.getMinor_discount_amount()/100);
                money_spent += 20 - 20*zoo.getMinor_discount_amount()/100;
            }
            else if (code.equals(zoo.getSenior_discount_code()) && this.getAge() > 60) {
                this.setBalance(this.getBalance() - 20 + 20*zoo.getSenior_discount_amount()/100);
                money_spent += 20 - 20*zoo.getSenior_discount_amount()/100;
            }
            else {
                System.out.println("No code or incorrect code applied");
                this.setBalance(this.getBalance() - 20);
                money_spent += 20;
            }
        }
        else if (membership.equalsIgnoreCase("premium")) {
            this.setPremium_membership(true);
            this.setBasic_membership(false);
            if (code.equals(zoo.getMinor_discount_code()) && this.getAge() < 18) {
                this.setBalance(this.getBalance() - 50 + 50*zoo.getMinor_discount_amount()/100);
                money_spent += 50 - 50*zoo.getMinor_discount_amount()/100;
            }
            else if (code.equals(zoo.getSenior_discount_code()) && this.getAge() > 60) {
                this.setBalance(this.getBalance() - 50 + 50*zoo.getSenior_discount_amount()/100);
                money_spent += 50 - 50*zoo.getSenior_discount_amount()/100;
            }
            else {
                System.out.println("No code or incorrect code applied");
                this.setBalance(this.getBalance() - 50);
                money_spent += 50;
            }
        }
    }
    public void buyTickets(int attractionID, String code, Zoo zoo){
        for (Attraction attraction : zoo.getAttractions()) {
            if (attraction.getAttractionID() == attractionID) {
                if (this.getBasic_membership()) {
                    if (code.equals(zoo.getMinor_discount_code()) && this.getAge() < 18 && this.getBalance() > attraction.getPrice() - attraction.getPrice() * zoo.getMinor_discount_amount()/100) {
                        this.setBalance(this.getBalance() - attraction.getPrice() + attraction.getPrice() * zoo.getMinor_discount_amount()/100);
                        money_spent += attraction.getPrice() - attraction.getPrice() * zoo.getMinor_discount_amount()/100;
                    }
                    else if (code.equals(zoo.getSenior_discount_code()) && this.getAge() > 60 && this.getBalance() > attraction.getPrice() - attraction.getPrice() * zoo.getSenior_discount_amount()/100) {
                        this.setBalance(this.getBalance() - attraction.getPrice() + attraction.getPrice() * zoo.getSenior_discount_amount()/100);
                        money_spent += attraction.getPrice() - attraction.getPrice() * zoo.getSenior_discount_amount()/100;
                    }
                    else if (this.getBalance() > attraction.getPrice()) {
                        System.out.println("No code applied");
                        this.setBalance(this.getBalance() - attraction.getPrice());
                        money_spent += attraction.getPrice();
                    }
                    else {
                        System.out.println("You don't have enough balance!");
                        break;
                    }
                    System.out.println("Your remaining balance is " + this.getBalance());
                    System.out.println("Thank you for buying tickets for " + attraction.getName() + ". Hope you enjoy the attraction!");
                    attractionsToVisit.add(attraction);

                }
                else if (this.getPremium_membership()) {
                    System.out.println("You have a premium membership, no need to buy tickets!");
                }
                else {
                    System.out.println("You need to buy a membership first!");
                }
                if (attractionsToVisit.size() == 3) {
                    if (zoo.isDeal1()) {
                        this.setBalance(this.getBalance() + money_spent * 0.15);
                        System.out.println("Special deal applied! You get 15% of your money back!");
                        System.out.println("Your remaining balance is " + this.getBalance());
                        money_spent -= money_spent * 0.15;
                    }
                }
                else if (attractionsToVisit.size() > 3) {
                    if (zoo.isDeal2()){
                        this.setBalance(this.getBalance() + money_spent*0.30 - money_spent*0.15);
                        System.out.println("Special deal applied! You get 30% of your money back!");
                        System.out.println("Your remaining balance is " + this.getBalance());
                        money_spent = money_spent - money_spent * 0.30 + money_spent * 0.15;
                    }
                }
            }
        }
    }
    public void visitAttractions(int attractionID, Zoo zoo) {
        if (this.getBasic_membership()) {
            Iterator<Attraction> iterator = attractionsToVisit.iterator();
            boolean visited = false;

            while (iterator.hasNext()) {
                Attraction attraction = iterator.next();

                if (attraction.getAttractionID() == attractionID && attraction.getAttractionStatus()) {
                    System.out.println("Welcome to attraction " + attraction.getName());
                    System.out.println("1 ticket used");
                    System.out.println("Thank you for visiting " + attraction.getName() + ". Hope you enjoyed the attraction!");
                    iterator.remove(); // Safely remove the attraction from the list
                    visited = true;
                    attraction.setVisits();
                }
            }

            if (!visited) {
                System.out.println("You have not bought tickets for this attraction or Attraction is closed!");
            }
        }
        else if (this.getPremium_membership()) {
            boolean visited = false;
            for (Attraction attraction : zoo.getAttractions()) {
                if (attraction.getAttractionID() == attractionID && attraction.getAttractionStatus()) {
                    System.out.println("Welcome to attraction " + attraction.getName());
                    System.out.println("1 ticket used");
                    System.out.println("Thank you for visiting " + attraction.getName() + ". Hope you enjoyed the attraction!");
                    attraction.setVisits();
                    visited = true;
                }
            }
            if (!visited) {
                System.out.println("Attraction is closed!");
            }
        }
        else {
            System.out.println("You need to buy a membership first!");
        }
    }

    public void visitAnimal(String animalName, String action, Zoo zoo) {
        for (Animal animal : zoo.getAnimals()) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                if (action.equalsIgnoreCase("Feed")) {
                    animal.makeSound();
                    System.out.println("You fed " + animal.getName());
                }
                else if (action.equalsIgnoreCase("Read")) {
                    animal.getHistory();
                }
                else {
                    System.out.println("Choose an appropriate action");
                }
            }
        }
    }

    public void provideFeedback(String feedback) {
        if (countWords(feedback) > 200) {
            System.out.println("Feedback should be less than 200 words");
            return;
        }
        feedbacks.add(feedback);
        System.out.println("Thank you for the feedback");
    }
    public void viewFeedback() {
        for (String feedback : feedbacks) {
            System.out.println(feedback);
        }
        System.out.println("No more feedbacks to display.");
        System.out.println("-----------------------------------------");
    }
    public double getMoney_spent() {
        return money_spent;
    }
    public void exploreAttractions(Zoo zoo) {
        for (Attraction attraction : zoo.getAttractions()) {
            System.out.println("Attraction: " + attraction.getName());
            System.out.println("Attraction ID: " + attraction.getAttractionID());
            System.out.println("Description: " + attraction.getDescription());
            System.out.println("Price: " + attraction.getPrice());
            System.out.println("-----------------------------------------");
        }
    }
    public void exploreAnimals(Zoo zoo) {
        for (Animal animal : zoo.getAnimals()) {
            System.out.println("Name: " + animal.getName());
            System.out.println("Type: " + animal.getType());
            System.out.println("-----------------------------------------");
        }
    }
    public void viewDiscounts(Zoo zoo) {
        if (zoo.isMinor_discount()){
            System.out.println("Minor Discount applicable for visitors < 18");
            System.out.println("Discount: " + zoo.getMinor_discount_amount() + "%");
            System.out.println("Code: " + zoo.getMinor_discount_code());
        }
        else {
            System.out.println("No minor discount");
        }
        if (zoo.isSenior_discount()){
            System.out.println("Senior Discount applicable for visitors > 60");
            System.out.println("Discount: " + zoo.getSenior_discount_amount() + "%");
            System.out.println("Code: " + zoo.getSenior_discount_code());
        }
        else {
            System.out.println("No senior discount");
        }
        System.out.println("-----------------------------------------");

    }
    static int countWords(String str)
    {
        int state = OUT;
        int wc = 0;
        int i = 0;
        while (i < str.length())
        {
            if (str.charAt(i) == ' ' || str.charAt(i) == '\n'
                    || str.charAt(i) == '\t')
                state = OUT;
            else if (state == OUT)
            {
                state = IN;
                ++wc;
            }
            ++i;
        }
        return wc;
    }



}
