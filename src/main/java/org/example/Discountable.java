package org.example;

public interface Discountable {
//    double applyDiscount(int age);
    void setDiscount(String type, int discount, String code, Zoo zoo);
    void removeDiscount(String type, Zoo zoo);

    void modifyDiscount(String code1, Zoo zoo);
    void viewDiscounts(Zoo zoo);
}
