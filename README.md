# ZooBuddies - A Zoo Management Application

## Table of Contents
- [Introduction](#introduction)
- [Application Flow](#application-flow)
- [Features](#features)
    - [Admin Functionalities](#admin-functionalities)
    - [Visitor Functionalities](#visitor-functionalities)
- [Classes](#classes)
    - [Main Class](#main-class)
    - [Admin Class](#admin-class)
    - [Visitor Class](#visitor-class)
    - [Zoo Class](#zoo-class)
    - [Attraction Class](#attraction-class)
    - [Animal Abstract Class](#animal-abstract-class)
    - [Mammal Subclass of Animal](#mammal-subclass-of-animal)
    - [Amphibian Subclass of Animal](#amphibian-subclass-of-animal)
    - [Reptile Subclass of Animal](#reptile-subclass-of-animal)
    - [Discountable Interface](#discountable-interface)

## Introduction

Welcome to ZooBuddies, the revolutionary zoo management application developed using Object-Oriented Programming (OOP) principles.
All assumptions have been explained in detail in Application Flow and Classes.
The program can be run by running the generated jar file using java -jar <path ot jar file>.

## Application Flow

ZooBuddies provides an intuitive interface for both admins and visitors. Here's how the application flows:

### Admin Functionalities

- Enter as Admin: Admins can log in with their username and password to access admin privileges. Login is possible iff the username is "admin" and the password is "admin123".
- Manage Attractions/Events: Admins can add, modify, view, or remove attractions in the zoo. Attractions are free for premium members, and basic members must buy tickets. Each attraction gets assigned a unique attraction ID when added.
- Schedule Events: Admins can set whether an attraction is open or closed and ticket prices.
- Manage Animals: Admins add, modify, view, or remove animals in specific attractions. Three animal types are supported: Mammals, Amphibians, and Reptiles.
- Set Discounts: Admins set discounts for minors and senior citizens.
- Set Special Deals: Two types of deals are available and Admin can decide whether to enable both of them, one of them or none.
- View Visitor Stats: Admins access statistics on visitors, revenue, and popular attractions.
- View Feedback: Admins can read feedback left by visitors.

### Visitor Functionalities

- Register: Visitors register with their personal information such as name, age, phone number, balance, email, and password.
- Log In: Registered visitors can log in with their email and password.
- Explore the Zoo: Visitors can browse through attractions and animals.
- Buy Membership: Visitors can purchase basic or premium memberships. Discounts for minor or senior can be applied by visitors if applicable by entering the discount code.
- Buy Tickets: Basic members need to buy tickets for attractions. Discounts for minor or senior can be applied by visitors if applicable by entering the discount code. Special deals are applied automatically for ticket purchases if they have been set by the admin. If more than 2 tickets are purchased then 15% discount is applied, if more than 3 tickets are purchased then instead of 15% discount, 30% discount is applied.
- View Discounts: Visitors can view available discounts and apply them to their ticket purchase.
- View Special Deals: Visitors can view available special deals.
- Visit Animal: Visitors can choose to feed or read about animals. Feeding animals results in them creating a sound which can be either mammal sound, reptile sound or amphibian sound depending on which animal has been fed.
- Visit Attractions/Events: Visitors can visit attractions if they are premium members or if they are basic members but have bought tickets for the attraction they are choosing to visit.
- Provide Feedback: Visitors can leave feedback about their zoo experience.

## Classes

### Main Class
- Entry point of the application
- Contains the main method which initializes the ZOOtopia portal
- Admin and Visitor menus created in private static void AdminMenu(Admin admin, BufferedReader br) and private static void VisitorMenu(Visitor visitor, BufferedReader br) methods respectively.
- Error handling done for invalid inputs.
- Try-catch blocks used to handle exceptions.

### Admin Class
- Takes username and password as input
- Contains methods to:
    i) Add, modify, view, or remove attractions in the zoo
    ii) Set whether an attraction is open or closed and ticket prices
    iii) Add, modify, view, or remove animals
    iv) Set, view, remove and modify discounts for minors and senior citizens
    v) Set special deals
    vi) View visitor stats
    vii) View feedback
- implements Discountable interface to set, remove and modify discounts for minors and senior citizens

### Visitor Class
- Takes name, age, phone number, balance, email, and password as input
- Contains methods to:
    i) Browse through attractions and animals
    ii) Purchase basic or premium memberships
    iii) Purchase tickets
    iv) View available discounts and apply them to ticket purchase
    v) Visit animals and either feed or read about them
    vi) Visit attractions
    vii) Leave feedback
- Contains appropriate getters and setters

### Zoo Class
- This class acts as a database for the application
- Contains methods to:
    i) Verify visitor login
    ii) Verify admin login
    iii) Calculate total revenue generated
    iv) Determine popular attractions
    v) View special deals
- Contains appropriate getters and setters

### Attraction Class
- Takes attraction name, description and price as input and generates a unique id for each attraction.
- Contains appropriate getters and setters which have been used in other classes.

### Animal Abstract Class
- It is an abstract class which takes animal name and animal type as input
- Contains abstract methods to:
    i) Make animal sound
    ii) Get and set history of animal
- Contains appropriate getters and setters

### Mammal Subclass of Animal
- Extends Animal class
- Implements methods of animal class by using @Override and also takes history as input

### Amphibian Subclass of Animal
- Extends Animal class
- Implements methods of animal class by using @Override and also takes history as input

### Reptile Subclass of Animal
- Extends Animal class
- Implements methods of animal class by using @Override and also takes history as input

### Discountable Interface
- Contains methods to:
    i) Set discounts for minors and senior citizens
    ii) Remove discounts for minors and senior citizens
    iii) Modify discounts for minors and senior citizens
- Implemented by Admin class
